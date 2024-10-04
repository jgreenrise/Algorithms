public class a_0005_LongestPalindromicSubString {

    public String longestPalindrome(String s) {

        int n = s.length();
        int[] dp = new int[n];
        String ans = "" + s.charAt(n - 1);
        int maxLen = 1;
        int prev = -1;

        if (n == 2) {
            return s.charAt(0) == s.charAt(1) ? s : "" + s.charAt(1);
        }
        for (int j = n - 2; j >= 0; j--) {
            prev = 0;
            dp[j] = 1;
            for (int k = j + 1; k < n; k++) {
                if (s.charAt(j) == s.charAt(k) && prev == k - j - 2 + 1) {
                    int tempPrev = dp[k];
                    dp[k] = prev + 2;
                    prev = tempPrev;

                    if (dp[k] > maxLen) {
                        maxLen = dp[k];
                        ans = s.substring(j, k + 1);
                    }

                } else {
                    prev = dp[k];
                    dp[k] = dp[k - 1];
                }

                // System.out.println("j: "+j+", k: "+k +"\t"+Arrays.toString(dp));
            }
        }

        return ans;

    }

}
