import tree.bst.TreeNode;

public class a_0108_convertSortedArrayIntoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayByRange(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayByRange(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length || left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(nums[left]);
        } else {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayByRange(nums, left, mid - 1);
            node.right = sortedArrayByRange(nums, mid + 1, right);
            return node;
        }
    }

}

