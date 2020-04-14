package tree.problems.largestBSTinBnaryTree;

import tree.bst.MyBinaryNode;

/**
 * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the given Binary
 * Tree.
 */
public class LargestBSTinaBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * Left tree
		 */
		MyBinaryNode n15 = new MyBinaryNode(15);
		MyBinaryNode n10 = new MyBinaryNode(10);
		MyBinaryNode n25 = new MyBinaryNode(25);
		MyBinaryNode n19 = new MyBinaryNode(19, null, n15);
		MyBinaryNode n20 = new MyBinaryNode(20, n10, n25);
		MyBinaryNode n18 = new MyBinaryNode(18, n19, n20);

		/**
		 * Right tree
		 */
		MyBinaryNode n22 = new MyBinaryNode(22);
		MyBinaryNode n40 = new MyBinaryNode(40);
		MyBinaryNode n55 = new MyBinaryNode(55);
		MyBinaryNode n70 = new MyBinaryNode(70);
		MyBinaryNode n21 = new MyBinaryNode(21, null, n22);
		MyBinaryNode n35 = new MyBinaryNode(35, n21, n40);
		MyBinaryNode n60 = new MyBinaryNode(60, n55, n70);
		MyBinaryNode n50 = new MyBinaryNode(50, n35, n60);

		/**
		 * Root node
		 */
		MyBinaryNode n24 = new MyBinaryNode(24, n18, n50);

		printPostOrderTraversal(n24);

	}

	private static void printPostOrderTraversal(MyBinaryNode node) {

		NodeMetadata left = printInorder(node.left_node, false, 0, 0, 0);
		NodeMetadata right = printInorder(node.right_node, false, 0, 0, 0);
		System.out.println(node.value);
		System.out.println("Size of largest BST: " + Integer.max(left.size, right.size));

	}

	private static NodeMetadata printInorder(MyBinaryNode node, boolean isBST, int size, int min, int max) {

		NodeMetadata metadata_left = null;
		NodeMetadata metadata_right = null;

		/**
		 * For handling leaf nodes
		 */
		if (node.left_node == null && node.right_node == null) {
			System.out.println("Node investigated " + node.value.toString());
			return new NodeMetadata(node, true, 1, Integer.parseInt(node.value.toString()), Integer.parseInt(node.value.toString()));
		}

		/**
		 * Prepare metadata for left node
		 */
		if (node.left_node != null) {
			metadata_left = printInorder(node.left_node, isBST, size, min, max);
		}

		/**
		 * Prepare metadata for right node
		 */
		if (node.right_node != null) {
			metadata_right = printInorder(node.right_node, isBST, size, min, max);
		}

		/**
		 * For node with only left child
		 */
		if (metadata_left == null && metadata_right != null)
			if (!metadata_right.isBST || node.value.compareTo(node.right_node.value) > 0) {
				return new NodeMetadata(node, false, metadata_right.size, 0, 0);
			} else {
				return new NodeMetadata(node, true, metadata_right.size + 1, Integer.parseInt(node.value.toString()),
						Integer.parseInt(metadata_right.node.value.toString()));
			}

		/**
		 * For node with left child
		 */
		if (metadata_left != null && metadata_right == null)
			if (!metadata_left.isBST || node.value.compareTo(node.left_node.value) < 0) {
				return new NodeMetadata(node, false, metadata_left.size, 0, 0);
			} else {
				return new NodeMetadata(node, true, metadata_left.size + 1, Integer.parseInt(node.value.toString()),
						Integer.parseInt(node.value.toString()));
			}

		/**
		 * For node with left and right child
		 */
		if (metadata_right.isBST && metadata_left.isBST) {

			if (node.value.compareTo(node.left_node.value) > 0 && node.value.compareTo(node.right_node.value) < 0) {
				return new NodeMetadata(node, true, metadata_left.size + metadata_right.size + 1, Integer.min(
						Integer.parseInt(node.left_node.value.toString()), Integer.parseInt(node.right_node.value.toString())), Integer.max(
						Integer.parseInt(node.left_node.value.toString()), Integer.parseInt(node.right_node.value.toString())));
			} else {
				return new NodeMetadata(node, false, Integer.max(metadata_left.size, metadata_right.size), 0, 0);
			}

		} else {
			return new NodeMetadata(node, false, Integer.max(metadata_left.size, metadata_right.size), 0, 0);
		}

	}

}
