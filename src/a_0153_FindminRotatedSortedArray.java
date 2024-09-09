public class a_0153_FindminRotatedSortedArray {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.min(nums[0], nums[1]); // Cleaner syntax
        }
        return findMinByRange(nums, 0, n - 1);
    }

    public int findMinByRange(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2; // Fix mid calculation

            // If mid is lesser than previous element, the mid is the min
            /// 4 5 6 0 1 2 3
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // If mid is greater than the next element, the next element is the minimum
            // 4 5 6 7 1 2 3
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Move the search to the unsorted half
            if (nums[mid] > nums[end]) {
                // 4 5 6 7* 8 1 2 ---  7> 2
                start = mid + 1;
            } else {
                // 4 1 2 3* 4 5 6 ---  3 < 6
                end = mid - 1;
            }

            // Handle edge case when start equals end
            if (start == end) {
                return nums[start];
            }
        }
        return nums[0]; // If no rotation, return first element (sorted case)
    }

}
