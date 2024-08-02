public class a_0121_StockSellAndBuy {
    public static void main(String[] args) {

        int[] arr_i_input = {7, 1, 5, 3, 6, 4};
        //int[] arr_i_input = {2,1,2,1,0,1,2};
        //int[] arr_i_input = {2,1,4};
        //int[] arr_i_input = { 1,2,3,4,5};

    }

    /**
     * Find Max on the right Hand side: max_so_far
     *
     * 1. Initialize: Set maxprofit to 0 and max_so_far to the last price in the array.
     * 2. Iterate: Traverse the prices from right to left, updating max_so_far if a higher price is found. Compute potential profit and update maxprofit if it's higher than the current maxprofit.
     * 3. Return: Output the maximum profit found.
     *
     */
    public int maxProfit(int[] prices) {

        int maxprofit = 0;
        int max_so_far = prices[prices.length-1]; // 4
        for(int j = prices.length-2; j >= 0; j--){
            //System.out.println("Compare: "+profit+"\t prices[j]: "+prices[j]);
            if(max_so_far > prices[j]){
                maxprofit = Math.max(max_so_far - prices[j], maxprofit);
                //System.out.println("\tProfit: "+profit+"\t maxProfit: "+maxprofit);
            }else{
                max_so_far = prices[j];
                //System.out.println("\tProfit updated: "+profit+"\t maxProfit: "+maxprofit);
            }
        }
        return maxprofit;
    }


    /**
     * Right Sum / prefix approach: Store maxSoFar in rightSum array
     *
     * 1. Create right Array: Populate it with the maximum future prices from each day.
     * 2. Compute Profit: Calculate the maximum profit by comparing each day's price with the future maximum price.
     * 3. Return Result: Return the highest profit obtained.
     *
     */
    public int maxProfitUsingleftPrefix(int[] prices) {

        int [] right = new int [prices.length];
        int max = prices[prices.length-1];
        right[prices.length-1] = max;
        for(int j = prices.length-2; j >= 0; j--){
            max = Math.max(prices[j], max);
            right[j] = max;
        }
        //System.out.println(Arrays.toString(right));

        int maxProfit = 0;
        for(int j = 0; j< prices.length-1; j++){
            if(prices[j] <= right[j+1]){
                maxProfit = Math.max(maxProfit, right[j+1]- prices[j]);
            }
        }

        return maxProfit;

    }

}
