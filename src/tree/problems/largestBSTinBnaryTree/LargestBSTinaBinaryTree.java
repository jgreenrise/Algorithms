package tree.problems.largestBSTinBnaryTree;

import tree.bst.BinaryNode;

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
		BinaryNode n15 = new BinaryNode(15);
		BinaryNode n10 = new BinaryNode(10);
		BinaryNode n25 = new BinaryNode(25);
		BinaryNode n19 = new BinaryNode(19, null, n15);
		BinaryNode n20 = new BinaryNode(20, n10, n25);
		BinaryNode n18 = new BinaryNode(18, n19, n20);

		/**
		 * Right tree
		 */
		BinaryNode n22 = new BinaryNode(22);
		BinaryNode n40 = new BinaryNode(40);
		BinaryNode n55 = new BinaryNode(55);
		BinaryNode n70 = new BinaryNode(70);
		BinaryNode n21 = new BinaryNode(21, null, n22);
		BinaryNode n35 = new BinaryNode(35, n21, n40);
		BinaryNode n60 = new BinaryNode(60, n55, n70);
		BinaryNode n50 = new BinaryNode(50, n35, n60);

		/**
		 * Root node
		 */
		BinaryNode n24 = new BinaryNode(24, n18, n50);

		printPostOrderTraversal(n24);

	}

	private static void printPostOrderTraversal(BinaryNode node) {

		NodeMetadata left = printInorder(node.left_node, false, 0, 0, 0);
		NodeMetadata right = printInorder(node.right_node, false, 0, 0, 0);
		System.out.println(node.element);
		System.out.println("Size of largest BST: " + Integer.max(left.size, right.size));

	}

	private static NodeMetadata printInorder(BinaryNode node, boolean isBST, int size, int min, int max) {

		NodeMetadata metadata_left = null;
		NodeMetadata metadata_right = null;

		/**
		 * For handling leaf nodes
		 */
		if (node.left_node == null && node.right_node == null) {
			System.out.println("Node investigated " + node.element.toString());
			return new NodeMetadata(node, true, 1, Integer.parseInt(node.element.toString()), Integer.parseInt(node.element.toString()));
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
			if (!metadata_right.isBST || node.element.compareTo(node.right_node.element) > 0) {
				return new NodeMetadata(node, false, metadata_right.size, 0, 0);
			} else {
				return new NodeMetadata(node, true, metadata_right.size + 1, Integer.parseInt(node.element.toString()),
						Integer.parseInt(metadata_right.node.element.toString()));
			}

		/**
		 * For node with left child
		 */
		if (metadata_left != null && metadata_right == null)
			if (!metadata_left.isBST || node.element.compareTo(node.left_node.element) < 0) {
				return new NodeMetadata(node, false, metadata_left.size, 0, 0);
			} else {
				return new NodeMetadata(node, true, metadata_left.size + 1, Integer.parseInt(node.element.toString()),
						Integer.parseInt(node.element.toString()));
			}

		/**
		 * For node with left and right child
		 */
		if (metadata_right.isBST && metadata_left.isBST) {

			if (node.element.compareTo(node.left_node.element) > 0 && node.element.compareTo(node.right_node.element) < 0) {
				return new NodeMetadata(node, true, metadata_left.size + metadata_right.size + 1, Integer.min(
						Integer.parseInt(node.left_node.element.toString()), Integer.parseInt(node.right_node.element.toString())), Integer.max(
						Integer.parseInt(node.left_node.element.toString()), Integer.parseInt(node.right_node.element.toString())));
			} else {
				return new NodeMetadata(node, false, Integer.max(metadata_left.size, metadata_right.size), 0, 0);
			}

		} else {
			return new NodeMetadata(node, false, Integer.max(metadata_left.size, metadata_right.size), 0, 0);
		}

	}

}
