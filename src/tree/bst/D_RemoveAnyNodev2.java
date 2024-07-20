package tree.bst;

public class D_RemoveAnyNodev2 {

    public static void main(String[] args) {
        // Create a sample binary tree [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int key = 3;
        D_RemoveAnyNodev2 solution = new D_RemoveAnyNodev2();
        TreeNode updatedRoot = solution.deleteNode(root, key);
        printTree(updatedRoot);
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) return node;
        if (node.val == key) {

            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode min = findMin(node.right);
                node.val = min.val;
                node.right = deleteNode(node.right, node.val);
                return node;
            }
        } else {
            node.left = deleteNode(node.left, key);
            node.right = deleteNode(node.right, key);
            return node;
        }
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}

