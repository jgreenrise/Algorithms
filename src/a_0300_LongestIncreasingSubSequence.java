import java.util.Arrays;

public class a_0300_LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {


        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int i = 1;
        int j = 0;
        int n = nums.length;

        while (i < n) {
            j = 0;
            while (j < i) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
            i++;
        }

        int ans = 0;
        for (int num : dp) {
            ans = Math.max(num, ans);
        }

        return ans;
    }
}
