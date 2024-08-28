package Array.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KLargest {


    public static void main(String[] args) {

        KLargest class1 = new KLargest();
        //a = new int[] { 50, 40, 60, 30, 10, 20 };
        int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

        /**
         * Using Quick Sort
         */
        //System.out.println(class1.findKthLargest(a, 4));
        //System.out.println(class1.findKthLargest(a, 2));
        //System.out.println(class1.findKthLargest(a, 1));
        //System.out.println(class1.findKthLargest(a, 5));

        /**
         * Using PriorityQueue
         */
        System.out.println(class1.findKthLargestUsingPQ(a, 4));

    }

    private int findKthLargestUsingPQ(int[] a, int k) {

        System.out.println("Input array: " + Arrays.toString(a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((c, d) -> d - c);

        for (int j : a) {
            minHeap.offer(j);
            System.out.println(minHeap);
        }
        return minHeap.poll();

    }

    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, k);
    }

    private int sort(int[] arr, int left, int right, int k) {

        if (left < right) {

            int partition = quickSort(arr, left, right);
            int length = arr.length;
            int largestK = length - partition;

            if (largestK == k) {
                return arr[partition];
            }

            if (partition > length - k)
                return sort(arr, left, partition - 1, k);   // Sort left partition
            else
                return sort(arr, partition + 1, right, k);   // Sort right partition
        }

        if (left == right && k == 1) {
            return arr[left];
        }

        return -1;

    }

    private int quickSort(int[] arr, final int inputLeft, final int inputRight) {

        int pivotVal = arr[inputLeft];
        int pivotIndex = inputLeft;
        int left = inputLeft;
        int right = inputRight;

        while (left < right) {

            while (arr[left] <= pivotVal && left < inputRight)
                left++;
            while (arr[right] > pivotVal && right > inputLeft)
                right--;

            if (left < right) {
                swap(arr, left, right);
            } else {
                if (pivotIndex != right)
                    swap(arr, pivotIndex, right);
            }

            System.out.println(Arrays.toString(arr));
        }

        return right;

    }

    private void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }


}
