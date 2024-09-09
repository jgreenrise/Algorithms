public class a_0424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, n = s.length(), len = 0;
        int[] map = new int[26];
        int ans = Integer.MIN_VALUE; // len of longest susbstring
        int maxRepeatCount = 0; // Count of max repeating chars so far

        while (r < n) {

            // Expand the window
            map[s.charAt(r) - 'A']++;
            maxRepeatCount = Math.max(maxRepeatCount, map[s.charAt(r) - 'A']);

            // Shrink the window
            while ((r - l + 1) - maxRepeatCount > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }

            ans = Integer.max(ans, (r - l + 1));
            r++;

        }

        return ans;

    }
}
