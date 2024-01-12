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

        a_0139_WordBreak class1 = new a_0139_WordBreak();

        // Using boolean array - dynamic programming
        System.out.println(class1.wordBreak(str, words));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

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

}
