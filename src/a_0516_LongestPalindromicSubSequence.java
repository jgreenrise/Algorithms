public class a_0516_LongestPalindromicSubSequence {

    /**
     * b   b   b   a   b
     * b   1   2   3   3   4
     * b       1
     * b           1   1   3
     * a               1   1
     * b                   1
     */
    public int longestPalindromeSubseq(String s) {

        int[] dp = new int[s.length()];
        int n = s.length();
        dp[n - 1] = 1;

        for (int k = n - 2; k >= 0; k--) {
            char ch = s.charAt(k);                              //  a   b   b
            int prev = dp[k];                                   //  0   0   0
            dp[k] = 1;
            for (int j = k + 1; j < n; j++) {
                if (ch != s.charAt(j)) {
                    prev = dp[j];
                    dp[j] = Math.max(dp[j - 1], dp[j]);           //  1   1
                } else {
                    int l = prev;
                    prev = dp[j];
                    dp[j] = l + 2;                           //  3
                }
            }
        }

        return dp[n - 1];

    }
}