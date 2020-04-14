package tree.problems.isBalanced;

import tree.bst.MyBinaryNode;

/**
 * Time complexity: O(n2)
 */
public class IsABalancedBinaryTreeUsingHeight {

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

        int left = height(node.left_node);
        int right = height(node.right_node);

        if (Math.abs(left - right) > 1)
            return false;
        return true;

    }

    private static int height(MyBinaryNode node) {

        if (node == null) {
            return 0;
        }

        int left = height(node.left_node);
        int right = height(node.right_node);

        return 1 + Math.max(left, right);

    }

}
