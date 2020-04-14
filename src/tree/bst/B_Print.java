package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class B_Print {

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
        B_Print binarySearchTree = new B_Print();
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
        binarySearchTree.printUsing1Queue();

        binarySearchTree.printUsing2Queue();

    }

    public void printUsing1Queue() {

        System.out.println("Root node value: " + rootNode.value);

        Queue<MyBinaryNode> nextLevel = new LinkedList<MyBinaryNode>();
        nextLevel.add(rootNode);

        while (!nextLevel.isEmpty()) {

            System.out.print((nextLevel.peek()).value + " ");
            MyBinaryNode node = nextLevel.poll();

            if (node.left_node != null)
                nextLevel.add(node.left_node);

            if (node.right_node != null)
                nextLevel.add(node.right_node);

        }
    }

    public void printUsing2Queue() {

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
