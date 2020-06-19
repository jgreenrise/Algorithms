package Array.problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_2020_06_18 {


    public static void main(String[] args) {
        ProductOfArrayExceptSelf_2020_06_18 class2 = new ProductOfArrayExceptSelf_2020_06_18();

        int[][] mat = {{4,3,1,2}, {1,2,3,4}};
        for (int[] row : mat) {
            System.out.println(Arrays.toString(class2.productExceptSelf(row)));
        }
    }


    public int[] productExceptSelf(int[] nums) {

        int out[] = new int[nums.length];
        int prev = nums[0];
        out[0] = 1;

        for (int j = 1; j < nums.length; j++) {
            out[j] = out[j - 1] * prev;
            prev = nums[j];
        }

        prev = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            out[j] = out[j] * prev;
            prev = prev * nums[j];
        }

        return out;

    }


}