import java.util.HashSet;
import java.util.Set;

public class a_0003_LongestSubStringWithoutRepeatingChars {

    // Longest Substring > Two pointer
    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) {
            return 0;
        } else if (s.trim().isEmpty()) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, n = s.length(), ans = Integer.MIN_VALUE;

        if (n == 1) {
            return 1;
        }

        while (right < n) {

            char ch = s.charAt(right);
            if (set.contains(ch)) {
                int winLen = right - left;
                ans = Math.max(ans, winLen);
                while (left < n && set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            set.add(ch);
            right++;

        }
        ans = Math.max(ans, right - left);
        return ans;
    }

}
