import java.util.HashSet;
import java.util.Set;

public class a_0130_SurroundedRegion {
    public void solve(char[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (((r == 0 || r == rows - 1) || (c == 0 || c == cols - 1)) && mat[r][c] == 'O') {
                    dfs(r, c, mat, rows, cols, 'O', 'I', 'X', new HashSet<>());
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 'O') mat[r][c] = 'X';
                if (mat[r][c] == 'I') mat[r][c] = 'O';
            }
        }

    }

    public void dfs(int row, int col, char[][] mat, int rows, int cols, char from, char to, char ignore, Set<Integer> visited) {

        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return;
        if (visited.contains(row * cols + col))
            return;
        if (mat[row][col] == ignore)
            return;

        if (mat[row][col] == from)
            mat[row][col] = to;
        visited.add(row * cols + col);

        int ds = 4;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int d = 0; d < ds; d++) {
            dfs(row + dr[d], col + dc[d], mat, rows, cols, from, to, ignore, visited);
        }
    }
}
