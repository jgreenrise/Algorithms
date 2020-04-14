package tree.problems.isBalanced;

import tree.bst.MyBinaryNode;

/**
 * Time complexity: O(n)
 */
public class IsABalancedBinaryTreeUsingRecursion {

	public static void main(String[] args) {

		MyBinaryNode n7 = new MyBinaryNode(7);
		MyBinaryNode n8 = new MyBinaryNode(8);
		MyBinaryNode n4 = new MyBinaryNode(4, n7, n8);
		MyBinaryNode n6 = new MyBinaryNode(6);
		MyBinaryNode n5 = new MyBinaryNode(5);
		MyBinaryNode n2 = new MyBinaryNode(2, n5, n6);
		MyBinaryNode n1 = new MyBinaryNode(1, n2, n4);

		System.out.println(isBalancedBinaryTree(n1));

		MyBinaryNode n10 = new MyBinaryNode(10);
		MyBinaryNode n11 = new MyBinaryNode(11);
		n6.left_node = n10;
		n10.left_node = n11;

		System.out.println(isBalancedBinaryTree(n1));

		n10.left_node = null;

		System.out.println(isBalancedBinaryTree(n1));

	}

	private static boolean isBalancedBinaryTree(MyBinaryNode node) {

		int left = printInorder(node.left_node, 0);
		int right = printInorder(node.right_node, 0);
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

	private static int printInorder(MyBinaryNode node, int depth) {

		int left = 0, right = 0;

		/**
		 * For handling leaf nodes
		 */
		if (node.left_node == null && node.right_node == null) {
			return 0;
		}

		/**
		 * Prepare metadata for left node
		 */
		if (node.left_node != null) {
			left = 1 + printInorder(node.left_node, depth);
		}

		/**
		 * Prepare metadata for right node
		 */
		if (node.right_node != null) {
			right = 1 + printInorder(node.right_node, depth);
		}

		return Integer.max(left, right);

	}

}
