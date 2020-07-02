package Array.problems.meetingRooms;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-intervals/submissions/
 */
public class MergeIntervals_2020_07_01 {

    public static void main(String[] args) {

        MergeIntervals_2020_07_01 class1 = new MergeIntervals_2020_07_01();

        // 4 by 4
        int[][] matrix = {{15, 18}, {2, 6}, {8, 10}, {1, 3}};
        matrix = new int[][]{{1, 4}, {2, 3}};
        //matrix = new int[][] {{0, 30},{5, 10},{15, 20}};

        //System.out.println(Arrays.toString(class1.merge_usingStartAndEndArray(matrix)));

        System.out.println(Arrays.toString(class1.merge(matrix)));


    }

    public int[][] merge(int[][] intervals) {

        int rows = intervals.length;
        int[][] res = new int[rows][2];
        int k = 0;

        if (rows == 0) {
            return Arrays.copyOf(res, k);
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (left, right) -> left[0] - right[0]);

        // Create Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.add(intervals[0][0]);
        pq.add(intervals[0][1]);

        for (int row = 1; row < rows; row++) {
            int poll = pq.poll();

            // Check if should merge
            if (intervals[row][0] <= poll) {

                if (poll > intervals[row][1]) {
                    // Skip this record {1,4} {2,3}, since 4 > 3
                    pq.add(poll);
                } else {
                    pq.add(intervals[row][1]);
                }
            } else {

                // Cannot merge, Add it to output arr
                res[k][0] = pq.poll();
                res[k][1] = poll;
                k++;

                // Re intialize pq
                pq.add(intervals[row][0]);
                pq.add(intervals[row][1]);
            }
        }

        if (pq.size() > 1) {
            res[k][1] = pq.poll();
            res[k][0] = pq.poll();
            k++;
        }

        return Arrays.copyOf(res, k);
    }

    public int[][] merge_usingStartAndEndArray(int[][] intervals) {

        int rows = intervals.length;
        int[][] res = new int[rows][2];
        int k = 0;

        if (rows == 0) {
            return Arrays.copyOf(res, k);
        }

        int[] startTimes = getStartTimes(intervals);
        int[] endTimes = getEndTimes(intervals);
        int left = 0;
        int right = 0;

        while (left < rows && right < rows) {

            if (right + 1 < startTimes.length && startTimes[right + 1] < endTimes[right]) {
                right = right + 1;
            } else {
                res[k][0] = startTimes[left];
                res[k][1] = endTimes[right];
                left = right + 1;
                right = right + 1;
                k++;
            }
        }

        return Arrays.copyOf(res, k);
    }

    public int[] getStartTimes(int[][] mat) {

        Arrays.sort(mat, (left, right) -> left[0] - right[0]);
        int rows = mat.length;

        int[] res = new int[rows];
        for (int row = 0; row < rows; row++) {
            res[row] = mat[row][0];
        }
        return res;
    }

    public int[] getEndTimes(int[][] mat) {

        Arrays.sort(mat, (left, right) -> left[1] - right[1]);

        int rows = mat.length;
        int[] res = new int[rows];
        for (int row = 0; row < rows; row++) {
            res[row] = mat[row][1];
        }
        return res;
    }


}
