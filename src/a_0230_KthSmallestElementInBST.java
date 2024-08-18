import tree.bst.TreeNode;

public class a_0230_KthSmallestElementInBST {

    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {

        int out = -1;

        if (root.left == null && root.right == null) {
            counter++;
            if (counter == k) return root.val;
        } else if (root.left == null && root.right != null) {
            counter++;
            if (counter == k) {
                return root.val;
            }
            out = kthSmallest(root.right, k);
            if (out != -1) return out;
        } else if (root.left != null && root.right == null) {
            out = kthSmallest(root.left, k);
            if (out != -1) return out;
            counter++;
            if (counter == k) {
                return root.val;
            }
        } else {
            out = kthSmallest(root.left, k);
            if (out != -1) return out;
            counter++;
            if (counter == k) {
                return root.val;
            }
            out = kthSmallest(root.right, k);
            if (out != -1) return out;
        }

        return -1;

    }

}
