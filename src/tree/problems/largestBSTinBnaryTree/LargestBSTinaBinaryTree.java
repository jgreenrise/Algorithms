package tree.problems.largestBSTinBnaryTree;

import tree.bst.TreeNode;

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
		TreeNode n15 = new TreeNode(15);
		TreeNode n10 = new TreeNode(10);
		TreeNode n25 = new TreeNode(25);
		TreeNode n19 = new TreeNode(19, null, n15);
		TreeNode n20 = new TreeNode(20, n10, n25);
		TreeNode n18 = new TreeNode(18, n19, n20);

		/**
		 * Right tree
		 */
		TreeNode n22 = new TreeNode(22);
		TreeNode n40 = new TreeNode(40);
		TreeNode n55 = new TreeNode(55);
		TreeNode n70 = new TreeNode(70);
		TreeNode n21 = new TreeNode(21, null, n22);
		TreeNode n35 = new TreeNode(35, n21, n40);
		TreeNode n60 = new TreeNode(60, n55, n70);
		TreeNode n50 = new TreeNode(50, n35, n60);

		/**
		 * Root node
		 */
		TreeNode n24 = new TreeNode(24, n18, n50);

		printPostOrderTraversal(n24);

	}

	private static void printPostOrderTraversal(TreeNode node) {

		NodeMetadata left = printInorder(node.left, false, 0, 0, 0);
		NodeMetadata right = printInorder(node.right, false, 0, 0, 0);
		System.out.println(node.value);
		System.out.println("Size of largest BST: " + Integer.max(left.size, right.size));

	}

	private static NodeMetadata printInorder(TreeNode node, boolean isBST, int size, int min, int max) {

		NodeMetadata metadata_left = null;
		NodeMetadata metadata_right = null;

		/**
		 * For handling leaf nodes
		 */
		if (node.left == null && node.right == null) {
			System.out.println("Node investigated " + node.value.toString());
			return new NodeMetadata(node, true, 1, Integer.parseInt(node.value.toString()), Integer.parseInt(node.value.toString()));
		}

		/**
		 * Prepare metadata for left node
		 */
		if (node.left != null) {
			metadata_left = printInorder(node.left, isBST, size, min, max);
		}

		/**
		 * Prepare metadata for right node
		 */
		if (node.right != null) {
			metadata_right = printInorder(node.right, isBST, size, min, max);
		}

		/**
		 * For node with only left child
		 */
		if (metadata_left == null && metadata_right != null)
			if (!metadata_right.isBST || node.value.compareTo(node.right.value) > 0) {
				return new NodeMetadata(node, false, metadata_right.size, 0, 0);
			} else {
				return new NodeMetadata(node, true, metadata_right.size + 1, Integer.parseInt(node.value.toString()),
						Integer.parseInt(metadata_right.node.value.toString()));
			}

		/**
		 * For node with left child
		 */
		if (metadata_left != null && metadata_right == null)
			if (!metadata_left.isBST || node.value.compareTo(node.left.value) < 0) {
				return new NodeMetadata(node, false, metadata_left.size, 0, 0);
			} else {
				return new NodeMetadata(node, true, metadata_left.size + 1, Integer.parseInt(node.value.toString()),
						Integer.parseInt(node.value.toString()));
			}

		/**
		 * For node with left and right child
		 */
		if (metadata_right.isBST && metadata_left.isBST) {

			if (node.value.compareTo(node.left.value) > 0 && node.value.compareTo(node.right.value) < 0) {
				return new NodeMetadata(node, true, metadata_left.size + metadata_right.size + 1, Integer.min(
						Integer.parseInt(node.left.value.toString()), Integer.parseInt(node.right.value.toString())), Integer.max(
						Integer.parseInt(node.left.value.toString()), Integer.parseInt(node.right.value.toString())));
			} else {
				return new NodeMetadata(node, false, Integer.max(metadata_left.size, metadata_right.size), 0, 0);
			}

		} else {
			return new NodeMetadata(node, false, Integer.max(metadata_left.size, metadata_right.size), 0, 0);
		}

	}

}
