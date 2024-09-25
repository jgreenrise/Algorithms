import tree.bst.TreeNode;

public class a_0337_HouseRobber_3 {
    public int rob(TreeNode node) {
        int[] resp = robWithWithout(node);
        return Math.max(resp[0], resp[1]);
    }

    public int[] robWithWithout(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        } else if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        } else if (node.left != null && node.right == null) {
            int[] left = robWithWithout(node.left);
            return new int[]{node.val + left[1], Integer.max(left[0], left[1])};
        } else if (node.right != null && node.left == null) {
            int[] right = robWithWithout(node.right);
            return new int[]{node.val + right[1], Integer.max(right[0], right[1])};
        } else {
            int[] left = robWithWithout(node.left);
            int[] right = robWithWithout(node.right);
            int val1 = node.val + left[1] + right[1];
            int val2 = Integer.max(
                    Integer.max(left[0] + Integer.max(right[0], right[1]), left[1] + Integer.max(right[0], right[1])),
                    Integer.max(right[0] + Integer.max(left[0], left[1]), right[1] + Integer.max(left[0], left[1]))
            );
            return new int[]{val1, val2};
        }

    }
}
