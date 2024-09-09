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
        } else if (node.left == null) {
            int[] resp = robWithWithout(node.right);
            return new int[]{node.val + resp[1], Math.max(resp[0], resp[1])};
        } else if (node.right == null) {
            int[] resp = robWithWithout(node.left);
            return new int[]{node.val + resp[1], Math.max(resp[0], resp[1])};
        } else {
            int[] left = robWithWithout(node.left);
            int[] right = robWithWithout(node.right);
            return new int[]{node.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
        }
    }
}
