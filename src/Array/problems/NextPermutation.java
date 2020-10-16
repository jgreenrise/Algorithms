package Array.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String args[]) {

        NextPermutation class1 = new NextPermutation();
        int[][] nums = {
                /* {1,2},
                 {3,1,2},
                {3,4,2,1},
              {1, 2, 3, 1},
               {1,3,4,2},
              {9,8,2,6,5},
              {2, 6, 5},
              {20,13,37,42,16},
              {20,82,13,42,16},
              {20,82,37,42,16},
              {20,37,42,16,82},
              {1,2,7,9,6,4,1},
              {1,7,9,9,8,3},*/
                {2, 3, 1, 3, 3}

        };

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Next Permutation: " + Arrays.toString(nums[i]) + " > " + Arrays.toString(class1.nextPermutation(nums[i])));
        }
    }

    private int[] nextPermutation(int[] nums) {

        boolean matchFound = false;

        for (int j = nums.length - 2; j >= 0; j--) {

            if (nums[j] >= nums[j + 1]) {
                continue;
            } else {
                matchFound = true;

                // Get index of next Max
                int indexNextMax = getIndexNextMax(j, nums);

                // Swap with next Max
                swap(j, indexNextMax, nums);

                // Reverse remaining items
                reverse(j + 1, nums);

                break;

            }
        }

        return matchFound ? nums : reverse(0, nums);

    }

    private int[] reverse(int fromIndex, int[] nums) {

        int k = 0;
        int endIndex = fromIndex + (nums.length - fromIndex) / 2;
        for (int i = fromIndex; i < endIndex; i++) {
            if (nums[nums.length - 1 - k] < nums[i]) {
                // Swap between first and last element, second and second last element etc
                int tmp = nums[i];
                nums[i] = nums[nums.length - 1 - k];      // Last value in array
                nums[nums.length - 1 - k] = tmp;
                k++;
            }
        }

        return nums;
    }

    private int getIndexNextMax(int j, int[] nums) {

        int value = nums[j];
        int maxIndex = j + 1;
        for (int i = j + 2; i < nums.length; i++) {

            if (nums[i] == nums[maxIndex])
                continue;

            if (nums[i] > value)
                maxIndex = nums[maxIndex] >= nums[i] ? i : maxIndex;
        }

        return maxIndex;
    }


    public int getNumberFromArray(int[] nums) {
        StringBuilder strNum = new StringBuilder();
        for (int num : nums)
            strNum.append(num);
        return Integer.parseInt(strNum.toString());
    }

    public boolean isNextPermutation(int origNumber, int[] nums) {
        int currNumber = getNumberFromArray(nums);
        return origNumber < currNumber;
    }

    public int moveElementAtIndex(int index, int[] nums) {

        while (
            // Out of bound check
                (index + 1 < nums.length) &&
                        // Check if move is required
                        (nums[index] > nums[index + 1])) {
            swap(index, index + 1, nums);
            index++;
        }
        return index;
    }

    public void swap(int fromIndex, int endIndex, int[] nums) {
        int tmp = nums[fromIndex];
        nums[fromIndex] = nums[endIndex];
        nums[endIndex] = tmp;
    }
}
