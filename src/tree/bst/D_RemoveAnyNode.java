package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class D_RemoveAnyNode {

    static BinaryNode rootNode;
    private static int maxNodeValue;

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
        D_RemoveAnyNode binarySearchTree = new D_RemoveAnyNode();
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

        binarySearchTree.removeNode(19);
        binarySearchTree.printBST();

        binarySearchTree.removeNode(6);
        binarySearchTree.printBST();

        binarySearchTree.removeNode(11);
        binarySearchTree.printBST();

        binarySearchTree.removeNode(49);
        binarySearchTree.printBST();
    }

    private void removeNode(int i) {
        rootNode = removeNode(rootNode, i);
    }

    private BinaryNode removeNode(BinaryNode node, int value) {

        int nodeValue = Integer.parseInt(node.value.toString());

        if (nodeValue < value) {
            node.right_node = removeNode(node.right_node, value);
            return node;
        } else if (nodeValue > value) {
            node.left_node = removeNode(node.left_node, value);
            return node;
        } else {

            BinaryNode maxNode = findAndRemoveMaxNode(node);
            maxNode.value = maxNodeValue;

            return maxNode;
        }

    }

    private BinaryNode findAndRemoveMaxNode(BinaryNode node) {
        if (node.right_node == null) {
            node.left_node = removeMaxNode(node.left_node);
            return node;
        } else {
            node.right_node = removeMaxNode(node.right_node);
            return node;
        }
    }

    private BinaryNode removeMaxNode(BinaryNode node) {

        if(node.right_node != null) {
            node.right_node = removeMaxNode(node.right_node);
            return node;
        }
        maxNodeValue = Integer.parseInt(node.value.toString());
        return null;
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
