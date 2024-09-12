package template;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class SubStringProblemsTemplate {

    public static void main(String[] args) {
        SubStringProblemsTemplate longestCommonPrefix = new SubStringProblemsTemplate();
        System.out.println(longestCommonPrefix.templateSubStringProblems("jbpnbwwd"));
    }

    public int templateSubStringProblems(String s) {

        // Check for edge cases
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        // Step 1: Use a int array as a hashmap since every character has its unique ASCII value.
        int[] map = new int[128];
        int l = 0, r = 0, n = s.length();
        int len = 0;    // Window length / Len of substring
        int ans = Integer.MIN_VALUE; // Final answ

        // Step 2 - optional
        char[] chS = s.toCharArray();
        for (int k = 0; k < 99; k++) {   /* initilize the hash map here */ }

        while (r < n) {
            // Step 3: EXPAND
            map[s.charAt(r)]++;

            // Step 4: SHRINK
            while (r < n && map[s.charAt(r)] != 0) {
                map[s.charAt(l)]--;
                l++;
            }

            // Step 5: update Ans
            len = r - l;
            ans = Math.max(len, ans);

            r++;
        }
        return ans;
    }

}
