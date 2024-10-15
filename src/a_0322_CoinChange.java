public class a_0322_CoinChange {

    public int coinChange(int[] coins, int amount) {

        // Handle base case when amount is 0
        if (amount == 0) return 0;

        // Create dp array and initialize with a large value (amount + 1)
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;  // large value, assuming no solution initially
        }

        // Initialize dp[0] = 0 because 0 coins are needed to make amount 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    int remainder = i - coin; // Remainder, after selecting coin
                    dp[i] = Math.min(dp[i], dp[remainder] + 1);
                }
            }
        }

        // Return the result, check if it's valid
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
