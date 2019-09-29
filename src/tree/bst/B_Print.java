package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class B_Print {

    BinaryNode rootNode;

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
        binarySearchTree.printBST();

    }

    public void printBST() {
        printUsing2Queues();
    }

    private void printUsing2Queues() {

        Queue<BinaryNode> currLevel = new LinkedList<>();
        Queue<BinaryNode> nextLevel = new LinkedList<>();

        currLevel.add(rootNode);

        while (!currLevel.isEmpty()){

            System.out.println(currLevel.peek().value.toString());
            BinaryNode node = currLevel.poll();

            if(node.left_node != null) nextLevel.add(node.left_node);
            if(node.right_node != null) nextLevel.add(node.right_node);

            if(currLevel.isEmpty()){
                while (!nextLevel.isEmpty())
                    currLevel.add(nextLevel.poll());
            }
        }

    }

}
