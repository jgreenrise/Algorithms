import java.util.Arrays;

public class a_0033_SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;

        if (n == 1)
            return nums[0] == target ? 0 : -1;
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);

        while (left <= right && right < n) {

            if (target == nums[left]) return left;
            if (target == nums[right]) return right;
            if (left == right) return -1;
            if (right + 1 == right) return -1;
            int mid = left + (right - left) / 2;    // 0 + 6/2: 3   4 + (2/2): 5    4
            if (nums[mid] == target) return mid;

            // 4 5 6 7* 0 1 2
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}
