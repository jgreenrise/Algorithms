package tree.problems;

import tree.bst.MyBinaryNode;

/**
 * Output
 */
public class HeightOfBinaryTree {

	public static void main(String[] args) {

		MyBinaryNode n4 = new MyBinaryNode(4);
		MyBinaryNode n8 = new MyBinaryNode(8);
		MyBinaryNode n5 = new MyBinaryNode(5);
		MyBinaryNode n7 = new MyBinaryNode(7, null, n4);
		MyBinaryNode n6 = new MyBinaryNode(6, n8, n7);
		MyBinaryNode n10 = new MyBinaryNode(10, n5, n6);
		System.out.println(height(n10));

		MyBinaryNode n11 = new MyBinaryNode(11);
		MyBinaryNode n12 = new MyBinaryNode(12);
		n7 = new MyBinaryNode(7, n11, n12);
		n8 = new MyBinaryNode(8);
		n4 = new MyBinaryNode(4, n7, n8);
		MyBinaryNode n9 = new MyBinaryNode(9);
		n10 = new MyBinaryNode(10);
		n5 = new MyBinaryNode(5, n9, n10);
		n6 = new MyBinaryNode(6);
		MyBinaryNode n2 = new MyBinaryNode(2, n5, n6);
		MyBinaryNode n1 = new MyBinaryNode(1, n2, n4);

		System.out.println(height(n1));

	}

	public static int height(MyBinaryNode node) {
		if (node == null) {
			return 0;
		}

		int left = height(node.left_node);
		int right = height(node.right_node);

		return 1 + Integer.max(left, right);

	}

}
