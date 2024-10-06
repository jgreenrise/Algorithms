public class a_0209_MinSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0, n = nums.length, ans = Integer.MAX_VALUE, currAns = 0;
        boolean matchFound = false;

        while (right < n) {

            currAns += nums[right];

            while (left < n && currAns >= target) {
                ans = Math.min(ans, right - left + 1);
                currAns = currAns - nums[left];
                left++;
                matchFound = true;
            }

            right++;
        }

        return matchFound ? ans : 0;

    }

}
