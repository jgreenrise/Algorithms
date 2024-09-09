public class a_0209_MinSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0, ans = Integer.MAX_VALUE, curr = 0, n = nums.length;
        boolean matchFound = false;

        while (r < n) {
            curr += nums[r];

            while (curr >= target) {
                ans = Math.min(ans, r - l + 1);
                curr = curr - nums[l];
                l++;
                matchFound = true;
            }

            r++;
        }

        return !matchFound ? 0 : ans;

    }

}
