public class a_0337_HouseRobber_3 {
    public int rob(TreeNode root) {
        int[] nums = robWithWithout(root);
        return nums[0] > nums[1] ? nums[0] : nums[1];
    }

    public int[] robWithWithout(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        } else if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        } else {
            int[] left = robWithWithout(node.left);
            int[] right = robWithWithout(node.right);

            // If we rob this node, we cannot rob its children
            int robCurrent = node.val + left[1] + right[1];

            // If we do not rob this node, we can choose to rob or not rob its children
            int skipCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{robCurrent, skipCurrent};
        }

    }
}
