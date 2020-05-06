package tree.problems.isBalanced;

import tree.bst.TreeNode;

/**
 * Time complexity: O(n)
 */
public class IsABalancedBinaryTreeUsingRecursion {

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

		int left = printInorder(node.left, 0);
		int right = printInorder(node.right, 0);
		//System.out.println(node.element);

		if (left > right) {
			if ((left - right) > 1)
				return false;
			else
				return true;
		} else {
			if ((right - left) > 1)
				return false;
			else
				return true;
		}

	}

	private static int printInorder(TreeNode node, int depth) {

		int left = 0, right = 0;

		/**
		 * For handling leaf nodes
		 */
		if (node.left == null && node.right == null) {
			return 0;
		}

		/**
		 * Prepare metadata for left node
		 */
		if (node.left != null) {
			left = 1 + printInorder(node.left, depth);
		}

		/**
		 * Prepare metadata for right node
		 */
		if (node.right != null) {
			right = 1 + printInorder(node.right, depth);
		}

		return Integer.max(left, right);

	}

}
