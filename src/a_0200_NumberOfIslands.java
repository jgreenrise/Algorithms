public class a_0200_NumberOfIslands {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int out = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    markNeighBoursZero(row, col, rows, cols, grid);
                    out++;
                }
            }
        }
        return out;
    }

    public void markNeighBoursZero(int row, int col, int rows, int cols, char[][] grid) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        markNeighBoursZero(row + 1, col, rows, cols, grid);
        markNeighBoursZero(row - 1, col, rows, cols, grid);
        markNeighBoursZero(row, col + 1, rows, cols, grid);
        markNeighBoursZero(row, col - 1, rows, cols, grid);

    }

}
