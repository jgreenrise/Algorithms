package tree.bst;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.Queue;

public class F_IsBST {

    static BinaryNode rootNode;

    public void insert(int value) throws DuplicateItemException {
        if (rootNode == null) {
            rootNode = new BinaryNode(value);
        } else {
            rootNode = insert(value, rootNode);
        }
    }

    public BinaryNode insert(int value, BinaryNode node) {

        if (node == null) {
            return new BinaryNode(value);
        } else {
            if (node.value.compareTo(value) > 0) {
                node.left_node = insert(value, node.left_node);
                return node;
            } else {
                node.right_node = insert(value, node.right_node);
                return node;
            }
        }
    }


    public static void main(String args[]) throws DuplicateItemException {

        // Adding node to bst
        F_IsBST binarySearchTree = new F_IsBST();
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

        System.out.println("Is BST: " + isBinarySearchTree());
    }

    private static boolean isBinarySearchTree() {
        return isBinarySearchTree(rootNode);
    }

    private static boolean isBinarySearchTree(BinaryNode node) {

        if (node.right_node == null && node.left_node == null) {
            return true;
        }

        if (node.left_node == null) {
            // Node < Node.right
            if (node.value.compareTo(node.right_node.value) < 0) {
                return isBinarySearchTree(node.right_node);
            }
            return false;
        }

        if (node.right_node == null) {
            // Node > Node.left
            if (node.value.compareTo(node.left_node.value) > 0) {
                return isBinarySearchTree(node.left_node);
            }
            return false;
        }

        // If left and right both are available
        // Node > node.left_node && Node < node.right
        if (node.right_node.value.compareTo(node.value) > 0 && node.left_node.value.compareTo(node.value) < 0)
            return isBinarySearchTree(node.left_node) && isBinarySearchTree(node.right_node);
        return false;
    }

    public void printBST() {

        System.out.println("Root node value: " + rootNode.value);

        Queue<BinaryNode> currentLevel = new LinkedList<BinaryNode>();
        Queue<BinaryNode> nextLevel = new LinkedList<BinaryNode>();
        currentLevel.add(rootNode);

        while (!currentLevel.isEmpty()) {

            System.out.print((currentLevel.peek()).value + " ");
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

}
