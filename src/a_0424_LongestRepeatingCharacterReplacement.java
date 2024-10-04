public class a_0424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int left = 0, right = 0, winLen = 0, maxlen = Integer.MIN_VALUE, ans = 0, n = s.length();
        int[] freqMap = new int[26];
        boolean matchFound = false;

        while (right < n) {

            char currChar = s.charAt(right);
            freqMap[currChar - 'A']++;
            maxlen = Integer.max(maxlen, freqMap[currChar - 'A']);
            winLen = right - left + 1;

            if (winLen - maxlen > k) {
                //System.out.println("left: "+left+", right: "+right+", maxLen: "+maxlen+", winLen: "+winLen);
                ans = Math.max(ans, right - left);
                char leftChar = s.charAt(left);
                if (left < n && s.charAt(left) == leftChar) {
                    freqMap[leftChar - 'A']--;
                    left++;
                }
                matchFound = true;
            }

            right++;
        }

        if (!matchFound) {
            return s.length();
        } else {
            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
