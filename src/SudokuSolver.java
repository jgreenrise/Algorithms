public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solveSudokuv2(board);
    }

    public boolean solveSudokuv2(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') { // Check for an empty cell
                    for (char num = '1'; num <= '9'; num++) { // Try numbers 1-9
                        if (isValid(r, c, board, num)) {
                            board[r][c] = num; // Place the number
                            if (solveSudokuv2(board)) { // Recursively solve
                                return true;
                            }
                            board[r][c] = '.'; // Backtrack if needed
                        }
                    }
                    return false; // No valid number found, backtrack
                }
            }
        }
        return true; // Sudoku is solved
    }

    public boolean isValid(int row, int col, char[][] board, char num) {
        // Check if the number is in the current row or column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // Valid placement
    }

}
