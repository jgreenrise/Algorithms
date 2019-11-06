package tree.problems.projectDependencies;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintProjectDependencies {

    public static class TreeNode {
        String val;
        List<TreeNode> parents;
        List<TreeNode> children;
        boolean isCompleted;

        TreeNode(String x) {
            val = x;
            parents = new LinkedList<>();
            children = new LinkedList<>();
        }

        public void addChild(TreeNode [] nodes){
            children.addAll(Arrays.asList(nodes));
        }

        public void addParent(TreeNode [] nodes){
            parents.addAll(Arrays.asList(nodes));
        }
    }


    public static void main(String args[]) {

        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");

 /*       System.out.println("Next successor of 14: " + nextSuccessor(node14, null));
        System.out.println("Next successor of 12: " + nextSuccessor(node12, null));
        System.out.println("Next successor of 8: " + nextSuccessor(node8, null));
        System.out.println("Next successor of 20: " + nextSuccessor(node20, null));*/

        /**
         * Next successor of 14: 20
         * Next successor of 12: 14
         * Next successor of 8: 10
         * Next successor of 20: 22
         */

    }

    private static int nextSuccessor(TreeNode node, TreeNode parent) {

        return -1;

    }

}
