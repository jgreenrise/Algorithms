import tree.bst.TreeNode;

public class a_0230_KthSmallestElementInBST {

    public int globalIndex = 0;
    public int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }

    public void inorder(TreeNode node, int k) {

        if (node.left != null)
            inorder(node.left, k);

        //node.val
        globalIndex++;
        if (globalIndex == k) {
            val = node.val;
        }

        if (node.right != null)
            inorder(node.right, k);

    }

}
