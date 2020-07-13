package Array.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-square/
 */
public class ValidSquare {

    public static void main(String[] args) {

        ValidSquare class1 = new ValidSquare();

        /**
         * 1. Sort by x co-ordinate, then by Y co-ordinate
         * 2. Check if all edges are equals and diagonals are equal
         */
        System.out.println(class1.validSquareSorting(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));

        /**
         * From point 1, how many diagonal are possible. ?
         * 3
         * I: p1, p2, II: p1, p3, III: p1, p4
         * Check if (Combination1) || (C2) || C3 is a square.
         */
        System.out.println(class1.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }


    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return distance(p1, p2) > 0 && distance(p1, p2) == distance(p2, p3) && distance(p2, p3) == distance(p3, p4) && distance(p3, p4) == distance(p4, p1) && distance(p1, p3) == distance(p2, p4);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }


    public boolean validSquareSorting(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][] p = {p1, p2, p3, p4};

        // TC: (O(n))
        Arrays.sort(p, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);

        return // Check if all edges distance are same
                distance(p[0], p[1]) == distance(p[1], p[3])
                        && distance(p[1], p[3]) == distance(p[3], p[2])
                        && distance(p[3], p[2]) == distance(p[0], p[2])
                        // Diagonal
                        && distance(p[0], p[3]) == distance(p[1], p[2]);


    }

    private double distance(int[] left, int[] right) {

        // Distance between point x2, x1 : dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        //return Math.sqrt( (right[0] - left[0]) * (right[0] - left[0]) + (right[1] - left[1]) * (right[1] - left[1]))

        return (right[0] - left[0]) * (right[0] - left[0]) + (right[1] - left[1]) * (right[1] - left[1]);
    }

}