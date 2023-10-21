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

        System.out.println("Is BST: " + isValidBST(rootNode));
    }

    public static boolean isValidBST(TreeNode root) {

        return isValidBSTUsingMinMaxApproach(root, null, null);

    }

    private static boolean isValidBSTUsingMinMaxApproach(TreeNode node, Integer min, Integer max) {

        if(node != null){

            if(node.left != null){
                if(node.left.val < node.val){
                    // Great

                    if(min != null){
                        if(node.left.val >= min){
                            // Great
                        }else{
                            return false;
                        }
                    }

                }else{
                    return false;
                }

            }

            if(node.right != null){
                if(node.right.val > node.val){
                    // Great

                    if(max != null){
                        if(node.right.val < max){
                            // Great
                        }else{
                            return false;
                        }
                    }

                }else{
                    return false;
                }
            }

            return isValidBSTUsingMinMaxApproach(node.right, node.val, max) &&
                    isValidBSTUsingMinMaxApproach(node.left, min, node.val);


        }else{
            return true;
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

}
