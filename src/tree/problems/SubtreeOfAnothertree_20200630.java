package tree.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SubtreeOfAnothertree_20200630 {
    public static boolean isSubtreeRecursively(TreeNode parent, TreeNode child, boolean searchStarted) {
        boolean matchFound = false;
        if(parent == null && child != null)
            return false;
        if(parent != null && child == null)
            return false;
        if(parent == null && child == null)
            return true;

        if(parent.val == child.val){
            matchFound = isSubtreeRecursively(parent.left, child.left, true)
                    && isSubtreeRecursively(parent.right, child.right, true);

            if(matchFound){
                return true;
            }

        }

        if(searchStarted){
            return false;
        }

        return isSubtreeRecursively(parent.left, child, false)
                || isSubtreeRecursively(parent.right, child, false);

    }

    public static boolean isSubtreeRecursively(TreeNode parent, TreeNode child) {
       return isSubtreeRecursively(parent, child, false);
    }

    public static boolean isSubtree(TreeNode parent, TreeNode child) {
        String tree1 = preOrderHash(parent, true);
        String tree2 = preOrderHash(child, true);
        return tree1.indexOf(tree2) >= 0;
    }

    private static String preOrderHash(TreeNode node, boolean left) {
        if(node == null){
            if(left) return "left_null";
            else    return "right_null";
        }else{
            return "#"+node.val + " "+preOrderHash(node.left, true) + " "+preOrderHash(node.right, false);
        }
    }

    private static class TreeNode {

        public int val;
        public TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
        }

    }


    public static void main2(String[] args) {

        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        n4.left = n1;
        n5.left = n2;
        n3.left = n4;
        n3.right = n5;

        TreeNode n31 = new TreeNode(3);
        TreeNode n11 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
        n31.left = n11;
        n31.right = n21;

        System.out.println(isSubtreeRecursively(n3, n31));

        TreeNode n100 = new TreeNode(1);
        TreeNode n110 = new TreeNode(1);
        n100.left = n110;

        TreeNode n1000 = new TreeNode(1);
        //System.out.println(isSubtree(n100, n1000));


    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode s = stringToTreeNode(line);
            line = in.readLine();
            TreeNode t = stringToTreeNode(line);

            boolean ret = new SubtreeOfAnothertree_20200630().isSubtree(s, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }



}
