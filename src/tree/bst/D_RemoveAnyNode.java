package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class D_RemoveAnyNode {

    static TreeNode rootNode;
    private static int maxNodeValue;

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

    private TreeNode removeNode(TreeNode node, int value) {

        int nodeValue = Integer.parseInt(node.value.toString());

        if (nodeValue < value) {
            node.right = removeNode(node.right, value);
            return node;
        } else if (nodeValue > value) {
            node.left = removeNode(node.left, value);
            return node;
        } else {

            TreeNode maxNode = findAndRemoveMaxNode(node);
            maxNode.value = maxNodeValue;

            return maxNode;
        }

    }

    private TreeNode findAndRemoveMaxNode(TreeNode node) {
        if (node.right == null) {
            node.left = removeMaxNode(node.left);
            return node;
        } else {
            node.right = removeMaxNode(node.right);
            return node;
        }
    }

    private TreeNode removeMaxNode(TreeNode node) {

        if(node.right != null) {
            node.right = removeMaxNode(node.right);
            return node;
        }
        maxNodeValue = Integer.parseInt(node.value.toString());
        return null;
    }

    public void printBST() {

        System.out.println("Root node value: " + rootNode.value);

        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currentLevel.add(rootNode);

        while (!currentLevel.isEmpty()) {

            System.out.print((currentLevel.peek()).value + " ");
            TreeNode node = currentLevel.poll();

            if (node.left != null)
                nextLevel.add(node.left);

            if (node.right != null)
                nextLevel.add(node.right);

            if (currentLevel.isEmpty()) {
                System.out.println();

                while (!nextLevel.isEmpty())
                    currentLevel.add(nextLevel.poll());
            }
        }
    }

}
