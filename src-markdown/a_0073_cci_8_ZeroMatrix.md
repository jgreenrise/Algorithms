public class a_0073_cci_8_ZeroMatrix {

    public static void main(String args[]) {

        System.out.println("\n*****Approach1*******\n");
        //int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] matrix = {{1, 0, 3}};
        setZeroes_Oh1_space_complexitu(matrix);
        //setZeroes(matrix, 3, 4);
        //modifyMatrixByMakingAllRowsAndColumnsZero_method2(matrix, 3, 4);

        int[][] matrix1 = {{7, 1, 2}, {5, 4, 9}, {7, 0, 3}, {1, 8, 5}};
        //mark1stRowIndexAndIstColumnIndexZero(matrix1, 4, 3);

        int[][] matrix2 = {{0, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 1}};
        //mark1stRowIndexAndIstColumnIndexZero(matrix2, 3, 4);

        int[][] matrix3 = {{0, 1, 1}, {1, 1, 1}, {0, 1, 1}};
        //mark1stRowIndexAndIstColumnIndexZero(matrix3, 3, 3);

        /**
         * Approach 2
         */
        System.out.println("\n*****Approach2*******\n");
        int[][] matrix4 = {{0, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 1}};

        int[][] matrix5 = {{0, 1, 1}, {1, 1, 1}, {0, 1, 1}};
        setZeroes(matrix5);

    }

    public static void setZeroes_Oh1_space_complexitu(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isfirstRowZero = false;
        boolean isfirstColZero = false;

        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                isfirstColZero = true;
            }
        }

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                isfirstRowZero = true;
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (isfirstRowZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }

        if (isfirstColZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }

        printMatrix(matrix, rows, cols);
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }

    public static void setZeroes(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        boolean[] buffer_rows = new boolean[rows];
        boolean[] buffer_cols = new boolean[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    buffer_rows[row] = true;
                    buffer_cols[col] = true;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            if (buffer_rows[row]) {
                for (int col = 0; col < cols; col++) {
                    mat[row][col] = 0;
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            if (buffer_cols[col]) {
                for (int row = 0; row < rows; row++) {
                    mat[row][col] = 0;
                }
            }
        }

    }

    public void setZeroesUsing1BooleanArray(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] bcols = new boolean[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {

                    matrix[row][0] = 0;
                    bcols[col] = true;
                }
            }
        }

        printMatrix(matrix, rows, cols);

        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            if (bcols[col]) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }


    }

}
