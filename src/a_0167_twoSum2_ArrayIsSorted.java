// https://leetcode.com/problems/two-sum/?envType=study-plan-v2&envId=top-interview-150
public class a_0167_twoSum2_ArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (rightPtr > leftPtr) {
            int currTot = numbers[leftPtr] + numbers[rightPtr];
            if (currTot > target) {
                rightPtr--;
            } else if (currTot < target) {
                leftPtr++;
            } else {
                return new int[]{leftPtr + 1, rightPtr + 1};
            }
        }
        return new int[]{leftPtr + 1, rightPtr + 1};
    }

}
