package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class C_RemoveLeafNode {

    static TreeNode rootNode;

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

    private TreeNode removeLeafNode(TreeNode node, int value) throws Exception {

        if (node == null) {
            throw new Exception("Node does not exist");
        }

        if (Integer.valueOf(node.value.toString()) == value)
            return null;
        if (Integer.valueOf(node.value.toString()) > value) {
            node.left = removeLeafNode(node.left, value);
            return node;
        }
        node.right = removeLeafNode(node.right, value);
        return node;
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
