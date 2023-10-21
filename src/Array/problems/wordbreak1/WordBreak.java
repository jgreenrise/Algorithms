package Array.problems.wordbreak1;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public static void main(String args[]) {
        String str = "catsanddog";
        List<String> words = Arrays.asList("cat", "cats", "and", "sand", "dog", "");

        str = "leetcode";
        words = Arrays.asList("leet", "code");

        WordBreak class1 = new WordBreak();

        // 1 - Using For loop
        System.out.println(class1.wordBreakv1(str, words));

        // 2- Using boolean array - dynamic programming
        System.out.println(class1.wordBreak(str, words));

        // 3 - can also solve using TRIE

        // 4
    }

    // Approach 2
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        return doesWordBreakExist(s, set, dp);
    }

    public boolean doesWordBreakExist(String s, Set<String> set, boolean[] dp) {

        for (int j = 0; j < s.length(); j++) {

            if (!dp[j])
                continue;

            for (int k = j + 1; k <= s.length(); k++) {

                if (set.contains(s.substring(j, k))) {
                    dp[k] = true;
                }
            }

            if (dp[s.length()]) {
                return true;
            }
        }

        return dp[s.length()];

    }

    // Approach 1
    public boolean wordBreakv1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        // Cache List
        Set<String> cache = new HashSet<>();

        // Ignore List
        Set<Integer> ignore = new HashSet<>();

        return doesWordBreakExist(s, set, 0, cache, ignore);
    }

    public boolean doesWordBreakExist(String s, Set<String> set, int startIndex, Set<String> cache, Set<Integer> ignore) {

        // Check if exists in cache or in Set
        if (cache.contains(s.substring(startIndex)) || set.contains(s.substring(startIndex)))
            return true;

        for (int j = startIndex; j < s.length(); j++) {

            boolean left = false;

            if (j == 0) {
                left = set.contains(String.valueOf(s.charAt(0)));
            } else {
                left = set.contains(s.substring(startIndex, j + 1));
            }

            if (left) {

                if (j + 1 >= s.length())
                    return true;

                // If exists in IGNORE LIST, jump to next index
                if (ignore.contains(j + 1))
                    continue;

                boolean right = doesWordBreakExist(s, set, j + 1, cache, ignore);
                if (right) {
                    cache.add(s.substring(j + 1));
                    return true;
                } else {
                    ignore.add(j + 1);
                }
            }
        }

        return false;

    }

}
