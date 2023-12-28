import java.util.*;

/**
 * https://leetcode.com/problems/word-search/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class a79_WordSearchEmpty {

    public static void main(String args[]) {

        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        a79_WordSearchEmpty class1 = new a79_WordSearchEmpty();
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
       // System.out.println("\n*****ABCEFSADEESE*******\n" + class1.exist(matrix, "ABCEFSADEESE"));

        //matrix = new char[][]{{'A'}};
        //System.out.println("\n*****ABCB*******\n" + class1.existDFS(matrix, "A"));
       /* System.out.println("\n*****A*******\n" + class1.exist(matrix, "A"));*/

        matrix = new char[][]{{'A', 'A'}};
        System.out.println("\n*****aa, a*******\n" + class1.exist(matrix, "AAA"));

    }

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        boolean matchFound = false;
        Set<Integer> isVisited = new HashSet<>();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(board[row][col] == word.charAt(0)){
                    isVisited.add(col * cols + row);

                    // First char is found, check if the word exists
                    matchFound = recursivelyCheckForRemainingChars(word, 1, row, col, board, rows, cols, isVisited);
                    if(matchFound) return matchFound;

                    isVisited.remove(col * cols + row);
                }
            }
        }

        return false;
    }

    public boolean recursivelyCheckForRemainingChars(String word, int currIdx, int row, int col, char [][] board, int rows, int cols, Set<Integer> isVisited){

        boolean matchFound = false;
        if(currIdx >= word.length())  return true;
        if(row < 0 || row >= rows || col < 0 || col >= cols )   return false;

        int [] x = new int [] {0, 0, -1, 1};
        int [] y = new int [] {-1, 1, 0, 0};
        int directions = 4;
        for(int direction=0 ; direction < directions; direction++){

            int newRow = row+x[direction];
            int newCol = col+y[direction];

            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols )
                continue;

            if(board[newRow][newCol] == word.charAt(currIdx) && !isVisited(newRow, newCol,isVisited, cols)){

                isVisited.add(newRow * cols + newCol);
                matchFound = recursivelyCheckForRemainingChars(word, currIdx+1, newRow, newCol, board, rows, cols, isVisited);
                if(matchFound) return matchFound;
                isVisited.remove(newRow * cols + newCol);
            }

        }

        return false;

    }

    public boolean isVisited(int row, int col, Set<Integer> isVisited, int cols){
        int id = row * cols + col;
        return isVisited.contains(id);
    }

}
