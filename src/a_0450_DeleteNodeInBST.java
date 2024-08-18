import java.util.LinkedList;
import java.util.Queue;
import tree.bst.MyDuplicateItemException;
import tree.bst.TreeNode;

public class a_0450_DeleteNodeInBST {

    static TreeNode rootNode;
    private static int maxNodeValue;

    public static void main(String args[]) throws MyDuplicateItemException {

        // Adding node to bst
        a_0450_DeleteNodeInBST binarySearchTree = new a_0450_DeleteNodeInBST();
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

    public TreeNode deleteNode(TreeNode root, int key) {
        return findnodeToBeDeleted(root, key, false);
    }

    public TreeNode findnodeToBeDeleted(TreeNode node, int key, Boolean matchFound) {

        if (node == null) return node;
        if (node.val == key) {
            node = (node.left == null && node.right == null) ? node : findNextCandidate(node);
            matchFound = true;
            return node;
        } else {
            node.left = findnodeToBeDeleted(node.left, key, matchFound);
            if (!matchFound)
                node.right = findnodeToBeDeleted(node.right, key, matchFound);
            return node;
        }
    }

    public TreeNode findNextCandidate(TreeNode node) {
        TreeNode nodeToBeReplaced = null;
        if ((node.left != null && node.right != null) || (node.left == null)) {
            node.right = fetchNextCandidateAndDeleteFromTree(node.right, true, nodeToBeReplaced);
            nodeToBeReplaced.right = node.right;
        } else if (node.right == null) {
            node.left = fetchNextCandidateAndDeleteFromTree(node.left, false, nodeToBeReplaced);
            nodeToBeReplaced.left = node.left;
        }
        return nodeToBeReplaced;
    }

    public TreeNode fetchNextCandidateAndDeleteFromTree(TreeNode node, boolean shouldFindMinAndDelete, TreeNode nodeToBeReplaced) {
        if (shouldFindMinAndDelete) {
            if (node.left == null) {
                nodeToBeReplaced = new TreeNode(node.val);
                return node.right != null ? node.right : null;
            } else {
                node.left = fetchNextCandidateAndDeleteFromTree(node.left, shouldFindMinAndDelete, nodeToBeReplaced);
                return node;
            }
        } else {
            if (node.right == null) {
                nodeToBeReplaced = new TreeNode(node.val);
                return node.left != null ? node.left : null;
            } else {
                node.right = fetchNextCandidateAndDeleteFromTree(node.right, shouldFindMinAndDelete, nodeToBeReplaced);
                return node;
            }
        }

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

        if (node.right != null) {
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
