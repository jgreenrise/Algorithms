public class a_0424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, winLen = 0, n = s.length(), ans = Integer.MIN_VALUE, maxlen = 0;
        int[] map = new int[26]; // Freq map
        boolean matchFound = false;

        while (r < n) {

            char chAtR = s.charAt(r);
            map[chAtR - 'A']++;
            winLen = r - l + 1;
            maxlen = Integer.max(maxlen, map[chAtR - 'A']);

            while (l < n && (winLen - maxlen) > k) {
                ans = Math.max(ans, r - l);
                map[s.charAt(l) - 'A']--;
                l++;
                winLen = r - l + 1;
                matchFound = true;
            }
            r++;
        }

        if (!matchFound)
            return winLen;                  // AABB, k = 2

        if (r - l > ans)
            ans = Math.max(ans, r - l);     // ABAA, k = 0

        return ans;

    }
}
