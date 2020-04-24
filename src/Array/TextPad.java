package Array;

import java.util.Arrays;

public class TextPad {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 3, 2, 4};
        System.out.println("Input String: " + Arrays.toString(input) + "Output: " + checkPossibility(input));

        input = new int[]{3, 4, 2, 3};
        System.out.println("Input String: " + Arrays.toString(input) + "Output: " + checkPossibility(input));

        input = new int[]{4, 2, 3};
        System.out.println("Input String: " + Arrays.toString(input) + "Output: " + checkPossibility(input));

        input = new int[]{4, 2, 1};
        System.out.println("Input String: " + Arrays.toString(input) + "Output: " + checkPossibility(input));
    }

    public static boolean checkPossibility(int[] nums) {

        int min = 0;
        int max = 0;
        int counter = 0;

        for (int j = 0; j <= nums.length - 2; j++) {
            //System.out.println("Comparing: " + nums[j] + " --- " + nums[j + 1]);

            if (j == 0) {
                if (nums[j + 1] >= nums[j]) {
                    max = nums[j + 1];
                } else {
                    max = nums[j];
                    counter++;
                }
                continue;
            }

            if (counter > 0) {
                /**
                 * False condition already found
                 */

                // Test between items at index i and i+1
                if (nums[j + 1] >= nums[j]) {

                    // Check whether New element is smaller than max
                    if (j != 1 && nums[j + 1] < max) {
                        return false;
                    }

                    max = nums[j + 1];
                } else {
                    // Second false condition found
                    return false;
                }
            } else {

                /**
                 * False condition NOT found
                 */

                if (nums[j + 1] >= nums[j]) {
                    max = nums[j + 1];
                } else {
                    max = nums[j];
                    counter++;
                }
            }

        }

        if (counter > 1)
            return false;

        return true;

    }
}
