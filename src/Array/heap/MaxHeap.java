package Array.heap;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        int[] arr_i_input = {1, 4, 7, 3, 8, 5};
        System.out.println(Arrays.toString(arr_i_input));
        buildHeap(arr_i_input);
    }

    private static void buildHeap(int[] arr_i_input) {
        int[] oArr = new int[arr_i_input.length];
        for (int i = 0; i < arr_i_input.length; i++) {
            oArr = buildMaxHeap(arr_i_input[i], oArr, i);
        }
        System.out.println(Arrays.toString(oArr));
    }

    private static int[] buildMaxHeap(int i, int[] oArr, int currIndex) {
        if (currIndex == 0) {
            oArr[currIndex] = i;
            return oArr;
        } else {
            oArr[currIndex] = i;
            if (oArr[currIndex] > oArr[(currIndex - 1) / 2])
                oArr = percolateUp(currIndex, oArr);
            return oArr;
        }
    }

    private static int[] percolateUp(int currIdx, int[] nums) {
        if (nums[currIdx] > nums[(currIdx - 1) / 2]) {
            nums = swap(currIdx, (currIdx - 1) / 2, nums);
            upgradeChildNodes(currIdx, nums);
            if ((currIdx - 1) / 2 == 0) return nums;
            else percolateUp((currIdx - 1) / 2, nums);
        }
        return nums;
    }

    /**
     * Incomplete code
     **/
    private static void upgradeChildNodes(int currIdx, int[] nums) {
        int length = nums.length;
        int leftChildIdx = (2 * currIdx + 1) < nums.length ? nums[2 * currIdx + 1] : -1;
        int rightChildIdx = (2 * currIdx + 2) < nums.length ? nums[2 * currIdx + 2] : -1;
    }

    private static int[] swap(int currIndex, int parentIndex, int[] oArr) {
        int tmp = oArr[currIndex];
        oArr[currIndex] = oArr[parentIndex];
        oArr[parentIndex] = tmp;
        return oArr;
    }


}
