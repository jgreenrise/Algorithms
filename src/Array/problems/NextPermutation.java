package Array.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String args[]) {

        NextPermutation class1 = new NextPermutation();
        int [][] nums= {
        //        {1,2},
         //       {1,2,3},
         //       {1,2,3, 1},
         //       {1,3,4,2},
         //       {9,8,2,6,5}
                    {2,6,5}
        };

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Next Permutation" + Arrays.toString(class1.nextPermutation(nums[i])));
        }

    }

    public int[] nextPermutation(int[] nums) {

        if(nums.length == 2){
            swap(0,1, nums);
            return nums;
        }

        int originalNumber = getNumberFromArray(nums);
        int tempNum = nums[nums.length - 1];
        int maxIndex = nums.length - 1;

        for(int j = nums.length - 2; j >= 0; j--){
            int currNum = nums[j];

            if(currNum < nums[maxIndex]){
                swap(maxIndex, j, nums);
            }else{
                maxIndex = moveElementAtIndex(j, nums);
            }

            if(isNextPermutation(originalNumber, nums)){
                return nums;
            }
        }
        return nums;

    }

    public int getNumberFromArray(int [] nums){
        StringBuilder strNum = new StringBuilder();
        for (int num : nums)
            strNum.append(num);
        return Integer.parseInt(strNum.toString());
    }

    public boolean isNextPermutation(int origNumber, int [] nums){
        int currNumber = getNumberFromArray(nums);
        return origNumber < currNumber;
    }

    public int moveElementAtIndex(int index, int [] nums){

        while(
            // Out of bound check
                (index+1 < nums.length) &&
                        // Check if move is required
                        (nums[index] > nums[index+1]))
        {
            swap(index, index+1, nums);
            index++;
        }
        return index;
    }

    public void swap(int fromIndex, int endIndex, int[] nums){
        int tmp = nums[fromIndex];
        nums[fromIndex] = nums[endIndex];
        nums[endIndex] = tmp;
    }
}
