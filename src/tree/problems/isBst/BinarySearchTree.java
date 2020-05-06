package tree.problems.isBst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import tree.bst.TreeNode;
import tree.bst.MyDuplicateItemException;

public class BinarySearchTree {

	protected static TreeNode rootNode;

	public BinarySearchTree() {
		rootNode = null;
	}

	/***************** INSERT ******************/

	/**
	 * Insert into the tree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @throws MyDuplicateItemException
	 *             if x is already present.
	 */
	public void insert(Comparable x) throws MyDuplicateItemException {
		rootNode = insert(x, rootNode);
	}

	protected TreeNode insert(Comparable x, TreeNode t) throws MyDuplicateItemException {
		if (t == null) {
			return new TreeNode(x);
		} else if (x.compareTo(t.value) > 0) {
			t.right = insert(x, t.right);
		} else if (x.compareTo(t.value) < 0) {
			t.left = insert(x, t.left);
		} else {
			throw new MyDuplicateItemException(x.toString());
		}
		return t;
	}

	private void isBST() {
		// TODO Auto-generated method stub
		isBST(rootNode);
	}

	/**
	 * This approach is not correct
	 * 
	 * @param node
	 */
	private void isBST(TreeNode node) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);

		while (!queue.isEmpty()) {

			TreeNode tmp = queue.poll();

			if (tmp.left != null && node.left.value.compareTo(tmp.value) < 0) {
				queue.add(node.left);
			} else if (node.right != null && node.right.value.compareTo(tmp.value) > 0) {
				queue.add(node.right);
			} else if (tmp.left != null && tmp.right != null) {
				System.out.println("Not a bst");
				break;
			}
		}

		System.out.println("Is a BST");

	}

	public void printBST() {

		System.out.println("Root node value: " + rootNode.value);

		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		currentLevel.add(rootNode);

		while (!currentLevel.isEmpty()) {

			System.out.print((currentLevel.peek()).value + " ");
			TreeNode node = currentLevel.poll();

			if (node.left != null)
				nextLevel.add(node.left);

			if (node.right != null)
				nextLevel.add(node.right);

			if (currentLevel.isEmpty()) {
				System.out.println();

				while (!nextLevel.isEmpty())
					currentLevel.add(nextLevel.poll());
			}
		}
	}

	/**
	 * Approach 1: Use inOrder path, to store the nodes in an array. Check if
	 * array is sorted.
	 */
	private static int index = 0;

	private static boolean printInorder(int lengthOfTree) {
		int[] values = printInorder(rootNode, new int[lengthOfTree]);
		System.out.println(Arrays.toString(values));

		// if(sorted(values)){
		// return true;
		// }else{
		// return false;
		// }

		return true;

	}

	private static int[] printInorder(TreeNode node, int[] array) {

		if (node != null) {
			printInorder(node.left, array);
			array[index++] = Integer.parseInt(node.value.toString());
			printInorder(node.right, array);
		}
		return array;

	}

	/**
	 * Approach 2: Use inOrder path, to check the values in Each node. Compare
	 * value of each node against the previous node. Avoid using array.
	 */
	private static Integer lastRecord = null;

	private static boolean printInorderAndKeepALog(int length) {
		return printInorderAndCheckForBST(rootNode);
	}

	private static boolean printInorderAndCheckForBST(TreeNode node) {

		if (node != null) {
			printInorderAndCheckForBST(node.left);

			if (lastRecord != null && lastRecord > Integer.parseInt(node.value.toString())) {
				return false;
			}

			lastRecord = Integer.parseInt(node.value.toString());
			printInorderAndCheckForBST(node.right);
		}

		return true;

	}

	public static void main(String args[]) throws MyDuplicateItemException {

		// Adding node to bst
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int[] values = { 20, 10, 30, 5, 15, 3, 7, 17 };

		for (int i = 0; i < values.length; i++) {
			binarySearchTree.insert(values[i]);
		}

		binarySearchTree.printBST();

		// Wrong approach
		System.out.println();
		binarySearchTree.isBST();

		// Approach 1: Using in-order traversal and array
		System.out.println();
		System.out.println("Is BST using array : " + printInorder(values.length));

		// Approach 2: Enhancement in approach 1: Using in-order traversal and
		// Integer object
		System.out.println();
		System.out.println("Is BST using array : " + printInorderAndKeepALog(values.length));

	}

}
