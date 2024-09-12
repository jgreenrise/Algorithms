import java.util.HashMap;
import java.util.Map;

public class a_198_houseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return nums[n - 1] > nums[n - 2] ? nums[n - 1] : nums[n - 2];
        }

        nums[2] = nums[2] + nums[0];
        for (int k = 3; k < nums.length; k++) {
            int maxProfit = nums[k - 2] >= nums[k - 3] ? nums[k - 2] : nums[k - 3];
            nums[k] = nums[k] + maxProfit;
        }

        return nums[n - 1] > nums[n - 2] ? nums[n - 1] : nums[n - 2];

    }

    public int robUsingRecursion(int[] nums) {

        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        if (n == 0)
            return 0;

        if (n == 1)
            return nums[0];

        for (int j = 0; j < 2; j++) {
            ans = Math.max(ans, dfs(j, nums, n, map));
        }

        return ans;
    }

    public int dfs(int idx, int[] nums, int n, Map<Integer, Integer> map) {

        if (map.containsKey(idx))
            return map.get(idx);

        if (idx > n)
            return 0;

        if ((idx + 1) > n && (idx + 2) > n)
            return 0;

        int out = nums[idx] + Integer.max(dfs(idx + 2, nums, n, map), dfs(idx + 3, nums, n, map));
        map.put(idx, out);
        return out;
    }
}
