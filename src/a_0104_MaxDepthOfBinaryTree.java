
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class a_0104_MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {

        if(node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if(left == 0 && right == 0) return 1;
        if(left == 0 && right != 0) return 1 + right;
        if(right == 0 && left != 0) return 1 + left;
        return 1 + Math.max(left, right);


    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
