package Array.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch_20200604 {

    public static void main(String args[]) {

        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch_20200604 class1 = new WordSearch_20200604();

        //System.out.println("\n*****ABCCED*******\n" + class1.exist(matrix, "ABCCED"));
        //System.out.println("\n*****ABCCED*******\n" + class1.existDFS(matrix, "ABCCED"));

        matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println("\n*****SEE*******\n" + class1.existDFS(matrix, "SEE"));
        System.out.println("\n*****SEED*******\n" + class1.existDFS(matrix, "SEED"));
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

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backTracking(row, col, board, word, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean backTracking(int row, int col, char[][] mat, String word, int counter) {

        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length) {
            return false;
        }

        if (counter < word.length() && mat[row][col] == word.charAt(counter)) {

            if (counter == word.length() - 1)
                return true;

            char orig = mat[row][col];
            mat[row][col] = 1;

            int[] rows = {-1, 1, 0, 0};
            int[] cols = {0, 0, -1, 1};

            for (int d = 0; d < 4; d++) {

                int newR = row + rows[d];
                int newC = col + cols[d];

                if (backTracking(newR, newC, mat, word, counter + 1)) {
                    return true;
                }

            }

            mat[row][col] = orig;

        }

        return false;

    }

    public boolean existDFS(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // 1: GET LOCATIONS OF FIRST CHAR
        List<Integer> locations = getFirstCharLocations(board, word);
        Set<Integer> set = null;

        if (locations.size() == 0) {
            return false;
        }

        //[["a"]]  "a", [["a","a"]] "a"
        if (rows == 1 && cols == 1 || word.length() == 1) {
            return String.valueOf(board[0][0]).equalsIgnoreCase(word);
        }

        // 2 lOOP THROUGH LOCATIONS
        for (int location : locations) {

            set = new HashSet();
            Stack<Integer> stack = new Stack();
            stack.add(location);
            int j = 1;
            boolean matchFound = false;

            while (!stack.isEmpty()) {

                Integer id = stack.pop();
                int row = id / cols;
                int col = id % cols;
                matchFound = false;

                if (row + 1 < rows && !set.contains((row + 1) * cols + col) && board[row + 1][col] == word.charAt(j)) {
                    stack.add((row + 1) * cols + col);
                    set.add((row + 1) * cols + col);
                    matchFound = true;
                }

                if (row - 1 >= 0 && !set.contains((row - 1) * cols + col) && board[row - 1][col] == word.charAt(j)) {
                    stack.add((row - 1) * cols + col);
                    set.add((row - 1) * cols + col);
                    matchFound = true;
                }

                if (col + 1 < cols && !set.contains(row * cols + col + 1) && board[row][col + 1] == word.charAt(j)) {
                    stack.add(row * cols + col + 1);
                    set.add(row * cols + col + 1);
                    matchFound = true;
                }

                if (col - 1 >= 0 && !set.contains(row * cols + col - 1) && board[row][col - 1] == word.charAt(j)) {
                    stack.add(row * cols + col - 1);
                    set.add(row * cols + col - 1);
                    matchFound = true;
                }

                if (matchFound && j == word.length() - 1) {
                    return true;
                }

                if (matchFound) {
                    // Move to next character
                    j++;
                }

            }

        }

        return false;

    }

    public List<Integer> getFirstCharLocations(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        List<Integer> out = new ArrayList();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    out.add(row * cols + col);
                }
            }
        }

        return out;

    }


}
