package Array.problems;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        TrappingRainWater water = new TrappingRainWater();
        int[] arr_i_input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] arr_i_input = {2,0,2};
        //int[] arr_i_input = {5, 4, 1, 2};
        //int[] arr_i_input = {4,2,0,3,5};
        //int[] arr_i_input = {0,7,1,4,6};
        //int[] arr_i_input = {4,9,4,5,3,2};
        //System.out.println(water.usingTWoPointers(arr_i_input));
        System.out.println(water.trap(arr_i_input));

    }

    public int trap(int[] height) {

        if (height == null) {
            return 0;
        }

        int totalWater = 0;
        int length = height.length;
        int [] leftMax = new int [height.length];
        int [] rightMax = new int [height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        for (int i = 0; i < length; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    public int usingTWoPointers(int[] height) {

        if (height.length < 3)
            return 0;

        int h1 = -1;
        int h2 = -1;
        int out = 0;
        int currSmallest = Integer.MAX_VALUE;
        int currTallest = Integer.MIN_VALUE;

        for (int j = 0; j < height.length; j++) {
            if (h1 == -1 && height[j] == 0) {
                continue;
            } else {
                if (h1 == -1) {

                    while (j+1 < height.length && height[j + 1] > height[j]) {
                        j++;
                    }

                    h1 = j;
                    currSmallest = j;
                    currTallest = j;
                } else {

                    if (height[h1] >= height[j]) {
                        h2 = height[j];

                        if (j == h1 + 1) {
                            currSmallest = j;
                            currTallest = j;
                        } else {
                            currSmallest = height[j] < height[currSmallest] ? j : currSmallest;
                            currTallest = height[j] >= height[currTallest] ? j : currTallest;

                            if(currSmallest > currTallest && height[j] > height[currSmallest]){
                                currTallest = j;
                            }
                        }
                        continue;
                    }

                    if (height[j] > height[h1]) {
                        while (j+1 < height.length && height[j + 1] > height[h1]) {
                            j++;
                        }
                        out += getWaterTrap(h1, j, height);
                        h1 = j;
                        h2 = 0;
                        currSmallest = j;
                        currTallest = j;

                    }
                }
            }
        }

        out += getWaterTrap(h1, currTallest, height);


        return out;

    }

    public int getWaterTrap(int left, int right, int[] height) {
        int minHeight = Math.min(height[left], height[right]);
        int out = 0;
        for (int k = left + 1; k < right; k++) {
            if(height[k] > minHeight)
                continue;
            out += minHeight - height[k];
        }
        return out;
    }

}