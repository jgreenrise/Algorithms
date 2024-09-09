public class a_0121_StockSellAndBuy {

    /**
     * 7   1   5   3   6   4
     * 7   6   6   6   6   4
     * 0   1   2   3   4   5
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int max_so_far = prices[n - 1];
        int ans = -1;

        for (int k = n - 2; k >= 0; k--) {
            if (prices[k] > max_so_far) {
                max_so_far = prices[k];
            } else {
                ans = Math.max(ans, max_so_far - prices[k]);
            }
        }
        return ans == -1 ? 0 : ans;
    }

    /**
     * 7   1   5   3   6   4
     * 7   6   6   6   6   4
     */
    public int maxProfitUsingLeftSumArray(int[] prices) {

        int n = prices.length;
        if (n == 1) return 0;

        int[] right_sum = new int[prices.length];
        right_sum[n - 1] = prices[n - 1];
        int max_so_far = prices[n - 1];

        for (int k = n - 2; k >= 0; k--) {
            if (prices[k] > max_so_far) {
                right_sum[k] = prices[k];
                max_so_far = right_sum[k];
            } else {
                right_sum[k] = max_so_far;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int k = 0; k < n - 1; k++) {
            ans = Math.max(ans, right_sum[k + 1] - prices[k]);
        }

        return ans == -1 ? 0 : ans;
    }

}
