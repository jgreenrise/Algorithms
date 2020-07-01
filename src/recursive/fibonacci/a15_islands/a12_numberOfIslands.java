package recursive.fibonacci.a15_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands.
 */
public class a12_numberOfIslands {

    public static void main(String[] args) {

        //char[][] matrix = { {1,1,0,1}, {0,0,1,0}, {0,0,0,0} };
        char[][] matrix = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        //char[][] matrix = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}};
        //char[][] matrix = {{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 0}};

        a12_numberOfIslands class1 = new a12_numberOfIslands();
        //System.out.println("\n Total island: " + class1.dfs(matrix));
        System.out.println("\n Total island: " + class1.numIslands(matrix));

    }

    private int bfs(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0 || grid[row][col] > 1) {
                    continue;
                }

                Queue<Integer> q = new LinkedList<>();
                q.add(row * cols + col);

                while (!q.isEmpty()) {

                    int id = q.remove();
                    int currRow = id / cols;
                    int currCol = id % cols;

                    if (currRow >= rows || currCol >= cols) {
                        continue;
                    }

                    if (currRow < 0 || currCol < 0) {
                        continue;
                    }

                    grid[currRow][currCol] = 0;

                    // Make 4 API CALL to cover all 4 directions

                    if (currRow + 1 < rows && grid[currRow + 1][currCol] > 0) {
                        grid[currRow + 1][currCol] = 0;
                        q.add(currRow + 1 * cols + currCol);
                    }
                    if (currRow - 1 >= 0 && grid[currRow - 1][currCol] > 0) {
                        grid[currRow - 1][currCol] = 0;
                        q.add(currRow - 1 * cols + currCol);
                    }

                    if (currCol + 1 < cols && grid[currRow][currCol + 1] > 0) {
                        grid[currRow][currCol + 1] = 0;
                        q.add(currRow * cols + currCol + 1);
                    }
                    if (currCol - 1 >= 0 && grid[currRow][currCol - 1] > 0) {
                        grid[currRow][currCol - 1] = 0;
                        q.add(currRow * cols + currCol - 1);
                    }
                }

                islands++;

            }
        }

        return islands - 1;
    }

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        if (rows == 0) {
            return rows;
        }
        int cols = grid[0].length;
        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.println(grid[row][col] == 1);
                if (grid[row][col] == '1') {
                    // increase islands
                    ++islands;
                    // change any connected land value to zero
                    dfs(grid, row, col, rows, cols);
                    System.out.println(islands);
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int sr, int sc, int totRows, int totCols) {

        /**
         * 1. row greater than tot rows
         * 2. col greater than tot cols
         * 3. row less than 0
         * 4. col less than 0
         * 5. if cell = 0, its not an island
         */
        if (sr >= totRows || sc >= totCols || sr < 0 || sc < 0 || grid[sr][sc] == '0') {
            return;
        }

        grid[sr][sc] = '0';
        dfs(grid, sr + 1, sc, totRows, totCols);
        dfs(grid, sr - 1, sc, totRows, totCols);
        dfs(grid, sr, sc + 1, totRows, totCols);
        dfs(grid, sr, sc - 1, totRows, totCols);

    }

}
