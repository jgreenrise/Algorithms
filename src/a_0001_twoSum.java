import java.util.HashMap;
import java.util.Map;

public class a_0001_twoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap();

        for (int j = 0; j < nums.length; j++) {

            if (map.containsKey(target - nums[j])) {
                return new int[]{map.get(target - nums[j]), j};
            } else {
                map.put(nums[j], j);
            }

        }

        return null;


    }

}
