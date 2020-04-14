package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class D_RemoveAnyNode {

    static MyBinaryNode rootNode;
    private static int maxNodeValue;

    public void insert(int value) throws MyDuplicateItemException {
        if (rootNode == null) {
            rootNode = new MyBinaryNode(value);
        } else {
            rootNode = insert(value, rootNode);
        }
    }

    public MyBinaryNode insert(int value, MyBinaryNode node) {

        if (node == null) {
            return new MyBinaryNode(value);
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


    public static void main(String args[]) throws MyDuplicateItemException {

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

    private MyBinaryNode removeNode(MyBinaryNode node, int value) {

        int nodeValue = Integer.parseInt(node.value.toString());

        if (nodeValue < value) {
            node.right_node = removeNode(node.right_node, value);
            return node;
        } else if (nodeValue > value) {
            node.left_node = removeNode(node.left_node, value);
            return node;
        } else {

            MyBinaryNode maxNode = findAndRemoveMaxNode(node);
            maxNode.value = maxNodeValue;

            return maxNode;
        }

    }

    private MyBinaryNode findAndRemoveMaxNode(MyBinaryNode node) {
        if (node.right_node == null) {
            node.left_node = removeMaxNode(node.left_node);
            return node;
        } else {
            node.right_node = removeMaxNode(node.right_node);
            return node;
        }
    }

    private MyBinaryNode removeMaxNode(MyBinaryNode node) {

        if(node.right_node != null) {
            node.right_node = removeMaxNode(node.right_node);
            return node;
        }
        maxNodeValue = Integer.parseInt(node.value.toString());
        return null;
    }

    public void printBST() {

        System.out.println("Root node value: " + rootNode.value);

        Queue<MyBinaryNode> currentLevel = new LinkedList<MyBinaryNode>();
        Queue<MyBinaryNode> nextLevel = new LinkedList<MyBinaryNode>();
        currentLevel.add(rootNode);

        while (!currentLevel.isEmpty()) {

            System.out.print((currentLevel.peek()).value + " ");
            MyBinaryNode node = currentLevel.poll();

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
