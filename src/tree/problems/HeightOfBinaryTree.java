package tree.problems;

import tree.bst.BinaryNode;

/**
 * Output
 */
public class HeightOfBinaryTree {

	public static void main(String[] args) {

		BinaryNode n4 = new BinaryNode(4);
		BinaryNode n8 = new BinaryNode(8);
		BinaryNode n5 = new BinaryNode(5);
		BinaryNode n7 = new BinaryNode(7, null, n4);
		BinaryNode n6 = new BinaryNode(6, n8, n7);
		BinaryNode n10 = new BinaryNode(10, n5, n6);
		System.out.println(size(n10));
		
		BinaryNode n11 = new BinaryNode(11);
		BinaryNode n12 = new BinaryNode(12);
		n7 = new BinaryNode(7, n11, n12);
		n8 = new BinaryNode(8);
		n4 = new BinaryNode(4, n7, n8);
		BinaryNode n9 = new BinaryNode(9);
		n10 = new BinaryNode(10);
		n5 = new BinaryNode(5,  n9,  n10);
		n6 = new BinaryNode(6);
		BinaryNode n2 = new BinaryNode(2, n5, n6);
		BinaryNode n1 = new BinaryNode(1, n2, n4);
		
		System.out.println(height(n1));

	}
	
	public static int height(BinaryNode node) {
		if (node == null) {
			return 0;
		}

		int left = height(node.left_node);
		int right = height(node.right_node);

		return 1 + Integer.max(left,right);

	}

}
