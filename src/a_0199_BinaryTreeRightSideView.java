import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150
 */

public class a_0199_BinaryTreeRightSideView {

    public static void main(String[] args) {

        //Integer[] tree = new Integer[]{1,2,3,null,5,null,4};
        Integer[] tree = new Integer[]{1, 2, 3, 7, null, 4, 5, 8, 9, null, null, null, null, null, 6, 9, null, null, 11};
        a_0199_BinaryTreeRightSideView tr = new a_0199_BinaryTreeRightSideView();


        TreeNode node11 = new TreeNode(11);
        TreeNode node9 = new TreeNode(9);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node91 = new TreeNode(91);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node91.right = node11;
        node8.left = node9;
        node7.left = node8;
        node7.right = node91;
        //node5.right = node6;
        node3.left = node4;
        node3.right = node5;
        node2.left = node7;
        node1.left = node2;
        node1.right = node3;

        System.out.println(tr.rightSideViewDFS(node1));
        System.out.println(tr.rightSideViewUsingRecursion(node1));
    }

    private List<Integer> rightSideViewUsingRecursion(TreeNode node) {
        List<Integer> out = new ArrayList();
        return helper(node, out, 0);
    }

    private List<Integer> helper(TreeNode node, List<Integer> out, int level) {

        if (out.size() == level)
            out.add(node.val);

        if (node.right != null)
            helper(node.right, out, level + 1);

        if (node.left != null)
            helper(node.left, out, level + 1);

        return out;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> out = new ArrayList();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    if (i == size - 1)
                        out.add(curr.val);
                    if (curr.left != null)
                        queue.offer(curr.left);
                    if (curr.right != null)
                        queue.offer(curr.right);
                }

            }

        }
        return out;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
