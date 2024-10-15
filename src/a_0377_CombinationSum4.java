import java.util.HashMap;
import java.util.Map;

public class a_0377_CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        return cs4(nums, target, map, 0);
    }

    public int cs4(int[] nums, int target, Map<Integer, Integer> map, int currSum) {
        if (currSum == target) return 1;
        else if (currSum > target) return 0;
        else {
            int combinations = 0;
            for (int num : nums) {
                if (map.containsKey(num + currSum)) {
                    combinations += map.get(num + currSum);
                } else {
                    combinations += cs4(nums, target, map, currSum + num);
                }
            }
            map.put(currSum, combinations);
            return combinations;
        }
    }

}
