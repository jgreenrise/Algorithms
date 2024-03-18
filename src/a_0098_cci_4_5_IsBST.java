import tree.bst.TreeNode;

public class a_0098_cci_4_5_IsBST {

    static TreeNode rootNode;

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {

        if (node == null) return true;

        if (node.left != null) {
            if (node.left.val < node.val) {
                if (min != null && node.left.val <= min) return false;
                if (max != null && node.left.val >= max) return false;
            } else {
                return false;
            }
        }

        if (node.right != null) {
            if (node.right.val > node.val) {
                if (min != null && node.right.val <= min) return false;
                if (max != null && node.right.val >= max) return false;
            } else {
                return false;
            }
        }

        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }

}
