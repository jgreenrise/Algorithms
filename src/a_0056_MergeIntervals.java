import Array.problems.meetingRooms.MergeIntervals_2020_07_01;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class a_0056_MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals_2020_07_01 class1 = new MergeIntervals_2020_07_01();

        // 4 by 4
        int[][] matrix = {{15, 18}, {2, 6}, {8, 10}, {1, 3}};
        matrix = new int[][]{{1, 4}, {2, 3}};
        //matrix = new int[][] {{0, 30},{5, 10},{15, 20}};
        //System.out.println(Arrays.toString(class1.merge_usingStartAndEndArray(matrix)));

        Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.toString(class1.merge(matrix)));

    }

    /**
     * Using Merge sort
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length > 1) {
            int[][] left = Arrays.copyOfRange(intervals, 0, intervals.length / 2 - 1);
            int[][] right = Arrays.copyOfRange(intervals, intervals.length / 2, intervals.length - 1);
            merge(left);
            merge(right);
            intervals = mergeSort(left, right, intervals);
        }
        return intervals;
    }

    public int[][] mergeSort(int[][] left, int[][] right, int[][] intervals) {

        int[][] out = new int[intervals.length][intervals.length];
        int currSize = 0;
        int[] prevItem = left[left.length - 1];
        int[] newItem = right[right.length - 1];

        if (newItem[0] <= prevItem[1] && prevItem[1] <= newItem[1]) {
            prevItem[1] = newItem[1];
            left[left.length - 1] = prevItem;
            int[][] right2 = Arrays.copyOfRange(right, 1, right.length - 1);
        } else if (newItem[0] <= prevItem[1] && prevItem[1] > newItem[1]) {
            // Do nothing
        } else {
            out[currSize] = newItem;
            currSize++;
        }

        return null;

    }

    /**
     * 2. USING PRIORiTY QUEUE
     * Memory Limit Exceeded
     */
    public int[][] mergeUsingPQ(int[][] intervals) {

        int[][] out = new int[intervals.length][intervals.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.addAll(Arrays.asList(intervals));

        int currSize = 0;
        while (!pq.isEmpty()) {

            if (currSize == 0) {
                out[currSize] = pq.poll();
                currSize++;
            } else {
                int[] currItem = pq.poll();
                int[] prevItem = out[currSize - 1];
                if (currItem[0] <= prevItem[1] && prevItem[1] <= currItem[1]) {
                    prevItem[1] = currItem[1];
                    out[currSize - 1] = prevItem;
                } else if (currItem[0] <= prevItem[1] && prevItem[1] > currItem[1]) {
                    continue;
                } else {
                    out[currSize] = currItem;
                    currSize++;
                }
            }
        }

        return Arrays.copyOfRange(out, 0, currSize);

    }

    /**
     * 3. Using ARRAYS ONLY
     * Memory Limit Exceeded
     */
    public int[][] mergeUsingArrays(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] out = new int[intervals.length][intervals.length];
        int currSize = 0;
        out[currSize++] = intervals[0];

        for (int j = 1; j < intervals.length; j++) {

            int[] prevItem = out[currSize - 1];
            int[] newItem = intervals[j];

            if (newItem[0] <= prevItem[1] && prevItem[1] <= newItem[1]) {
                prevItem[1] = newItem[1];
                out[currSize - 1] = prevItem;
            } else if (newItem[0] <= prevItem[1] && prevItem[1] > newItem[1]) {
                continue;
            } else {
                out[currSize] = newItem;
                currSize++;
            }
        }

        return Arrays.copyOfRange(out, 0, currSize);
    }

}
