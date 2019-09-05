package Array.problems;

/**
 * Given a NxN matrix with 0s and 1s. Set every row that contains a 0 to all 0s and set every column that contains a 0 to all 0s.
 */

/*-
 * Output
 * 
 * 
Input
0	1	2	
5	4	9	
7	0	3	
1	0	5	
Output
0	0	0	
0	0	9	
0	0	0	
0	0	0	

Input
7	1	2	
5	4	9	
7	0	3	
1	8	5	
Output
7	0	2	
5	0	9	
0	0	0	
1	0	5	

Input
0	1	1	0	
0	1	1	1	
0	1	1	1	
Output
0	0	0	0	
0	0	0	0	
0	0	0	0	

Input
0	1	1	
1	1	1	
0	1	1	
Output
0	0	0	
0	1	1	
0	0	0	

*****Approach2*******


Input
0	1	1	0	
0	1	1	1	
0	1	1	1	
Output
0	0	0	0	
0	0	0	0	
0	0	0	0	

Input
0	1	1	
1	1	1	
0	1	1	
Output
0	0	0	
0	1	1	
0	0	0	

 *
 */
public class MarkSpecificRowsAndColumnsZero {

    public static void main(String args[]) {

        System.out.println("\n*****Approach1*******\n");
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        mark1stRowIndexAndIstColumnIndexZero(matrix, 3, 4);

      /*  int[][] matrix1 = {{7, 1, 2}, {5, 4, 9}, {7, 0, 3}, {1, 8, 5}};
		usingStringBuilderAnd2IntArrays(matrix1, 4, 3);

        int[][] matrix2 = {{0, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 1}};
		usingStringBuilderAnd2IntArrays(matrix2, 3, 4);

        int[][] matrix3 = {{0, 1, 1}, {1, 1, 1}, {0, 1, 1}};
		usingStringBuilderAnd2IntArrays(matrix3, 3, 3);*/

        /**
         * Approach 2
         */
        System.out.println("\n*****Approach2*******\n");
        int[][] matrix4 = {{0, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 1}};
        //modifyMatrixByMakingAllRowsAndColumnsZero_method2(matrix4, 3, 4);

        int[][] matrix5 = {{0, 1, 1}, {1, 1, 1}, {0, 1, 1}};
        //modifyMatrixByMakingAllRowsAndColumnsZero_method2(matrix5, 3, 3);

    }

    public static int[][] mark1stRowIndexAndIstColumnIndexZero(int[][] matrix, int rows, int cols) {

        // System.out.println("\nInput");
        // printMatrix(matrix, rows, cols);

        /**
         * STEP 1:
         * 1.a Loop through all elements from matrix: Time complexity: O(M*N)
         * 1.b Mark 0th row index 0
         * 1.c Mark 0th col index 0
         */
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // System.out.println("\nOutput");
        // printMatrix(matrix, rows, cols);

        for (int row = 0; row < rows; row++) {
            System.out.println("Matrix value: "+matrix[row][0]);
            if (matrix[row][0] == 0) {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = 0;
                }
                break;
            }
        }

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = 0;
                }
                break;
            }
        }

        //System.out.println("\nOutput");
        // printMatrix(matrix, rows, cols);
        return matrix;

    }

    public static void usingStringBuilderAnd2IntArrays(int[][] matrix, int rows, int cols) {

        System.out.println("\nInput");
        printMatrix(matrix, rows, cols);

        /**
         * STEP 1:
         * 1.a Loop through all elements from matrix: Time complexity: O(M*N)
         * 1.b Create String builder which contains row with zero value: StringBuilderRow
         * 1.c Create String builder which contains col with zero value: StringBuilderColumn
         */
        StringBuilder stringBuilderRow = new StringBuilder();
        StringBuilder stringBuilderCol = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                if (matrix[row][column] == 0) {
                    stringBuilderRow.append(row);
                    stringBuilderCol.append(column);
                }
            }
        }

        /**
         * STEP 2:
         * a. Loop through all values (StringBuilderRow)
         * b. for (row: StringBuilderRow.toArray())
         *      c. Mark [row] [column 1] = 0
         *      c. Mark [row] [column 2] = 0
         *      ...
         *      d. Mark [row] [column n] = 0
         */
        for (String row : stringBuilderRow.toString().split("")) {
            for (int column = 0; column < cols; column++) {
                matrix[Integer.valueOf(row)][column] = 0;
            }
        }

        /**
         * STEP 3:
         * a. Loop through all values (StringBuilderColumn)
         * b. for (column: StringBuilderColumn.toArray())
         *      c. Mark [row1] [column] = 0
         *      c. Mark [row2] [column] = 0
         *      ...
         *      d. Mark [rown] [column] = 0
         */

        for (String column : stringBuilderCol.toString().split("")) {
            for (int row = 0; row < rows; row++) {
                matrix[row][Integer.valueOf(column)] = 0;
            }
        }

        System.out.println("\nOutput");
        printMatrix(matrix, rows, cols);

    }

    /**
     * Time complexity : 0(M*N), Space complexity: 0(M) OR 0(N), whichever is
     * smaller.
     * <p>
     * Mark 1st index of row 0, if any element of row is zero.
     * Create bool array for columns.
     *
     * @param matrix
     * @param rows
     * @param cols
     */
    public static void modifyMatrixByMakingAllRowsAndColumnsZero(
            int[][] matrix, int rows, int cols) {

        System.out.println("\nInput");
        printMatrix(matrix, rows, cols);

        boolean[] bool_isZero_cols = new boolean[cols];

        // marking first row and column as 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Check if value at position i,j is zero
                if (matrix[i][j] == 0) {

                    // Mark ith row 1st element 0
                    matrix[i][0] = 0;

                    bool_isZero_cols[j] = true;

                }
            }
        }

        /*
         * Loop through rows, if first element of row is 0, mark all element in
         * that ro as 0
         */
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < cols; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < cols; j++) {
            if (bool_isZero_cols[j]) {
                for (int i = 0; i < rows; i++)
                    matrix[i][j] = 0;
            }
        }

        System.out.println("Output");
        printMatrix(matrix, rows, cols);

    }

    /**
     * Time complexity : 0(M*N), Space complexity: 0(M+N)
     * <p>
     * Create bool array for rows and cols, which stores for mapping of zero
     *
     * @param matrix
     * @param rows
     * @param cols
     */
    public static void modifyMatrixByMakingAllRowsAndColumnsZero_method2(
            int[][] matrix, int rows, int cols) {

        System.out.println("\nInput");
        printMatrix(matrix, rows, cols);

        boolean[] bool_arr_cols = new boolean[cols];
        boolean[] bool_arr_rows = new boolean[rows];

        // marking first row and column as 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Check if value at position i,j is zero
                if (matrix[i][j] == 0) {

                    bool_arr_rows[i] = true;
                    bool_arr_cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            if (bool_arr_rows[i]) {
                for (int j = 0; j < cols; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < cols; j++) {
            if (bool_arr_cols[j]) {
                for (int i = 0; i < rows; i++)
                    matrix[i][j] = 0;
            }
        }

        System.out.println("Output");
        printMatrix(matrix, rows, cols);

    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }

}
