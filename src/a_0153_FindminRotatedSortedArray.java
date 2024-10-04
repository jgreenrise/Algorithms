public class a_0153_FindminRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMinByRange(nums, 0, nums.length - 1);
    }

    public int findMinByRange(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        } else if (right == left + 1) {
            if (nums[left] < nums[right]) {
                return nums[left];
            } else {
                return nums[right];
            }
        }

        int mid = left + (right - left) / 2;
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid] && mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
            // 5, 6, 0*, 1, 2
            return nums[mid];
        } else if (nums[mid + 1] > nums[mid] && nums[nums.length - 1] > nums[mid]) {
            // 1, 2, 3*, 4, 5, 6
            // 7, 0, 3*, 4, 5, 6
            return findMinByRange(nums, left, mid - 1);
        } else if (nums[mid + 1] > nums[mid] && nums[nums.length - 1] < nums[mid]) {
            // 1, 2, 3*, 4, 5, 0
            return findMinByRange(nums, mid + 1, right);
        } else if (nums[mid + 1] < nums[mid] && nums[nums.length - 1] < nums[mid]) {
            // 4, 5, 6*, 0, 1, 2
            return findMinByRange(nums, mid + 1, right);
        } else if (nums[mid + 1] < nums[mid] && nums[nums.length - 1] > nums[mid]) {
            // 7, 8, 3*, 1, 2, 6
            return findMinByRange(nums, left, mid - 1);
        }

        return -1;

    }

}
