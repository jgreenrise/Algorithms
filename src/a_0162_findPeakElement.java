public class a_0162_findPeakElement {

    /**
     * If the middle element is smaller than its right neighbor,
     * the algorithm searches the right half of the array;
     * otherwise, it searches the left half.
     * <p>
     * https://www.youtube.com/watch?v=VFC1oxkn5-E&t=200s
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        return findPeakElementByRange(nums, 1, n - 2);
    }

    public int findPeakElementByRange(int[] nums, int left, int right) {

        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (nums[mid] < nums[mid + 1]) {
            return findPeakElementByRange(nums, mid + 1, right);
        } else {
            return findPeakElementByRange(nums, left, mid - 1);
        }

    }

}
