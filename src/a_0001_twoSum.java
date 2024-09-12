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

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) return true; // check if mid is perfect square
            if (mid * mid < num) { // mid is small -> go right to increase mid
                left = mid + 1;
            } else {
                right = mid - 1; // mid is large -> to left to decrease mid
            }
        }
        return false;
    }

}
