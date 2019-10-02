package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;

public class E_Height {

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
        E_Height binarySearchTree = new E_Height();
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
        binarySearchTree.insert(51);

        // Print BST
        binarySearchTree.printBST();
        System.out.println("Height of tree" + height(rootNode));
    }

    public static int height(BinaryNode node){

        if(node.left_node == null && node.right_node == null){
            return 1;
        }else if(node.left_node == null){
            return 1 + height(node.right_node);
        }else if(node.right_node == null){
            return 1 + height(node.left_node);
        }else{
            return 1 + max(height(node.left_node), height(node.right_node));
        }

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