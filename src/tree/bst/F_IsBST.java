package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class F_IsBST {

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

    private static boolean isBinarySearchTree(TreeNode node) {

        if (node.right == null && node.left == null) {
            return true;
        }

        if (node.left == null) {
            // Node < Node.right
            if (node.value.compareTo(node.right.value) < 0) {
                return isBinarySearchTree(node.right);
            }
            return false;
        }

        if (node.right == null) {
            // Node > Node.left
            if (node.value.compareTo(node.left.value) > 0) {
                return isBinarySearchTree(node.left);
            }
            return false;
        }

        // If left and right both are available
        // Node > node.left_node && Node < node.right
        if (node.right.value.compareTo(node.value) > 0 && node.left.value.compareTo(node.value) < 0)
            return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
        return false;
    }

    public boolean isValidBST(TreeNode node) {
        WrapperTreeNode response = isValid(node);
        return response == null ? false:true;
    }

    public WrapperTreeNode isValid(TreeNode node){ // 50 , 25, 12, 26

        if(node.left == null && node.right == null){
            return new WrapperTreeNode(node.val, node.val);
        }else if(node.left == null && node.right != null){
            WrapperTreeNode rightNode = isValid(node.right);

            if(rightNode != null){
                if(node.val < node.right.val && node.val > rightNode.max){
                    return rightNode;
                }
                return null;
            }

            return rightNode;


        }else if(node.right == null && node.left != null){

            WrapperTreeNode leftNode = isValid(node.left);

            if(leftNode != null){
                if(node.val >= node.left.val && node.val >= leftNode.min){
                    return leftNode;
                }
                return null;
            }

            return leftNode;

        }else{

            if(node.val < node.right.val && node.val >= node.left.val){
                WrapperTreeNode leftNode = isValid(node.left); // 25, 12 <
                WrapperTreeNode rightNode = isValid(node.right); // 26

                if(node.val >= leftNode.max && node.val < rightNode.min){
                    return new WrapperTreeNode(rightNode.min, leftNode.max);
                }

            }

            return null;

        }


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

    private class WrapperTreeNode {

        int min;
        int max;

        public WrapperTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
        }

    }
}
