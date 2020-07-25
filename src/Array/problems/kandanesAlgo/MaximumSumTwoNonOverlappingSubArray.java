package Array.problems.kandanesAlgo;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class MaximumSumTwoNonOverlappingSubArray {

    public static void main(String[] args) {

        MaximumSumTwoNonOverlappingSubArray class1 = new MaximumSumTwoNonOverlappingSubArray();

        //System.out.println(class1.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 3, 3));
        //System.out.println(class1.maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
        System.out.println(class1.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
        //System.out.println(class1.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        // L .. M ..
        // M ... L ...
        int[] leftPreSum = getRunningSum(A);
        int[] rightPreSum = getRightRunningSum(A);
        return Math.max(find(leftPreSum, rightPreSum, L, M), find(leftPreSum, rightPreSum, M, L));
    }

    private int find(int[] leftSum, int[] rightSum, int L, int M) {
        int leftMax = leftSum[L - 1];
        int rightMax = rightSum[rightSum.length - M];
        int leftPtr = L - 1;
        int rightPtr = rightSum.length - M;
        int j = 0;
        leftPtr++;
        rightPtr--;

        while (leftPtr <= rightPtr) {

            int currentLeftMax = leftSum[leftPtr] - leftSum[j];
            leftMax = Math.max(leftMax, currentLeftMax);
            leftPtr++;

            if (leftPtr < rightPtr) {
                int currentRightMax = rightSum[rightPtr] - rightSum[rightSum.length - 1 - j];
                rightMax = Math.max(rightMax, currentRightMax);
                rightPtr--;
            }
            j++;
        }

        return leftMax + rightMax;

    }

    private int[] getRunningSum(int[] arr) {
        int[] tmp = new int[arr.length];
        tmp[0] = arr[0];
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = arr[i] + tmp[i - 1];
        }
        return tmp;
    }

    private int[] getRightRunningSum(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] += arr[i + 1];
        }
        return arr;
    }
}
