import java.util.Arrays;

public class a_0300_LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int i = 0, j = 0;
        while (j < n) {
            if (i == j) {
                // Reset i,j
                i = 0;
                j = j + 1;
            } else {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
                i++;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int k : dp) {
            ans = Math.max(ans, k);
        }

        return ans;
    }
}
