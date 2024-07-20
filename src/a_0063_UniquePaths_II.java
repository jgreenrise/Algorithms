public class a_0063_UniquePaths_II {

    public static Integer counter = 0;

    public static void main(String[] args) {
        // Example usage with a 3x3 obstacle grid
        /*int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] obstacleGrid = {
                {0, 1},
                {0, 0}
        };
        */

        // Example usage with a 4x5 obstacle grid
        int[][] obstacleGrid = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };


        int uniquePaths = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Number of unique paths: " + uniquePaths);
    }

    public static int uniquePathsWithObstacles(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] buffer = new int[rows][cols];

        // Update buffer matrix - First Row.
        for (int row = 0; row < rows; row++) {
            if (mat[row][0] == 1) {
                buffer[row][0] = 0;
                // on the first column, if there is an obstacle, the rest are blocked.
                // no need to continue.
                break;
            } else
                buffer[row][0] = 1;
        }

        // Update buffer matrix - First Column
        for (int col = 0; col < cols; col++) {
            if (mat[0][col] == 1) {
                buffer[0][col] = 0;
                // First row, once obstacle found, the rest are blocked.
                break;
            } else
                buffer[0][col] = 1;
        }

        // Update Buffer Matrix - Remaining rows and cols
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 1)
                    buffer[i][j] = 0;
                else
                    buffer[i][j] = buffer[i - 1][j] + buffer[i][j - 1];
            }
        }
        return buffer[rows - 1][cols - 1];
    }
}
