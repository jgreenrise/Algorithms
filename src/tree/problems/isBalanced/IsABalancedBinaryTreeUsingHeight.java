package tree.problems.isBalanced;

import tree.bst.TreeNode;

/**
 * Time complexity: O(n2)
 */
public class IsABalancedBinaryTreeUsingHeight {

    public static void main(String[] args) {

        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4, n7, n8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n5, n6);
        TreeNode n1 = new TreeNode(1, n2, n4);

        System.out.println(isBalancedBinaryTree(n1));

        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        n6.left = n10;
        n10.left = n11;

        System.out.println(isBalancedBinaryTree(n1));

        n10.left = null;

        System.out.println(isBalancedBinaryTree(n1));

    }

    private static boolean isBalancedBinaryTree(TreeNode node) {

        int left = height(node.left);
        int right = height(node.right);

        if (Math.abs(left - right) > 1)
            return false;
        return true;

    }

    private static int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return 1 + Math.max(left, right);

    }

}
