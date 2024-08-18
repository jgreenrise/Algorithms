import tree.bst.TreeNode;

public class a_0285_InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val) {
                // Potential successor found, keep track and explore left subtree
                successor = current;
                current = current.left;
            } else {
                // Move to the right subtree as potential successors will be there
                current = current.right;
            }
        }

        return successor;
    }
}
