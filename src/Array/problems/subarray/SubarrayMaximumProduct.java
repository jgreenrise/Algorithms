package Array.problems.subarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class SubarrayMaximumProduct {

    public static void main(String[] args) {

        SubarrayMaximumProduct class1 = new SubarrayMaximumProduct();

        //System.out.printf("Sub array: " + class1.maxProduct(new int[]{-6, 4, -5, 8, -10, 0, 8}));
        System.out.printf("Sub array: " + class1.maxProduct(new int[]{2,3,-1,6,9,0,7,3}));

    }

    public int maxProduct(int[] nums) {

        int prod = 1;
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        prod = 1;

        for(int i = nums.length - 1; i >= 0; i--) {

            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        return result;
    }

    public int maxProduct2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int prev_max = nums[0];
        int prev_min = nums[0];
        int global_max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int currVal = nums[i];
            int currMax = currVal * prev_max;
            int currMin = currVal * prev_min;

            prev_max = Math.max(currVal, Math.max(currMax, currMin));
            prev_min = Math.min(currVal, Math.min(currMax, currMin));

            System.out.println("prev max " + prev_max + ", " + prev_min);

            if (prev_max > global_max) {
                global_max = prev_max;
            }

        }

        return global_max;

    }


}