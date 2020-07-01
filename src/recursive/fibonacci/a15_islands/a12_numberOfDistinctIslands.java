package recursive.fibonacci.a15_islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 */
public class a12_numberOfDistinctIslands {

    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 0,0,0}, {1, 1, 0, 0, 0}, {0,0,0,1,1}, {0, 0, 0, 1, 1}};

        a12_numberOfDistinctIslands class1 = new a12_numberOfDistinctIslands();
        System.out.println("\n Total distinct islands: " + class1.numDistinctIslands(matrix));

    }

    public int numDistinctIslands(int[][] grid) {

        int rows = grid.length;
        if (rows == 0) {
            return rows;
        }
        int cols = grid[0].length;
        int islands = 0;
        Set<String> set = new HashSet<>();
        StringBuilder sbr = null;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    sbr = new StringBuilder();

                    // Create string value from island
                    dfs(grid, row, col, rows, cols, sbr, null);

                    // Add island to set
                    set.add(sbr.toString());
                }
            }
        }

        return set.size();
    }

    public void dfs(int[][] grid, int sr, int sc, int totRows, int totCols, StringBuilder sbr, String direction) {

        /**
         * 1. row greater than tot rows
         * 2. col greater than tot cols
         * 3. row less than 0
         * 4. col less than 0
         * 5. if cell = 0, its not an island
         */
        if(sc < 0 || sr < 0 || sr >= totRows || sc >= totCols || grid[sr][sc] == 0){
            sbr.append(direction+"0");
            return;
        }

        grid[sr][sc] = 0;
        dfs(grid, sr, sc - 1, totRows, totCols, sbr, "left");    // left
        dfs(grid, sr - 1, sc, totRows, totCols, sbr, "top");    // top
        dfs(grid, sr, sc + 1, totRows, totCols, sbr, "right");    // right
        dfs(grid, sr + 1, sc, totRows, totCols, sbr, "down");    // down

    }

}
