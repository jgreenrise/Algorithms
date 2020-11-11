package tree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
 */
class KDistanceAway {

    /**
     * METHOD 2: RECURSION
     */
    public List<Integer> distanceKUsingRecursion(TreeNode root, TreeNode target, int K) {
        List<Integer> out = new ArrayList();
        distanceKList(root, target, K, out);
        return out;
    }

    public int distanceKListRecursion(TreeNode node, TreeNode target, int K, List<Integer> list){

        if(node == null)
            return -1;

        if(node.val == target.val){
            findChildNodesUsingBFS(node, K, list);
            node.val = -1;
            return K-1;
        }

        int left = distanceKListRecursion(node.left, target, K, list);
        int right = distanceKListRecursion(node.right, target, K, list);

        if(left < 0 && right < 0){
            return -1;
        }else{
            findChildNodesUsingBFS(node, Math.max(left, right), list);
            return K-1;
        }
    }

    public void findChildNodesUsingBFS(TreeNode node, int K, List<Integer> list){

        if(node == null || node.val == -1)
            return;

        if (K == 0)
            list.add(node.val);

        findChildNodesUsingBFS(node.left, K-1, list);
        findChildNodesUsingBFS(node.right, K-1, list);

    }

    /**
     * METHOD 1: MAP
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> out = new ArrayList();
        distanceKList(root, target, K, out);
        return out;

    }

    public void distanceKList(TreeNode node, TreeNode target, int K, List<Integer> list) {

        Map<TreeNode, TreeNode> map = new HashMap<>();
        if(node.val == target.val){
            map.put(node, null);
        }else{
            buildMap(node.left, target, map, node);
            buildMap(node.right, target, map, node);
        }

        distanceKTarget(target, true, map, list, K);

    }

    public void distanceKTarget(TreeNode node, boolean isTargetNode, Map<TreeNode, TreeNode> map, List<Integer> list, int K){

        if(node == null){
            return;
        }

        if(K == 0){
            list.add(node.val);
            return;
        }

        findChildNodesUsingRecursion(node, K, list);
        node.val = -1;
        distanceKTarget(map.get(node), false, map, list, K-1);

    }

    public void buildMap(TreeNode node, TreeNode target, Map<TreeNode, TreeNode> map, TreeNode parentNode){

        if(node == null){
            return;
        }

        if(node.val != target.val){
            map.put(node, parentNode);
            buildMap(node.left, target, map, node);
            buildMap(node.right, target, map, node);
        }else{
            map.put(node, parentNode);
        }

    }

    public void findChildNodesUsingRecursion(TreeNode node, int K, List<Integer> list){

        if(node == null || node.val == -1)
            return;

        if (K == 0)
            list.add(node.val);

        findChildNodesUsingRecursion(node.left, K-1, list);
        findChildNodesUsingRecursion(node.right, K-1, list);

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

        node2.left = node7;
        node2.right = node4;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node3.right = node1;
        node3.left = node5;
        //System.out.println(class1.distanceK(node3, node5, 2));
        System.out.println(class1.distanceKUsingRecursion(node3, node5, 2));

/*       node1.left = node3;
        node0.left = node2;
        node0.right = node1;
        System.out.println(class1.distanceK(node0, node3, 2));
        System.out.println(class1.distanceK(node0, node3, 3));*/

/*        node1.left = node3;
        node1.right = node2;
        node0.left = node1;
        System.out.println(class1.distanceK(node0, node2, 1));
        node2.right = node5;
        node3.left = node4;
        node1.right = node3;
        node0.left= node1;
        node0.right= node2;
        System.out.println(class1.distanceK(node0, node3, 3));
        */



    }
}