package recursive.fibonacci.a4_magicIndex;

public class MagicIndex {

    public static void main(String[] args) {

        MagicIndex magic = new MagicIndex();
        int[][] possibleInputs = {
                {-10, -8, -1, 3, 40},
                {-10, -8, -7, -6, 4, 10},
                {-10},

                // With dups
                {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13},
                {-10, 2, 2},
                {-10, 3, 3, 3, 3},
                {-10, -5, -4, -3, -1, 3, 4, 7, 9, 12, 13},
        };
        for (int[] nums : possibleInputs) {
            System.out.println(
                    // TC: O(n), SC: O(1)
                    "Recursion: " + magic.usingRecursion(nums) +
                            /**
                             *    2 is the number of operations inside each recursive call,
                             *    T(n/2) is the recursive call for dividing with sub-problems,
                             *    O(n) here is the linear number of operations for conquering
                             */
                            // TC: O(nlgn), SC: O(n): Stack has to save the info in memory
                            ", DAC: " + magic.usingDivideAndConquer(nums) + ", " +
                            // TC: O(lgn), SC: O(1)
                            // Will not work for dups
                            "BS: " + magic.usingBinarySearch(nums)
                            // TC: O(lgn), SC: O(1)
                            // Will work for dups
                            +", BS with dups: " + magic.usingBinarySearchWithDups(nums)
            );
        }
    }

    public int usingBinarySearchWithDups(int[] nums) {

        if (nums.length == 1) {
            return nums[0] == 0 ? 0 : -1;
        }

        return getIndexByBinarySearchDups(nums, 0, nums.length);
    }

    public int getIndexByBinarySearchDups(int[] nums, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            if (nums[startIndex] == startIndex) {
                return startIndex;
            } else {
                return -1;
            }
        }

        int middle = (startIndex + endIndex) / 2;

        if (nums[middle] == middle) {
            return middle;
        }

        return Math.max(getIndexByRange(nums, startIndex, middle - 1), getIndexByRange(nums, middle + 1, endIndex));
    }

    public int usingBinarySearch(int[] nums) {

        if (nums.length == 1) {
            return nums[0] == 0 ? 0 : -1;
        }

        return getIndexByBinarySearch(nums, 0, nums.length);
    }

    public int getIndexByBinarySearch(int[] nums, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            if (nums[startIndex] == startIndex) {
                return startIndex;
            } else {
                return -1;
            }
        }

        int middle = (startIndex + endIndex) / 2;

        if (nums[middle] == middle) {
            return middle;
        } else if (middle > nums[middle]) {
            return getIndexByRange(nums, middle + 1, endIndex);
        } else {
            return getIndexByRange(nums, startIndex, middle - 1);
        }
    }

    public int usingDivideAndConquer(int[] nums) {
        return getIndexByRange(nums, 0, nums.length);
    }

    public int getIndexByRange(int[] nums, int startIndex, int endIndex) {

        if (startIndex < nums.length && startIndex == endIndex) {
            if (nums[startIndex] == startIndex) {
                return startIndex;
            } else {
                return -1;
            }
        }

        if (startIndex != endIndex) {
            int middle = (startIndex + endIndex) / 2;
            int left = getIndexByRange(nums, startIndex, middle);
            int right = getIndexByRange(nums, middle + 1, endIndex);

            if (left == -1 && right == -1) {
                return -1;
            } else if (left == -1 && right != -1) {
                return right;
            } else if (left != -1 && right == -1) {
                return left;
            } else {
                return Math.min(left, right);
            }
        }
        return -1;
    }

    public int usingRecursion(int[] nums) {
        return getMagicIndexByIndex(nums, 0);
    }

    public int getMagicIndexByIndex(int[] nums, int currIndex) {

        if (currIndex == nums.length) {
            return -1;
        }
        if (nums[currIndex] == currIndex) {
            return currIndex;
        }
        return getMagicIndexByIndex(nums, currIndex + 1);
    }

}
