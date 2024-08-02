package Array.problems.meetingRooms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms_2_2020_06_24 {

    public static void main(String[] args) {

        MeetingRooms_2_2020_06_24 class1 = new MeetingRooms_2_2020_06_24();

        // 4 by 4
        int[][] matrix = {{0, 30}, {25, 30}, {15, 25}, {5, 10}, {10, 20}};
        //matrix = new int[][] {{13, 15}, {1, 13}};
        //matrix = new int[][] {{0, 30},{5, 10},{15, 20}};
        //int[][] matrix = {{0,30}, {26, 30}, {25,28}, {5,10}, {10, 15}, {20, 25}, {12, 20}};
        //int[][] matrix = {{7,10}, {2, 4}};
        //int[][] matrix = {{4,9}, {9,10}, {4,17}};
        //matrix = new int[][] {{2,11}, {6,16}, {11, 16}};
        //matrix = new int[][] {{5, 10}, {15, 20}, {0, 30}};


        System.out.println(class1.minMeetingRooms(matrix));
        //System.out.println(class1.usingStartAndEndArray(matrix));

    }

    // Using Priroity Queue
    public int minMeetingRooms(int[][] intervals) {


        if (intervals.length == 0) {
            return 0;
        }

        // Sort by Start value, then by end value
        Arrays.sort(intervals, (left, right) -> {
            if (left[0] == right[0]) {
                return Integer.compare((left[1]), right[1]);
            }
            return Integer.compare((left[0]), right[0]);
        });


        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));
        minHeap.add(intervals[0][1]);

        for (int row = 1; row < intervals.length; row++) {

            Integer root = minHeap.remove();
            int[] curr = intervals[row];
            int start = curr[0];
            int end = curr[1];

            if (start < root) {
                minHeap.add(root);
                minHeap.add(end);
            } else if (start >= root) {
                root = end;
                minHeap.add(root);
            }
        }

        return minHeap.size();

    }


    public int usingStartAndEndArray(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }


        int[] start = getStartTimes(intervals);
        int[] end = getEndTimes(intervals);

        int i = 0, j = 0, value = 0, max = Integer.MIN_VALUE;

        while (i < start.length && j < end.length) {

            if (start[i] < end[j]) {
                value++;
                max = Math.max(max, value);
                i++;
            } else if (start[i] == end[j]) {
                i++;
                j++;
            } else {
                //start[i] > end[j]
                value--;
                j++;
            }
        }

        return max;


    }

    private int[] getStartTimes(int[][] intervals) {

        int[] out = new int[intervals.length];
        Arrays.sort(intervals, (left, right) -> ((Integer) (left[0])).compareTo(right[0]));

        for (int row = 0; row < intervals.length; row++) {
            out[row] = intervals[row][0];
        }
        return out;

    }

    private int[] getEndTimes(int[][] intervals) {

        int[] out = new int[intervals.length];
        Arrays.sort(intervals, (left, right) -> ((Integer) (left[1])).compareTo(right[1]));

        for (int row = 0; row < intervals.length; row++) {
            out[row] = intervals[row][1];
        }
        return out;

    }


}
