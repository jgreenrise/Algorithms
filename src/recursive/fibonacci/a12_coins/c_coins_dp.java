package recursive.fibonacci.a12_coins;

/**
 * TC: O(amount * coins),
 * SC: O(amount)
 */
public class c_coins_dp {

    public static void main(String[] args) {

        c_coins_dp class1 = new c_coins_dp();
        //System.out.println("Coins: "+class1.change(15, new int []{2,3,5,10}));
        System.out.println("Coins: "+class1.change(5, new int []{1,2,3}));

    }

    public int change(int amount, int[] coins) {

        if(amount <= 0){
            return -1;
        }

        int [] dp = new int[amount+1];

        for (int row = 0; row < coins.length; row++) {

            dp[0] = 1;

            for (int col = 1; col < amount+1; col++) {

                if(row == 0){
                    if(col%coins[row] == 0){
                        dp[col] = 1;
                    }
                }else{
                    if(coins[row] > col) {
                        dp[col] = dp[col];
                    }else if(coins[row] <= col){
                        dp[col] = dp[col] + dp[col - coins[row]];
                    }
                    //System.out.println(dp[row][col]);
                }
            }
        }

        return dp[dp.length-1];
    }

}
