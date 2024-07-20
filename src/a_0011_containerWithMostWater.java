// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
public class a_0011_containerWithMostWater {

    public int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int maxHeight = 0;
        int currOut = 0;
        while (leftPtr < rightPtr) {
            maxHeight = Math.min(height[leftPtr], height[rightPtr]) * (rightPtr - leftPtr);
            currOut = Math.max(maxHeight, currOut);
            if (height[leftPtr] >= height[rightPtr]) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }
        return currOut;
    }

}
