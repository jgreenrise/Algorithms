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
class SubtreeOfAnothertree_Empty {
    public static boolean isSubTreeRecursively(TreeNode left, TreeNode right, boolean searchStarted){

        if(left == null && right != null){
            return false;
        }else if(left != null && right == null){
            return false;
        }else if(left == null && right == null){
            return true;
        }

        boolean matchFound = false;

        if(left.val == right.val){
            matchFound = isSubTreeRecursively(left.left, right.left, true) &&
                    isSubTreeRecursively(left.right, right.right, true);

            if(matchFound){
                return matchFound;
            }

        }

        if(searchStarted){
            return false;
        }

        if(!matchFound){
            return isSubTreeRecursively(left.left, right, false) ||
                    isSubTreeRecursively(left.right, right, false);
        }

        return false;

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return isSubTreeRecursively(root, subRoot, false);

    }

    private static class TreeNode {

        public int val;
        public TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
        }

    }


    public static void main(String[] args) {

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

        //System.out.println(isSubtreeRecursively(n3, n31));

        TreeNode n100 = new TreeNode(1);
        TreeNode n110 = new TreeNode(1);
        n100.left = n110;

        TreeNode n1000 = new TreeNode(1);
        System.out.println(isSubtree(n100, n1000));

    }


}
