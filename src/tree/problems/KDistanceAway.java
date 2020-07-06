package tree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
 */
class KDistanceAway {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        // Map <Node, Parent>
        Map<Integer, TreeNode> map = new HashMap();

        // Stores output
        List<Integer> out = new ArrayList();

        // For invalid input
        if (root == null || target == null)
            return out;

        // Create map with Node and Parent Node reference, while finding the root
        findNode(root, target, map, null);

        // Add child nodes which are K distance away
        getChildNodes(target, K, out);

        // Add parent nodes which are K distance away
        getParentNodes(target, target, K, out, map, true);

        return out;
    }

    public void getParentNodes(TreeNode node, TreeNode target, int K, List<Integer> out, Map<Integer, TreeNode> map, boolean shouldIgnoreTargetNode) {

        if (K == 0) {
            if(node.val != -1){
                out.add(node.val);
            }
        }else if(node.val == -1){
            return;
        }else {
            TreeNode parentNode = map.get(node.val);

            // Mark node as visited
            node.val = -1;

            if (parentNode == null) {

                // Is Root node
                getChildNodes(parentNode, K - 1, out);
            } else {
                if(shouldIgnoreTargetNode){
                    target.val = -1;
                }
                getChildNodes(parentNode, K - 1, out);
                getParentNodes(parentNode, target, K - 1, out, map, shouldIgnoreTargetNode);
            }
        }

    }

    public void getChildNodes(TreeNode node, int K, List<Integer> out) {

        // Skip Empty node or Node is already visited
        if (node == null || node.val == -1)
            return;

        if (K == 0) {
            if (node.val != -1){
                out.add(node.val);
                node.val = -1;
            }
            return;
        } else {
            getChildNodes(node.left, K - 1, out);
            getChildNodes(node.right, K - 1, out);
        }

    }

    public boolean findNode(TreeNode node, TreeNode target, Map<Integer, TreeNode> map, TreeNode parentNode) {

        if (node == null)
            return false;

        // Assign Parent value
        map.put(node.val, parentNode);

        boolean matchFound = false;
        if (node.val == target.val) {
            return true;
        } else {

            matchFound = findNode(node.left, target, map, node);
            if (!matchFound) {
                return findNode(node.right, target, map, node);
            } else {
                return true;
            }

        }
    }

    private static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String args[]) {

        KDistanceAway class1 = new KDistanceAway();
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

/*        node2.left = node7;
        node2.right = node4;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node3.right = node1;
        node3.left = node5;
        System.out.println(class1.distanceK(node3, node5, 2));*/

/*       node1.left = node3;
        node0.left = node2;
        node0.right = node1;
        System.out.println(class1.distanceK(node0, node3, 2));
        System.out.println(class1.distanceK(node0, node3, 3));*/

/*        node1.left = node3;
        node1.right = node2;
        node0.left = node1;
        System.out.println(class1.distanceK(node0, node2, 1));*/

        node2.right = node5;
        node3.left = node4;
        node1.right = node3;
        node0.left= node1;
        node0.right= node2;
        System.out.println(class1.distanceK(node0, node3, 3));


    }
}