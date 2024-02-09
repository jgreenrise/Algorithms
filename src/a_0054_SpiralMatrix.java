import java.util.ArrayList;
import java.util.List;

public class a_0054_SpiralMatrix {

    public static void main(String[] args) {

        a_0054_SpiralMatrix class1 = new a_0054_SpiralMatrix();

        // 4 by 4
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        matrix = new int[][]{{3}, {2}};

        System.out.println(class1.spiralOrderLoop(matrix));

    }

    public List<Integer> spiralOrderLoop(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        spiralHelper(matrix, 0, 0, "right", visited, result);
        return result;
    }

    private void spiralHelper(int[][] matrix, int row, int col, String direction, boolean[][] visited, List<Integer> result) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        result.add(matrix[row][col]);

        if (direction.equals("right")) {
            if (col + 1 < cols && !visited[row][col + 1]) {
                spiralHelper(matrix, row, col + 1, direction, visited, result);
            } else {
                spiralHelper(matrix, row + 1, col, "down", visited, result);
            }
        } else if (direction.equals("down")) {
            if (row + 1 < rows && !visited[row + 1][col]) {
                spiralHelper(matrix, row + 1, col, direction, visited, result);
            } else {
                spiralHelper(matrix, row, col - 1, "left", visited, result);
            }
        } else if (direction.equals("left")) {
            if (col - 1 >= 0 && !visited[row][col - 1]) {
                spiralHelper(matrix, row, col - 1, direction, visited, result);
            } else {
                spiralHelper(matrix, row - 1, col, "up", visited, result);
            }
        } else if (direction.equals("up")) {
            if (row - 1 >= 0 && !visited[row - 1][col]) {
                spiralHelper(matrix, row - 1, col, direction, visited, result);
            } else {
                spiralHelper(matrix, row, col + 1, "right", visited, result);
            }
        }
    }

    public List<Integer> spiralOrder(int[][] mat) {


        int rows = mat.length;

        if (rows == 0) {
            return new ArrayList();
        }

        int cols = mat[0].length;


        String direction = "RIGHT";
        List<Integer> out = new ArrayList();
        int boundary = 0;
        int row = 0;
        int col = 0;
        out.add(mat[row][col]);
        mat[row][col] = -1;
        int lowestCol = 0;
        int lowestRow = 0;
        int totalItems = rows * cols;

        while (row < rows && col < cols && row > -1 && col > -1) {

            if (out.size() == totalItems) {
                return out;
            }

            switch (direction) {
                case "RIGHT":
                    if (col + 1 == cols - boundary) {
                        direction = "DOWN";
                        continue;
                    } else {
                        col++;
                        out.add(mat[row][col]);
                        mat[row][col] = -1;
                        if (col == cols - 1 - boundary)
                            direction = "DOWN";
                    }
                    break;
                case "DOWN":
                    if (row + 1 == rows - boundary) {
                        direction = "LEFT";
                        continue;
                    } else {
                        row++;
                        out.add(mat[row][col]);
                        mat[row][col] = -1;
                        if (row == rows - 1 - boundary)
                            direction = "LEFT";
                    }
                    break;
                case "LEFT":
                    col--;
                    out.add(mat[row][col]);
                    mat[row][col] = -1;
                    if (col == lowestCol) {
                        direction = "TOP";
                    }
                    break;
                case "TOP":
                    row--;
                    out.add(mat[row][col]);
                    mat[row][col] = -1;
                    if (row == lowestRow + 1) {
                        direction = "RIGHT";
                        boundary++;
                        lowestRow++;
                        lowestCol++;
                    }
                    break;
            }

        }

        return out;
    }


}
