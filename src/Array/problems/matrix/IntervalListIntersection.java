package Array.problems.matrix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersection {

    public static void main(String[] args) {

        IntervalListIntersection class1 = new IntervalListIntersection();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

       /* int[][] A = {{5,10}};
        int[][] B = {{5,6}};*/
        printMatrix(class1.intervalIntersection(A, B));


    }

    public static void printMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if(A.length == 0 || B.length == 0){
            return new int[][]{};
        }

        int maxAVal = A[A.length - 1][A[0].length - 1];
        int maxBVal = B[B.length - 1][B[0].length - 1];
        boolean[] buffer = new boolean[Math.max(maxAVal, maxBVal) + 1];

        for (int row = 0; row < A.length; row++) {
            int start = A[row][0];
            int end = A[row][1];

            for (; start < end; start++) {
                buffer[start] = true;
            }
        }

        int[][] out = new int[buffer.length][2];
        int intersectionCount = 0;

        for (int row = 0; row < B.length; row++) {
            int start = B[row][0];
            int end = B[row][1];

            if(buffer[start-1] && !buffer[start]){
                out[intersectionCount][0] = start;
                out[intersectionCount][1] = start;
                intersectionCount++;
            }

            for (; start < end; start++) {
                if (buffer[start]) {
                    start = getNewStartRange(out, start, end, intersectionCount, buffer);
                    intersectionCount++;
                }
            }

            if(buffer[end] && start < end){
                out[intersectionCount][0] = end;
                out[intersectionCount][1] = end;
                intersectionCount++;
            }
        }

        return Arrays.copyOf(out, intersectionCount);
    }

    public int getNewStartRange(int[][] out, int start, int end, int intersectionCount, boolean[] buffer) {

        out[intersectionCount][0] = start;

        if (start != end) {
            //while (start <= end && buffer[start]) {
            while (start < end && buffer[start]) {
                start++;
            }
        }

        out[intersectionCount][1] = start;
        return start;

    }


}
