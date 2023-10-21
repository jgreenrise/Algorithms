package Array.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearchEmpty {

    public static void main(String args[]) {

        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearchEmpty class1 = new WordSearchEmpty();
        //System.out.println("\n*****ABCCED*******\n" + class1.exist(matrix, "ABCCED"));

        matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        //System.out.println("\n*****SEE*******\n" + class1.exist(matrix, "SEE"));

        matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("\n*****ABCEFSADEESE*******\n" + class1.exist(matrix, "ABCEFSADEESE"));

        //matrix = new char[][]{{'A'}};
        //System.out.println("\n*****ABCB*******\n" + class1.existDFS(matrix, "A"));
       /* System.out.println("\n*****A*******\n" + class1.exist(matrix, "A"));

        matrix = new char[][]{{'A', 'A'}};
        System.out.println("\n*****aa, a*******\n" + class1.existDFS(matrix, "A"));*/

    }

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        boolean matchFound = false;

        boolean[][] isVisited;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    isVisited = new boolean[rows][cols];
                    matchFound = dfs(row, col, rows, cols, board, word, isVisited, 1);
                    if (matchFound) {
                        return matchFound;
                    }
                }
            }
        }

        return matchFound;

    }

    private boolean dfs(int row, int col, int rows, int cols, char[][] board, String word, boolean[][] isVisited, int index) {

        if(index >= word.length()){
            return true;
        }

        System.out.println(word.charAt(index));

        if(row < 0 || row >= rows || col < 0 || col >= cols)
            return false;

        isVisited[row][col] = true;
        int[] xis = {-1, 0, 1, 0};
        int[] yis = {0, 1, 0, -1};

        boolean matchFound;

        for (int direction = 0; direction < 4; direction++) {

            int siblingRow = row + xis[direction];
            int siblingCol = col + yis[direction];

            if(siblingRow < 0 || siblingRow >= rows || siblingCol < 0 || siblingCol >= cols)
                continue;

            if (!isVisited[siblingRow][siblingCol]) {
                // Is Not visited

                if (board[siblingRow][siblingCol] == word.charAt(index)) {
                    matchFound = dfs(siblingRow, siblingCol, rows, cols, board, word, isVisited, index + 1);
                    if(matchFound){
                        return matchFound;
                    }else {
                        isVisited[siblingRow][siblingCol] = false;
                    }
                }
            }else{
                System.out.println("Location already visited: "+isVisited[siblingRow][siblingCol]);
            }

        }

        return false;


    }

}
