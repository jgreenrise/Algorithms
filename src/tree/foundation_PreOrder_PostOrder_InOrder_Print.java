package tree;

import tree.bst.MyDuplicateItemException;
import tree.bst.TreeNode;

public class foundation_PreOrder_PostOrder_InOrder_Print {

    static TreeNode rootNode;

    public static void main(String args[]) throws MyDuplicateItemException {

        // Adding node to bst
        foundation_PreOrder_PostOrder_InOrder_Print binarySearchTree = new foundation_PreOrder_PostOrder_InOrder_Print();
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
        System.out.println("Printing In order: ");

        binarySearchTree.printPreOrder(rootNode);
        binarySearchTree.printPostOrder(rootNode);
        binarySearchTree.printInOrder(rootNode);
    }

    public void insert(int value) throws MyDuplicateItemException {
        if (rootNode == null) {
            rootNode = new TreeNode(value);
        } else {
            rootNode = insert(value, rootNode);
        }
    }

    public TreeNode insert(int value, TreeNode node) {

        if (node == null) {
            return new TreeNode(value);
        } else {
            if (node.value.compareTo(value) > 0) {
                node.left = insert(value, node.left);
                return node;
            } else {
                node.right = insert(value, node.right);
                return node;
            }
        }
    }

    private void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(TreeNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    private void printInOrder(TreeNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        System.out.println(node.value);
        printPostOrder(node.right);
    }

}
