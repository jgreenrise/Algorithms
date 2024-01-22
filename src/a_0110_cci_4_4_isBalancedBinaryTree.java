import tree.bst.TreeNode;

/**
 * Time complexity: O(n2)
 */
public class a_0110_cci_4_4_isBalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4, n7, n8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n5, n6);
        TreeNode n1 = new TreeNode(1, n2, n4);

        System.out.println(isBalanced(n1));

        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        n6.left = n10;
        n10.left = n11;

        System.out.println(isBalanced(n1));

        n10.left = null;

        System.out.println(isBalancedBinaryTreeUsingRecursion(n1));

    }

    public static boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        int leftHt = isBalancedv2(root.left);
        int rightHt = isBalancedv2(root.right);
        if(leftHt == -1 || rightHt == -1){
            return false;
        }else{
            return leftHt >= rightHt ?
                    (leftHt - rightHt < 2) :
                    (rightHt - leftHt < 2) ;
        }

    }

    public static int isBalancedv2(TreeNode node){
        if(node == null)    return 0;
        int leftHt = isBalancedv2(node.left);
        int rightHt = isBalancedv2(node.right);

        if(leftHt == -1 || rightHt == -1){
            return -1;
        }else{
            return leftHt >= rightHt ?
                    (leftHt - rightHt < 2 ? 1 + leftHt  : -1) :
                    (rightHt - leftHt < 2 ? 1 + rightHt : -1) ;
        }

    }

    private static boolean isBalancedBinaryTreeUsingRecursion(TreeNode node) {

        int left = usingRecursion(node.left, 0);
        int right = usingRecursion(node.right, 0);
        if (left > right) {
            return (left - right) <= 1;
        } else {
            return (right - left) <= 1;
        }
    }

    private static int usingRecursion(TreeNode node, int depth) {
        int left = 0, right = 0;
        if (node.left == null && node.right == null)
            return 0;
        if (node.left != null)
            left = 1 + usingRecursion(node.left, depth);
        if (node.right != null)
            right = 1 + usingRecursion(node.right, depth);
        return Integer.max(left, right);
    }

}
