package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	protected BinaryNode rootNode;

	public BinarySearchTree() {
		rootNode = null;
	}

	/***************** INSERT ******************/

	/**
	 * Insert into the tree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @throws DuplicateItemException
	 *             if x is already present.
	 */
	public void insert(Comparable x) throws DuplicateItemException {
		rootNode = insert(x, rootNode);
	}

	protected BinaryNode insert(Comparable x, BinaryNode t)
			throws DuplicateItemException {
		if (t == null) {
			return new BinaryNode(x);
		} else if (x.compareTo(t.element) > 0) {
			t.right_node = insert(x, t.right_node);
		} else if (x.compareTo(t.element) < 0) {
			t.left_node = insert(x, t.left_node);
		} else {
			throw new DuplicateItemException(x.toString());
		}
		return t;
	}

	/***************** FIND ******************/

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @param rootNode
	 * @return smallest item or null if empty.
	 */
	public BinaryNode findMin() {
		return findMin(rootNode);
	}

	private BinaryNode findMin(BinaryNode rootNode) {
		if (rootNode == null) {
			return null;
		} else {

			while (rootNode.left_node != null) {
				rootNode = rootNode.left_node;
			}
			return rootNode;
		}
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @param rootNode
	 * @return smallest item or null if empty.
	 */
	public BinaryNode findMax() {
		return findMax(rootNode);
	}

	private BinaryNode findMax(BinaryNode rootNode) {
		if (rootNode == null) {
			return null;
		} else {

			while (rootNode.right_node != null) {
				rootNode = rootNode.right_node;
			}
			return rootNode;
		}
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return the matching item or null if not found.
	 */
	public Comparable find(Comparable item) {
		// TODO Auto-generated method stub
		return find(item, rootNode);
	}

	private Comparable find(Comparable item, BinaryNode rootNode) {

		while (rootNode != null) {
			if (rootNode.element.compareTo(item) > 0)
				rootNode = rootNode.left_node;
			else if (rootNode.element.compareTo(item) < 0)
				rootNode = rootNode.right_node;
			else
				return rootNode.element;
		}
		return null; // Not found
	}

	/**
	 * Remove minimum item from the tree.
	 * 
	 * @throws ItemNotFoundException
	 *             if tree is empty.
	 */
	public void removeMin() {
		rootNode = removeMin(rootNode);
	}

	private BinaryNode removeMin(BinaryNode rootNode) {

		if (rootNode == null)
			return null;
		else if (rootNode.left_node != null) {
			rootNode.left_node = removeMin(rootNode.left_node);
			return rootNode;
		} else {
			return rootNode.right_node;
		}

	}

	/**
	 * Remove Maximum item from the tree.
	 * 
	 * @throws ItemNotFoundException
	 *             if tree is empty.
	 */
	public void removeMax() {
		rootNode = removeMax(rootNode);
	}

	private BinaryNode removeMax(BinaryNode rootNode) {

		if (rootNode == null)
			return null;
		else if (rootNode.right_node != null) {
			rootNode.right_node = removeMax(rootNode.right_node);
			return rootNode;
		} else {
			return rootNode.left_node;
		}
	}

	/**
	 * Remove from the tree..
	 * 
	 * @param x
	 *            the item to remove.
	 * @throws ItemNotFoundException
	 *             if x is not found.
	 */
	public void remove(Comparable x) {
		rootNode = remove(x, rootNode);
	}

	private BinaryNode remove(Comparable node_to_be_removed, BinaryNode node) {

		if (node_to_be_removed.compareTo(node.element) > 0) {
			node.right_node = remove(node_to_be_removed, node.right_node);
		} else if (node_to_be_removed.compareTo(node.element) < 0) {
			node.left_node = remove(node_to_be_removed, node.left_node);
		} else if (node_to_be_removed.compareTo(node.element) == 0) {

			if (node.left_node == null && node.right_node == null) {
				// Deleting leaf node
				return null;
			} else if (node.left_node != null && node.right_node == null) {
				// Deleting node with one child
				BinaryNode tmp = node;
				tmp = null;
				return node.left_node;
			} else if (node.right_node != null && node.left_node == null) {
				// Deleting node with one child
				BinaryNode tmp = node;
				tmp = null;
				return node.right_node;
			} else if (node.right_node != null && node.left_node != null) {
				// Deleting node with 2 child
				BinaryNode tmp = removeAndReturnMinNodeFromBst(node.right_node);
				removeMin(node.right_node);
				node.element = tmp.element;
				return node;

			}

		} else {
			System.out.println("Node to be removed is not found in bst.");
			return null;
		}
		return node;

	}

	private BinaryNode removeAndReturnMinNodeFromBst(BinaryNode node) {

		while (node.left_node != null) {
			node = node.left_node;
		}

		BinaryNode tmp = node;
		node = null;
		return tmp;
	}

	private void isBST() {
		// TODO Auto-generated method stub
		isBST(rootNode);
	}

	private void isBST(BinaryNode node) {

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(node);

		while (!queue.isEmpty()) {

			BinaryNode tmp = queue.poll();

			if (tmp.left_node != null
					&& node.left_node.element.compareTo(tmp.element) < 0) {
				queue.add(node.left_node);
			} else if (node.right_node != null
					&& node.right_node.element.compareTo(tmp.element) > 0) {
				queue.add(node.right_node);
			} else if(tmp.left_node != null && tmp.right_node != null) {
				System.out.println("Not a bst");
				break;
			}
		}
		
		System.out.println("Is a BST");

	}

	public void printBST() {

		System.out.println("Root node value: " + rootNode.element);

		Queue<BinaryNode> currentLevel = new LinkedList<BinaryNode>();
		Queue<BinaryNode> nextLevel = new LinkedList<BinaryNode>();
		currentLevel.add(rootNode);

		while (!currentLevel.isEmpty()) {

			System.out.print((currentLevel.peek()).element + " ");
			BinaryNode node = currentLevel.poll();

			if (node.left_node != null)
				nextLevel.add(node.left_node);

			if (node.right_node != null)
				nextLevel.add(node.right_node);

			if (currentLevel.isEmpty()) {
				System.out.println();

				while (!nextLevel.isEmpty())
					currentLevel.add(nextLevel.poll());
			}
		}
	}

	public static void main(String args[]) throws DuplicateItemException {

		// Adding node to bst
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(11);
		binarySearchTree.insert(6);
		binarySearchTree.insert(8);
		binarySearchTree.insert(19);
		binarySearchTree.insert(4);
		binarySearchTree.insert(10);
		binarySearchTree.insert(5);
		binarySearchTree.insert(17);
		binarySearchTree.insert(43);
		binarySearchTree.insert(49);
		binarySearchTree.insert(31);

		// Print BST
		binarySearchTree.printBST();

		// Print minimum value
		System.out.println("\nMinimum value: "
				+ (binarySearchTree.findMin()).element);

		// Print max value
		System.out.println("\nMaximum value: "
				+ (binarySearchTree.findMax()).element);

		// Find item in a tree
		System.out.println("\n Does 10 exists: " + (binarySearchTree.find(10)));
		System.out.println("\n Does 17 exists: " + (binarySearchTree.find(17)));
		System.out.println("\n Does 50 exists: " + (binarySearchTree.find(50)));

		// Remove min
		binarySearchTree.removeMin();

		// Print BST
		binarySearchTree.printBST();

		// Remove min
		binarySearchTree.removeMax();

		// Print BST
		binarySearchTree.printBST();

		binarySearchTree.removeMax();

		// Print BST
		binarySearchTree.printBST();

		// remove leaf Node
		binarySearchTree.remove(10);
		binarySearchTree.printBST();

		// remove leaf Node
		binarySearchTree.remove(31);
		binarySearchTree.printBST();

		// remove Node with 1 child
		binarySearchTree.remove(19);
		binarySearchTree.printBST();

		binarySearchTree.insert(19);
		binarySearchTree.insert(31);
		binarySearchTree.insert(10);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(13);
		binarySearchTree.printBST();

		// Remove tree with 2 child
		binarySearchTree.remove(11);
		binarySearchTree.printBST();

		binarySearchTree.isBST();
	}

}
