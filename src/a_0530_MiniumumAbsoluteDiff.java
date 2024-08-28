public class a_0530_MiniumumAbsoluteDiff {

    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        buildInorderList(root);
        return min;

    }

    public void buildInorderList(TreeNode node) {

        if (node == null)
            return;

        buildInorderList(node.left);

        if (prev != null) {
            int currval = Math.abs(node.val - prev.val);
            min = Math.min(currval, min);
        }
        prev = node;

        buildInorderList(node.right);

    }

}