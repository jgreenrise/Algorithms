package tree.problems;

import tree.bst.MyBinaryNode;

/**
 * Output
 */
public class SizeOfBinaryTree {

	public static void main(String[] args) {

		MyBinaryNode n4 = new MyBinaryNode(4);
		MyBinaryNode n8 = new MyBinaryNode(8);
		MyBinaryNode n5 = new MyBinaryNode(5);
		MyBinaryNode n7 = new MyBinaryNode(7, null, n4);
		MyBinaryNode n6 = new MyBinaryNode(6, n8, n7);
		MyBinaryNode n10 = new MyBinaryNode(10, n5, n6);

		System.out.println(size(n10));

	}

	public static int size(MyBinaryNode node) {
		if (node == null) {
			return 0;
		}

		/**
		 * Find size of left tree
		 */
		int left = size(node.left_node);

		/**
		 * Find size of right tree
		 */
		int right = size(node.right_node);

		return 1 + left + right;

	}
}
