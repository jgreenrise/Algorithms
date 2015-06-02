package tree.problems.isBalanced;

import tree.bst.BinaryNode;

/**
 * Time complexity: O(n2)
 */
public class IsABalancedBinaryTreeUsingHeight {

	public static void main(String[] args) {

		BinaryNode n7 = new BinaryNode(7);
		BinaryNode n8 = new BinaryNode(8);
		BinaryNode n4 = new BinaryNode(4, n7, n8);
		BinaryNode n6 = new BinaryNode(6);
		BinaryNode n5 = new BinaryNode(5);
		BinaryNode n2 = new BinaryNode(2, n5, n6);
		BinaryNode n1 = new BinaryNode(1, n2, n4);

		System.out.println(isBalancedBinaryTree(n1));
		
		BinaryNode n10 = new BinaryNode(10);
		BinaryNode n11 = new BinaryNode(11);
		n6.left_node = n10;
		n10.left_node = n11;
		
		System.out.println(isBalancedBinaryTree(n1));
		
		n10.left_node = null;
		
		System.out.println(isBalancedBinaryTree(n1));

	}

	private static boolean isBalancedBinaryTree(BinaryNode node){
		
		int left = height(node.left_node);
		int right = height(node.right_node);

		if(left > right){
			if((left - right) > 1)
				return false;
			else
				return true;
		}else{
			if((right - left) > 1)
				return false;
			else
				return true;
		}

	}

	private static int height(BinaryNode node){
		
		if(node == null){
			return 0;
		}

		int left = height(node.left_node);
		int right = height(node.right_node);

		return 1 + Integer.max(left, right);

	}

}
