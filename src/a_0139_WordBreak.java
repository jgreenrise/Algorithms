import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a_0139_WordBreak {

    public static void main(String args[]) {
        String str = "catsanddog";
        List<String> words = Arrays.asList("cat", "cats", "and", "sand", "dog", "");

        str = "leetcode";
        words = Arrays.asList("leet", "code");

        str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        words = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

        a_0139_WordBreak class1 = new a_0139_WordBreak();

        // Using boolean array - dynamic programming
        System.out.println(class1.wordBreak(str, words));
    }

    public boolean wordBreakV1(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        return wordBreakUsingDynamicProgramming(s, set, dp);
    }

    public boolean wordBreakUsingDynamicProgramming(String s, Set<String> set, boolean[] dp) {

        for (int j = 0; j < s.length(); j++) {
            if (dp[j]) {
                for (int k = j + 1; k <= s.length(); k++) {
                    if (!dp[k]) {
                        // Already found a word on this index
                        dp[k] = set.contains(s.substring(j, k));
                    }
                }
            } else {
                // Reach to first true value and search for all possible words
                continue;
            }

            // Found the last segmented word
            if (dp[s.length()])
                return true;

            //System.out.println(Arrays.toString(dp));

        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        char[] chars = s.toCharArray();
        return wordBreak(0, 0, chars, set, s, null);
    }

    // 0, 0, {l,e,e,t,c,o,d,e}, {leet, code}, leetcode
    public boolean wordBreak(int startIdx, int endIdx, char[] chars, Set<String> set, String s, String prevWord) {

        if (startIdx >= chars.length) {
            return true;
        }

        if (endIdx == chars.length) {
            return set.contains(s.substring(startIdx, endIdx));
        }

        System.out.println("String: " + s + ", Start Idx: " + startIdx + ", End Idx: " + endIdx + ", " + s.substring(startIdx, endIdx));
        String word = s.substring(startIdx, endIdx);

        boolean isSegmented = false;

        if (set.contains(word)) {
            isSegmented = wordBreak(endIdx, endIdx, chars, set, s, word);
            if (!isSegmented) {
                return wordBreak(endIdx - (word.length()), endIdx + 1, chars, set, s, word);
            } else {
                return isSegmented;
            }
        } else {
            return wordBreak(startIdx, endIdx + 1, chars, set, s, prevWord);
        }
    }

}
