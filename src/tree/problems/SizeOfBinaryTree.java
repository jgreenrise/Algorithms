package tree.problems;

import tree.bst.TreeNode;

/**
 * Output
 */
public class SizeOfBinaryTree {

	public static void main(String[] args) {

		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7, null, n4);
		TreeNode n6 = new TreeNode(6, n8, n7);
		TreeNode n10 = new TreeNode(10, n5, n6);

		System.out.println(size(n10));

	}

	public static int size(TreeNode node) {
		if (node == null) {
			return 0;
		}

		/**
		 * Find size of left tree
		 */
		int left = size(node.left);

		/**
		 * Find size of right tree
		 */
		int right = size(node.right);

		return 1 + left + right;

	}
}
