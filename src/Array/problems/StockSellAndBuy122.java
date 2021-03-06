package Array.problems;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class StockSellAndBuy122 {
    public static void main(String[] args) {

        int[] arr_i_input = {7, 1, 5, 3, 6, 4};
        //int[] arr_i_input = { 1,2,3,4,5};

        System.out.println(usingValleyPeakApproach(arr_i_input));
        System.out.println(usingRecursion(arr_i_input, 0));
    }

    /**
     * TC: O(n2)
     * SC: O(n)
     */
    public static int usingRecursion(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int maxProfit = 0;
        for (int start = s; start < prices.length; start++) {
            int profitSequence = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profitTransaction = usingRecursion(prices, i + 1) + prices[i] - prices[start];
                    if (profitTransaction > profitSequence)
                        profitSequence = profitTransaction;
                }
            }
            if (profitSequence > maxProfit)
                maxProfit = profitSequence;
        }
        return maxProfit;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     * @param prices
     * @return
     */
    public static int usingValleyPeakApproach(int[] prices) {

        int profit = 0;
        for (int j = 1; j < prices.length; j++) {

            if (prices[j] > prices[j - 1]) {

                int peak = prices[j];
                int valley = prices[j-1];

                // Look if its better to sell in future
                // Look if graph keeps on increasing
                while (prices[j + 1] > peak && j + 1 < prices.length) {
                    peak = prices[j + 1];
                    j++;
                }

                profit = profit + peak - valley;
                j = j + 1;
            }
        }

        return profit;

    }

}
