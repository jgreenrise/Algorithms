package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class H_PostOrderPrint {

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
        H_PostOrderPrint binarySearchTree = new H_PostOrderPrint();
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

        System.out.println("Printing In order: ");

        binarySearchTree.printPostOrder(rootNode);
    }

    private void printPostOrder(BinaryNode node) {

        if(node.left_node != null){
            printPostOrder(node.left_node);
        }

        if(node.right_node != null){
            printPostOrder(node.right_node);
        }

        System.out.println(node.value);

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
