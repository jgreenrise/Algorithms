package Array.problems.threesum;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        ThreeSum class1 = new ThreeSum();

        //int [][] inputs = {{0,0,0,0}};
        //int[][] inputs = {{0, 0, 0}};
        //int[][] inputs = {{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}};
        int[][] inputs = {{-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3}};
        //int [][] inputs = {{-1,0,1,2,-1,-4}, {0,0,0,0}};

        for (int[] input : inputs)
            System.out.println(class1.threeSum(input));

    }

	/**
	 * TC: O(n2) = n * (two_sum > O(n))
	 * SP: O(n)
	 */
	public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> out = new ArrayList();
        int target = 0;
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {

            // If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
            if (nums[j] > 0)
                break;

            // If the current value is the same as the one before, skip it.
            if (j != 0 && nums[j] == nums[j - 1])
                continue;

            twoSum(j + 1, out, nums, j);
        }

        return out;
    }

    public void twoSum(int left, List<List<Integer>> out, int[] nums, int parentIndex) {

        int right = nums.length - 1;
        int target = 0;

        // Save start Value and end Value to avoid dups
        int startValue = -1, endValue = -1;

        while (left < right && right <= nums.length) {

            int currTarget = nums[left] + nums[right] + nums[parentIndex];

            if (currTarget < target) {
            	int currLeft = nums[left];

            	// Skip dups
            	while(nums[left+1] == currLeft){
            		left++;
				}

                left++;
            } else if (currTarget > target) {
				int currRight = nums[right];

				// Skip dups
				while(nums[right-1] == currRight){
					right--;
				}
                right--;
            } else {
                if (endValue == -1 && startValue == -1) {

                	// Save to list
                    List currList = Arrays.asList(nums[parentIndex], nums[left], nums[right]);
                    out.add(currList);
                    startValue = nums[left];
                    endValue = nums[right];
                } else {
                    if (startValue == nums[left] && endValue == nums[right]) {
                        System.out.println("Already added to list");
                    } else {

                    	// New record found, add to list
                        List currList = Arrays.asList(nums[parentIndex], nums[left], nums[right]);
                        out.add(currList);

                        // Update references to avoid dups
						startValue = nums[left];
						endValue = nums[right];
                    }
                }
                right--;
            }
        }

    }


}
