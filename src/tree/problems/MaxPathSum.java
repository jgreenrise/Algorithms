package tree.problems;

import java.util.Map;

public class MaxPathSum {

    public static Integer globalMax = Integer.MIN_VALUE;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean isVisited;

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

    public static void main(String[] args) {

        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n7 = new TreeNode(7, n3, null);
        TreeNode n15 = new TreeNode(15, null, n3);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n_10 = new TreeNode(-10, n9, n20);

        MaxPathSum maxPathSum = new MaxPathSum();
        //System.out.println(maxPathSum.maxPathSum(n_10));

        TreeNode n_2 = new TreeNode(-2);
        TreeNode n_1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(2, n_1, n_2);
        System.out.println(maxPathSum.maxPathSum(n2));

        n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1, n2, null);
        //System.out.println(maxPathSum.maxPathSum(n1));

        n_2 = new TreeNode(-2);
        n_1 = new TreeNode(-1);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1, n_1, null);
        TreeNode n_22 = new TreeNode(-2, n1, n3);
        TreeNode n_3 = new TreeNode(-3, n_2, null);
        TreeNode n_11 = new TreeNode(1, n_22, n_3);
        //System.out.println(maxPathSum.maxPathSum(n_11));

        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1, n2, n3);
        //System.out.println(maxPathSum.maxPathSum(n1));

    }

    public int maxPathValue(TreeNode node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            globalMax = Math.max(node.val, globalMax);
            return node.val;
        }

        int currMax;
        int currMaxIncludingNode = 0;

        if (node.left == null) {
            currMax = maxPathValue(node.right);
            currMaxIncludingNode = Math.max(node.val, currMax);
            currMaxIncludingNode = Math.max(currMaxIncludingNode, currMax + node.val);


        } else if (node.right == null) {

            currMax = maxPathValue(node.left);
            currMaxIncludingNode = Math.max(node.val, currMax);
            currMaxIncludingNode = Math.max(currMaxIncludingNode, currMax + node.val);

        } else {

            int left = maxPathValue(node.left);
            int right = maxPathValue(node.right);

            currMax = Math.max(left, right);
            currMaxIncludingNode = Math.max(right + node.val, left + node.val);
            currMaxIncludingNode = Math.max(currMaxIncludingNode, node.val);
            currMaxIncludingNode = Math.max(currMaxIncludingNode, right + left + node.val);

        }

        if (currMax > currMaxIncludingNode) {
            globalMax = Math.max(globalMax, currMax);
        } else {
            globalMax = Math.max(globalMax, currMaxIncludingNode);
        }

        System.out.println(node.val + " : " + globalMax);

        node.val = currMaxIncludingNode;

        return node.val;

    }

    public int maxPathSum(TreeNode node) {

        maxPathValue(node);
        return globalMax;

    }

}
