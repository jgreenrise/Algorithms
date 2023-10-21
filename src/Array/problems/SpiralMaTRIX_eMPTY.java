package Array.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMaTRIX_eMPTY {

    public static void main(String[] args) {

        SpiralMaTRIX_eMPTY class1 = new SpiralMaTRIX_eMPTY();

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

    public List<Integer> spiralOrder(int[][] matrix) {

        return null;


    }


}
