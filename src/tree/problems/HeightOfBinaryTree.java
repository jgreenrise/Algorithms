package tree.problems;

import tree.bst.TreeNode;

/**
 * Output
 */
public class HeightOfBinaryTree {

	public static void main(String[] args) {

		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7, null, n4);
		TreeNode n6 = new TreeNode(6, n8, n7);
		TreeNode n10 = new TreeNode(10, n5, n6);
		System.out.println(height(n10));

		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		n7 = new TreeNode(7, n11, n12);
		n8 = new TreeNode(8);
		n4 = new TreeNode(4, n7, n8);
		TreeNode n9 = new TreeNode(9);
		n10 = new TreeNode(10);
		n5 = new TreeNode(5, n9, n10);
		n6 = new TreeNode(6);
		TreeNode n2 = new TreeNode(2, n5, n6);
		TreeNode n1 = new TreeNode(1, n2, n4);

		System.out.println(height(n1));

	}

	public static int height(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = height(node.left);
		int right = height(node.right);

		return 1 + Integer.max(left, right);

	}

}
