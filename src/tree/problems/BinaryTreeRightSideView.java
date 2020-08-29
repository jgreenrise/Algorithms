package tree.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */

public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        //Integer[] tree = new Integer[]{1,2,3,null,5,null,4};
        Integer[] tree = new Integer[]{1, 2, 3, 7, null, 4, 5, 8, 9, null, null, null, null, null, 6, 9, null, null, 11};
        BinaryTreeRightSideView tr = new BinaryTreeRightSideView();


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

        System.out.println(tr.rightSideViewUsingCount(node1));

        System.out.println(tr.rightSideViewUsingRecursion(node1));
    }

    private List<Integer> rightSideViewUsingRecursion(TreeNode node){

        List<Integer> out = new ArrayList();
        return helper(node, out, 0);
    }

    private List<Integer> helper(TreeNode node, List<Integer> out, int level) {

        if(out.size() == level){
            out.add(node.val);
        }

        if(node.right != null)
            helper(node.right, out, level+1);

        if(node.left != null)
            helper(node.left, out, level+1);

        return out;
    }

    private List<Integer> rightSideViewUsingCount(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList();
        List<Integer> out = new ArrayList();
        if(node == null){
            return out;
        }

        queue.add(node);
        int count = 1;

        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();

            if (count == 1) {
                out.add(poll.val);
            }

            count--;

            if (poll.left != null)
                queue.add(poll.left);

            if (poll.right != null)
                queue.add(poll.right);

            if (count == 0)
                count = queue.size();
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
