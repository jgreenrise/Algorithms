package tree.problems.successor;

public class FindSuccessorUsingParentLink {

    static PreviousIntValue previousIntValue = null;

    public static class PreviousIntValue {
        int val;

        public PreviousIntValue(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {

        TreeNode node20 = new TreeNode(20);
        TreeNode node8 = new TreeNode(8);
        TreeNode node22 = new TreeNode(22);
        TreeNode node4 = new TreeNode(4);
        TreeNode node12 = new TreeNode(12);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);

        node14.parent = node12;
        node10.parent = node12;
        node12.right = node14;
        node12.left = node10;
        node12.parent = node8;
        node4.parent = node8;
        node8.left = node4;
        node8.right = node12;
        node8.parent = node20;
        node22.parent = node20;
        node20.left = node8;
        node20.right = node22;

        System.out.println("Next successor of 14: " + nextSuccessor(node14, null));
        System.out.println("Next successor of 12: " + nextSuccessor(node12, null));
        System.out.println("Next successor of 8: " + nextSuccessor(node8, null));
        System.out.println("Next successor of 20: " + nextSuccessor(node20, null));

    }

    private static int nextSuccessor(TreeNode node, TreeNode parent) {

        // ROOT NODE
        if(node.parent == null)
            return findMin(node.right);

        // LEAF NODE
        if (node.right == null && parent == null) {
            return nextSuccessor(node, node.parent);
        }

        // NODE WITH RIGHT CHILD NODE
        if (parent == null && node.right != null) {
            return findMin(node.right);
        }

        if (parent.val > node.val)
            return parent.val;
        else
            return nextSuccessor(node, parent.parent);

    }

    private static int findMin(TreeNode node) {

        if (node.left != null)
            return findMin(node.left);

        return node.val;

    }

}
