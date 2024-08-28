public class a_0322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Initialize dp array to a large value for all indices except dp[0]
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int k = 1; k <= amount; k++) {
            int minCoinsReqd = Integer.MAX_VALUE;  // Reset for each new amount k

            for (int coinChoice : coins) {
                if (coinChoice <= k) {              // Select eligible coin from coins
                    int remainder = k - coinChoice; // Remainder, after selecting coin
                    if (dp[remainder] != Integer.MAX_VALUE) {
                        minCoinsReqd = Math.min(minCoinsReqd, dp[remainder] + 1);
                    }
                }
            }

            dp[k] = minCoinsReqd;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]; // Handle unreachable amount case
    }

}
