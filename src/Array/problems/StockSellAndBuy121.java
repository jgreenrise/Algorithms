package Array.problems;

/**
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockSellAndBuy121 {
    public static void main(String[] args) {

        int[] arr_i_input = {7, 1, 5, 3, 6, 4};
        //int[] arr_i_input = {2,1,2,1,0,1,2};
        //int[] arr_i_input = {2,1,4};
        //int[] arr_i_input = { 1,2,3,4,5};

        System.out.println(bruteforce(arr_i_input));
        //System.out.println(usingValleyPeakApproach(arr_i_input));
    }

    public static int usingValleyPeakApproach(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int j = 0; j< prices.length; j++){
            if(prices[j] < minBuyPrice){
                // BUY
                minBuyPrice = prices[j];
            }else{
                int currentProfit = prices[j] - minBuyPrice;
                if(currentProfit > profit){
                    // BUY, IF MAKING PROFIT
                    profit = currentProfit;
                }else{
                    // SKIP
                }
            }
        }
        return profit;
    }

    public static int bruteforce(int[] prices) {

        int maxProfit = 0;

        for(int i=0; i< prices.length; i++){
            for(int j = i+1; j< prices.length; j++){
                if(prices[j] > prices[i]){
                    // Sell it
                    int currProfit = prices[j]- prices[i];
                    if(maxProfit < currProfit){
                        maxProfit = currProfit;
                    }
                }
            }
        }

        return maxProfit;

    }

}
