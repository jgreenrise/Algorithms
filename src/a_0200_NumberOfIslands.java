public class a_0200_NumberOfIslands {

    public int numIslands(char[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == '1') {
                    dfs(r, c, mat, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int row, int col, char[][] mat, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if (mat[row][col] == '0') {
            return;
        }
        mat[row][col] = '0';
        int[] dRows = {-1, 1, 0, 0};
        int[] dCols = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            dfs(row + dRows[d], col + dCols[d], mat, rows, cols);
        }

    }

}
