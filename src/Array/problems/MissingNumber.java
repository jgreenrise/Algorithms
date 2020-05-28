package Array.problems;

public class MissingNumber {

    public static void main(String[] args) {

        MissingNumber missingNumber = new MissingNumber();

        int[] nums = {3, 0, 1};
        System.out.println(missingNumber.booleanArray(nums));
        System.out.println(missingNumber.usingXor(nums));

    }

    private int usingXor(int[] nums) {

        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public int booleanArray(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            }
            if (nums[0] == 1) {
                return 0;
            }
            return -1;
        }

        int max = -1;
        boolean matchFound = false;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        boolean[] bools = new boolean[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bools[nums[i]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!bools[i]) {
                return i;
            }
        }

        if (!matchFound) {
            return nums.length;
        }

        return -1;
    }


}