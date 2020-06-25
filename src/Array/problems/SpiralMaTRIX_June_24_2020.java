package Array.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMaTRIX_June_24_2020 {

    public static void main(String[] args) {

        SpiralMaTRIX_June_24_2020 class1 = new SpiralMaTRIX_June_24_2020();

        // 4 by 4
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        matrix = new int[][]{{3}, {2}};

        System.out.println(class1.spiralOrder(matrix));

/*
		int[][] matrix = { { 1, 1} };
		System.out.println(class1.searchMatrixTwice(matrix, 0));
		System.out.println(class1.searchMatrixTwice(matrix, 0));
*/

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
                    if (col+1 == cols - boundary) {
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
                    if (row+1 == rows - boundary) {
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
