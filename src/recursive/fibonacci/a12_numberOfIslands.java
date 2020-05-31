package recursive.fibonacci;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/solution/
 */
public class a12_numberOfIslands {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //char[][] matrix = { {1,1,0,1}, {0,0,1,0}, {0,0,0,0} };
        char[][] matrix = { {1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0} };
        //char[][] matrix = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}};
        //char[][] matrix = {{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 0}};

        a12_numberOfIslands class1 = new a12_numberOfIslands();
        //System.out.println("\n Total island: " + class1.dfs(matrix));
        System.out.println("\n Total island: " + class1.bfs(matrix));

    }

    private int bfs(char[][] grid) {

        int totRows = grid.length;
        int totCols = grid[0].length;
        int islands = 1;

        for (int row = 0; row < totRows; row++) {
            for (int col = 0; col < totCols; col++) {
                if (grid[row][col] == 0 || grid[row][col] > 1) {
                    continue;
                }

                Queue<Integer> q = new LinkedList<>();
                q.add(row * totCols + col);

                while (!q.isEmpty()) {

                    int id = q.remove();
                    int currRow = id / totCols;
                    int currCol = id % totCols;

					if (currRow >= totRows || currCol >= totCols) {
						continue;
					}

					if (currRow < 0 || currCol < 0) {
						continue;
					}

                    grid[currRow][currCol] = 0;

                    // Make 4 API CALL to cover all 4 directions

                    if (currRow + 1 < totRows && grid[currRow + 1][currCol] > 0) {
						grid[currRow+1][currCol] = 0;
                        q.add(currRow + 1 * totCols + currCol);
                    }
					if (currRow - 1 >= 0 && grid[currRow - 1][currCol] > 0) {
						grid[currRow-1][currCol] = 0;
						q.add(currRow - 1 * totCols + currCol);
					}

                    if (currCol + 1 < totCols && grid[currRow][currCol + 1] > 0) {
						grid[currRow][currCol+1] = 0;
                        q.add(currRow * totCols + currCol + 1);
                    }
					if (currCol - 1 >=0 && grid[currRow][currCol - 1] > 0) {
						grid[currRow][currCol-1] = 0;
						q.add(currRow * totCols + currCol - 1);
					}
                }

                islands++;

            }
        }

        return islands - 1;
    }

    public int dfs(char[][] grid) {

        int totRows = grid.length;
        int totCols = grid[0].length;
        int islands = 2;

        for (int row = 0; row < totRows; row++) {
            for (int col = 0; col < totCols; col++) {
                if (grid[row][col] == 0 || grid[row][col] > 1) {
                    continue;
                }
                islands = dfs(grid, row, col, totRows, totCols, islands) + 1;
            }
        }

        return islands - 1;
    }

    public int dfs(char[][] grid, int sr, int sc, int totRows, int totCols, int islands) {

        if (sr >= totRows || sc >= totCols) {
            return islands;
        }

        if (grid[sr][sc] == 0) {
            return islands;
        }

        if (grid[sr][sc] == 1) {
            grid[sr][sc] = (char) islands;
            dfs(grid, sr + 1, sc, totRows, totCols, islands);
            dfs(grid, sr, sc + 1, totRows, totCols, islands);
        }

        return islands;

    }

}
