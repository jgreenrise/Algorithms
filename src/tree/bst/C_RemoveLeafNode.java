package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class C_RemoveLeafNode {

    static MyBinaryNode rootNode;

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
        C_RemoveLeafNode binarySearchTree = new C_RemoveLeafNode();
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

        binarySearchTree.removeLeafNode(10);
        binarySearchTree.printBST();

        binarySearchTree.removeLeafNode(49);
        binarySearchTree.printBST();

        binarySearchTree.removeLeafNode(32);
        binarySearchTree.printBST();
    }

    private void removeLeafNode(int i) {
        try {
            rootNode = removeLeafNode(rootNode, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MyBinaryNode removeLeafNode(MyBinaryNode node, int value) throws Exception {

        if (node == null) {
            throw new Exception("Node does not exist");
        }

        if (Integer.valueOf(node.value.toString()) == value)
            return null;
        if (Integer.valueOf(node.value.toString()) > value) {
            node.left_node = removeLeafNode(node.left_node, value);
            return node;
        }
        node.right_node = removeLeafNode(node.right_node, value);
        return node;
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
