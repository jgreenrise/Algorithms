/**
 * https://leetcode.com/problems/word-search/
 */
public class a_0079_wordSearch {

    public static void main(String args[]) {

        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        a_0079_wordSearch class1 = new a_0079_wordSearch();

        //System.out.println("\n*****ABCCED*******\n" + class1.exist(matrix, "ABCCED"));
        //System.out.println("\n*****ABCCED*******\n" + class1.existDFS(matrix, "ABCCED"));

        matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println("\n*****SEE*******\n" + class1.exist(matrix, "SEE"));
        System.out.println("\n*****SEED*******\n" + class1.exist(matrix, "SEED"));
        //System.out.println("\n*****SEE*******\n" + class1.exist(matrix, "SEE"));

        //System.out.println("\n*****ABCB*******\n" + class1.existDFS(matrix, "ABCB"));
        //System.out.println("\n*****ABCB*******\n" + class1.exist(matrix, "ABCB"));

        matrix = new char[][]{{'A'}};
        //System.out.println("\n*****ABCB*******\n" + class1.existDFS(matrix, "A"));
       /* System.out.println("\n*****A*******\n" + class1.exist(matrix, "A"));

        matrix = new char[][]{{'A', 'A'}};
        System.out.println("\n*****aa, a*******\n" + class1.existDFS(matrix, "A"));*/

    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        boolean response = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    isVisited = new boolean[rows][cols];
                    isVisited[row][col] = true;
                    if (1 == word.length())
                        return true;

                    //System.out.println("at "+row+", col: "+col);
                    response = dfs(row + 1, col, board, 1, word, rows, cols, isVisited)
                            || dfs(row, col + 1, board, 1, word, rows, cols, isVisited)
                            || dfs(row - 1, col, board, 1, word, rows, cols, isVisited)
                            || dfs(row, col - 1, board, 1, word, rows, cols, isVisited);
                    if (response)
                        return response;

                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, char[][] board, int idx, String word, int rows, int cols, boolean[][] isVisited) {
        //System.out.println("\tat "+row+", col: "+col);
        if (row < 0 || row >= rows || col < 0 || col >= cols || isVisited[row][col])
            return false;

        if (board[row][col] == word.charAt(idx)) {
            boolean response = false;
            isVisited[row][col] = true;
            if (idx == word.length() - 1) {
                //System.out.println("\t\tat "+row+", col: "+col+", idx: "+idx);
                return true;
            } else
                response = dfs(row + 1, col, board, idx + 1, word, rows, cols, isVisited)
                        || dfs(row, col + 1, board, idx + 1, word, rows, cols, isVisited)
                        || dfs(row - 1, col, board, idx + 1, word, rows, cols, isVisited)
                        || dfs(row, col - 1, board, idx + 1, word, rows, cols, isVisited);
            if (response) return response;
            isVisited[row][col] = false;
            return response;
        } else {
            return false;
        }
    }


}
