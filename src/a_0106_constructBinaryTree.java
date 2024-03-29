import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class a_0106_constructBinaryTree {

    public static Integer postorderv2 = 0;

    public static void main(String[] args) {
        int[] inorder = {1, 2, 3, 4, 5};
        int[] postorder = {2, 5, 4, 3, 1};
        a_0106_constructBinaryTree class1 = new a_0106_constructBinaryTree();
        TreeNode root = class1.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> cacheIndex = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            cacheIndex.put(inorder[i], i);
        }
        postorderv2 = inorder.length - 1;
        return buildTree(inorder, postorder, 0, postorder.length - 1, cacheIndex);

    }

    public TreeNode buildTree(int[] inorder,
                              int[] postorder,
                              int startIdx,
                              int endIdx,
                              Map<Integer, Integer> cacheIndex) {

        if (startIdx >= inorder.length || startIdx < 0) return null;
        if (endIdx < 0 || endIdx >= inorder.length) return null;
        if (startIdx > endIdx) return null;

        if (startIdx == endIdx) {
            postorderv2--;
            //System.out.println("B --- Printing Node val: " + inorder[startIdx] + ", start: "+ startIdx + ", end: " + endIdx + ",  postOrderIdx: " + postorderv2);
            return new TreeNode(inorder[startIdx]);
        }

        // System.out.println(postOrderIdx);
        TreeNode node = new TreeNode(postorder[postorderv2]);
        postorderv2--;

        //System.out.println("A --- Printing Node val: " + node.val + ", start: " + startIdx + ", end: "+ endIdx + ",  postOrderIdx: " + postorderv2);
        int currIndex = cacheIndex.get(node.val);
        node.left = buildTree(inorder, postorder, startIdx, currIndex - 1, cacheIndex);
        node.right = buildTree(inorder, postorder, currIndex + 1, endIdx, cacheIndex);

/*        if (cacheIndex.get(postorder[postorderv2]) > currIndex) {
            node.right = buildTree(inorder, postorder, currIndex + 1, endIdx, cacheIndex);
            node.left = buildTree(inorder, postorder, startIdx, currIndex - 1, cacheIndex);
        } else {
            node.left = buildTree(inorder, postorder, startIdx, currIndex - 1, cacheIndex);
            node.right = buildTree(inorder, postorder, currIndex + 1, endIdx, cacheIndex);
        }*/

        return node;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
