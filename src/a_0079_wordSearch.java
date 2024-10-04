import java.util.HashSet;
import java.util.Set;

public class a_0079_wordSearch {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        Set<Integer> visited = null;

        if (rows == 1 && cols == 1 && word.length() == 1) {
            return board[0][0] == word.charAt(0);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    visited = new HashSet<>();
                    boolean resp = dfs(row, col, rows, cols, 0, word, visited, board);
                    if (resp) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, int rows, int cols, int index, String word, Set<Integer> visited, char[][] board) {

        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (index == word.length()) return true;
        if (visited.contains(row * cols + col)) return false;
        if (board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        //System.out.println("Row : "+(row)+", col: "+(col)+" > Match found and added to IVisited: "+index);
        visited.add(row * cols + col);
        int[] drows = {-1, 1, 0, 0};
        int[] dcols = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            if (!visited.contains((row + drows[d]) * cols + (col + dcols[d]))) {
                boolean resp = dfs(row + drows[d], col + dcols[d], rows, cols, index + 1, word, visited, board);
                if (resp) {
                    return true;
                }
                visited.remove((row + drows[d]) * cols + (col + dcols[d]));
            }
        }
        return false;

    }


}
