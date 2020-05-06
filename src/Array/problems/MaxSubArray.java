package Array.problems;

public class MaxSubArray {

    public static void main(String[] args) {

        int[] arr_i_input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arr_i_input = {-1, -2};
        //int[] arr_i_input = {5,7};

		/**
		 * Space complexity: 0(1), TC : 0(n)
		 */
		System.out.println(maxSubArray_KandanesAlgo(arr_i_input));

		/**
		 * Time Complexity: The recurrence relation formed for this Divide and Conquer approach is similar to the recurrence       relation
		 * of Merge Sort
		 * T(n) = 2T(n/2) + O(n) = O(nlogn)
		 */
        System.out.println(divideAndConquerApproach(arr_i_input));

		/**
		 * Space complexity: 0(n), TC : 0(n)
		 */
		System.out.println(auxillaryArray(arr_i_input));

    }

	/**
	 * Create a seperate int array
	 * Save dp[i] = Math.max(arr[i], arr[i] + dp[i-1])
	 */
	public static int auxillaryArray(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		int max = Integer.MIN_VALUE;

		for (int j = 0; j < nums.length; j++) {
			if(j == 0){
				nums[j] = nums[j];
			}else{
				nums[j] = Math.max(nums[j], nums[j]+nums[j-1]);
			}
			if(nums[j] > max)
				max = nums[j];
		}

		return max;

	}


    public static int crossSum(int[] nums, int start, int end, int p) {
        if (start == end)
            return nums[start];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i > start - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = p + 1; i < end + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public static int helper(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int mid = (start + end) / 2;

        int leftSum = helper(nums, start, mid);
        int rightSum = helper(nums, mid + 1, end);
        int crossSum = crossSum(nums, start, end, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }


    public static int divideAndConquerApproach(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static int maxSubArray_KandanesAlgo(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int max = Integer.MIN_VALUE;
        int max_so_far = Integer.MIN_VALUE;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > max_so_far) {
                if (max_so_far < 0) {
                    // A: Assign value when item > 0
                    max_so_far = nums[j];
                } else {
                    // B: Sum to prev_sum
                    max_so_far = nums[j] + max_so_far;
                }
            } else {
                // C: Sum to prev_sum
                max_so_far = nums[j] + max_so_far;
            }

            if (max < max_so_far)
                max = max_so_far;

        }

        return max;

    }


}