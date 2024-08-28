import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
 */
class a_0863_AllNodesDistanceKAwayBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Set<Integer> isVisited = new HashSet();
        Map<TreeNode, TreeNode> map = new HashMap();
        buildMap(map, root, null, target, false);

        List<Integer> out = new ArrayList();
        findChildNodesKDistanceAway(target, k, isVisited, out);
        findChildNodesKDistanceAwayFromParents(target, k, isVisited, out, map);

        return out;

    }

    public void findChildNodesKDistanceAwayFromParents(TreeNode node, int k, Set<Integer> isVisited, List<Integer> out, Map<TreeNode, TreeNode> map) {

        int counter = k;
        while (map.get(node) != null) {
            counter--;
            TreeNode parent = map.get(node);
            findChildNodesKDistanceAway(parent, counter, isVisited, out);
            node = parent;
        }

    }

    public void findChildNodesKDistanceAway(TreeNode node, int k, Set<Integer> isVisited, List<Integer> out) {

        if (node == null || isVisited.contains(node.val))
            return;

        if (k == 0) {
            out.add(node.val);
            return;
        }

        isVisited.add(node.val);
        findChildNodesKDistanceAway(node.left, k - 1, isVisited, out);
        findChildNodesKDistanceAway(node.right, k - 1, isVisited, out);

    }


    // {}, 3, null, 2, f > {3:null}
    //      map, 5, 3, 2, f > {3:null, 5:3}
    //          map, 6, 5, 2, f > {3:null, 5:3, 6:5}
    //              map, 10, 6, 2, f > {3:null, 5:3, 6:5, 10:6}
    //          map, 2, 5, 2, f > {3:null, 5:3, 6:5, 2:5}
    public void buildMap(Map<TreeNode, TreeNode> map, TreeNode node, TreeNode parentNode, TreeNode target, Boolean isMatchFound) {

        if (node == null || isMatchFound)
            return;

        if (node.val == target.val)
            isMatchFound = true;

        map.put(node, parentNode);
        buildMap(map, node.left, node, target, isMatchFound);
        buildMap(map, node.right, node, target, isMatchFound);

    }

    private static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String args[]) {

        a_0863_AllNodesDistanceKAwayBinaryTree class1 = new a_0863_AllNodesDistanceKAwayBinaryTree();
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
        TreeNode node10 = new TreeNode(10);

        node6.left = node10;
        node2.left = node7;
        node2.right = node4;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node3.right = node1;
        node3.left = node5;
        //System.out.println(class1.distanceK(node3, node5, 2));
        System.out.println(class1.distanceK(node3, node2, 2));

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