public class a_0033_SearchInRotatedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    // 4,5,6,7,0,1,2        t = 0, 0, 6
    public int search(int[] nums, int target, int left, int right) {

        int leftVal = nums[left]; // 4
        int rightVal = nums[right]; // 2

        if (leftVal == target) {
            return left;
        } else if (rightVal == target) {
            return right;
        } else if (left + 1 == right || left == right) {
            return -1;
        }

        int resp = search(nums, target, left, (left + right) / 2);
        if (resp == -1) {
            resp = search(nums, target, (left + right) / 2 + 1, right);
        }
        return resp;

    }
}
