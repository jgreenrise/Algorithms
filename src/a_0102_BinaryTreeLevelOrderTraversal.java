import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class a_0102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode node) {


        List<List<Integer>> out = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (node == null) return out;

        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList();

            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode != null) {
                    tmpList.add(tmpNode.val);

                    if (tmpNode.left != null) queue.add(tmpNode.left);
                    if (tmpNode.right != null) queue.add(tmpNode.right);
                }
            }
            out.add(tmpList);
        }
        return out;

    }

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
