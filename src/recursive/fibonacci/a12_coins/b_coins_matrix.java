package recursive.fibonacci.a12_coins;

/**
 * TC: O(amount * coins),
 * SC: O(amount * coins)
 */
public class b_coins_matrix {

    public static void main(String[] args) {

        b_coins_matrix class1 = new b_coins_matrix();
        //System.out.println("Coins: "+class1.change(15, new int []{2,3,5,10}));
        System.out.println("Coins: "+class1.change(5, new int []{1,2,3}));

    }

    public int change(int amount, int[] coins) {

        if(amount <= 0){
            return -1;
        }

        int [][] mat = new int[coins.length][amount+1];

        for (int row = 0; row < coins.length; row++) {

            //printMatrix(mat);

            mat[row][0] = 1;

            for (int col = 1; col < amount+1; col++) {

                if(row == 0){
                    if(col%coins[row] == 0){
                        mat[row][col] = 1;
                    }
                }else{
                    if(coins[row] > col) {
                        mat[row][col] = mat[row - 1][col];
                    }else if(coins[row] <= col){
                        mat[row][col] = mat[row-1][col] + mat[row][col - coins[row]];
                    }
                    //System.out.println(mat[row][col]);
                }
            }
        }

        return mat[mat.length-1][mat[0].length-1];
    }

    private static void printMatrix(int[][] matrix) {
        // TODO Auto-generated method stub

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println();
        }

    }



}
