import tree.bst.TreeNode;

public class a_0098_cci_4_5_IsBST {

    static TreeNode rootNode;

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTUsingMinMaxApproach(root, null, null);

    }

    private static boolean isValidBSTUsingMinMaxApproach(TreeNode node, Long min, Long max) {

        if (node == null)
            return true;

        if (min != null && node.val <= min) {
            return false;
        }

        if (max != null && node.val >= max) {
            return false;
        }


        return isValidBSTUsingMinMaxApproach(node.left, min, (long) (node.val)) &&
                isValidBSTUsingMinMaxApproach(node.right, (long) (node.val), max);
    }

    public boolean isValidBSTv1(TreeNode root) {

        ModifiedTreeNode upgradedRoot = isValidBinaryTree(root);
        return upgradedRoot.isBST;
    }

    public ModifiedTreeNode isValidBinaryTree(TreeNode node) {

        if (node == null)
            return null;

        ModifiedTreeNode newnode = new ModifiedTreeNode(node.val);
        newnode.left = isValidBinaryTree(node.left);
        newnode.right = isValidBinaryTree(node.right);

        if (newnode.left != null && newnode.right != null) {
            if (!newnode.left.isBST || !newnode.right.isBST) {
                newnode.isBST = false;
            } else if ((newnode.val > newnode.left.val && newnode.val < newnode.right.val) &&
                    (newnode.val > (newnode.left).max_so_far && newnode.val < (newnode.right).min_so_far)) {
                newnode.min_so_far = newnode.left.min_so_far;
                newnode.max_so_far = newnode.right.max_so_far;
                newnode.isBST = true;
            } else {
                newnode.isBST = false;
            }
            return newnode;
        } else if (newnode.left == null && newnode.right != null) {
            newnode.min_so_far = newnode.val;
            if (!newnode.right.isBST) {
                newnode.isBST = false;
            } else if (newnode.val < newnode.right.val &&
                    (newnode.val < newnode.right.min_so_far)) {
                newnode.max_so_far = newnode.right.max_so_far;
                newnode.isBST = true;
            } else {
                newnode.isBST = false;
            }
            return newnode;

        } else if (newnode.left != null && newnode.right == null) {
            newnode.max_so_far = newnode.val;
            if (!newnode.left.isBST) {
                newnode.isBST = false;
            } else if (newnode.val > newnode.left.val &&
                    (newnode.val > newnode.left.max_so_far)) {
                newnode.min_so_far = newnode.left.min_so_far;
                newnode.isBST = true;
            } else {
                newnode.isBST = false;
            }
            return newnode;
        } else {
            newnode.min_so_far = newnode.val;
            newnode.max_so_far = newnode.val;
            newnode.isBST = true;
            return newnode;
        }

    }

    public class ModifiedTreeNode extends TreeNode {
        public int min_so_far;
        public int max_so_far;
        public ModifiedTreeNode left;
        public ModifiedTreeNode right;
        public boolean isBST = false;

        public ModifiedTreeNode(int val) {
            super(val);
        }

    }

}
