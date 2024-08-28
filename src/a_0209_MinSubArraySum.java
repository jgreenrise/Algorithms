public class a_0209_MinSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0, n = nums.length;
        int ans = Integer.MAX_VALUE;
        int curr = 0;
        int len = 0; // window len
        boolean matchFound = false;

        while (l < n && r < n && l <= r) {
            if (curr + nums[r] >= target) {
                len = r - l + 1;
                ans = Math.min(ans, len);
                curr -= nums[l];
                l++;
                matchFound = true;
            } else {
                curr += nums[r];
                r++;
            }

        }

        return matchFound ? ans : 0;

    }

}
