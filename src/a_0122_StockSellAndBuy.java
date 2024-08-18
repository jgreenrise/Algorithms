/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class a_0122_StockSellAndBuy {
    public static void main(String[] args) {

        //int[] arr_i_input = {7, 1, 5, 3, 6, 4};
        int[] arr_i_input = { 1,2,3,4,5};

        //System.out.println(usingValleyPeakApproach(arr_i_input));
        //System.out.println(usingRecursion(arr_i_input, 0));
        System.out.println(maxProfit(arr_i_input));
    }


    public int maxProfit(int[] prices) {

        int max_profit = 0;
        int profit_so_far = 0;

        for(int j = 1; j < prices.length; j++){

            // Compare with prev element
            if(prices[j] >= prices[j-1]){

                // Increase profit, if stock price is growing
                profit_so_far += prices[j] - prices[j-1];
                if(j == prices.length-1){
                    max_profit += profit_so_far;
                }
            }else{
                max_profit += profit_so_far;
                profit_so_far = 0;
            }
        }

        return max_profit;

    }

}
