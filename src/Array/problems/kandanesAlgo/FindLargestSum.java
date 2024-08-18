package Array.problems.kandanesAlgo;

/**
 * Kadane's Algorithm requires at least one positive number, so your all
 * negative array is invalid input.
 */
public class FindLargestSum {

    public static void main(String[] args) {

        //System.out.println(largestSum(new int[]{-2, -3, 4}));
        System.out.println(largestSum(new int[]{-2, 1, -3, 4, -1, -2, 1, 5, -3}));
        /**
         System.out.println(largestSum(new int[]{-1, 3, -5, 4, 6, -1, 2, -7, 13, -3}));
         System.out.println(largestSum(new int[]{-6, 2, -3, -4, -1, -5, -5}));
         System.out.println(largestSum(new int[]{4, -9, 3, -2, 4, -12}));
         System.out.println(largestSum(new int[]{5, 2, -4, 3, 2, -8, 7, 6, -1, -2, 3, -50}));
         System.out.println(largestSum(new int[]{2, 4, 22, 19, -48, -5, 20, 40}));
         System.out.println(largestSum(new int[]{9, 2, 10, -1, -2, 5, -3, 3, -4, -1}));
         System.out.println(largestSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
         System.out.println(largestSum(new int[]{5, -1, 10, -11}));
         System.out.println(largestSum(new int[]{2, -4, -6, 9, 8, -11, 10, 2, -20}));
         **/

    }

    public static int largestSum(int[] input) {

        if (input.length == 1) return input[0];

        int maxSubarraySum = input[0];
        int currSubarraySum = input[0];

        for (int i = 1; i < input.length; i++) {

            currSubarraySum = Math.max(input[i], currSubarraySum + input[i]);
            maxSubarraySum = Math.max(maxSubarraySum, currSubarraySum);

            //System.out.println(currSubarraySum + "\t" + maxSubarraySum);

        }

        return maxSubarraySum;

    }

}
