import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a_0106_constructBinaryTree {

    public static Integer postorderv2 = 0;

    public static void main(String[] args) {
        /*int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};*/

        int[] inorder = {2, 1};
        int[] postorder = {2, 1};
        a_0106_constructBinaryTree class1 = new a_0106_constructBinaryTree();
        TreeNode root = class1.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> cacheIndex = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            cacheIndex.put(inorder[i], i);
        }
        postorderv2 = inorder.length - 1;
        return buildTreev2(inorder, postorder, 0, postorder.length - 1, cacheIndex);
    }

    public TreeNode buildTreev2(int[] inorder, int[] postorder, int left, int right, Map<Integer, Integer> cache) {
        if (left < 0 || right >= inorder.length || left > right) return null;
        if (left == right) {
            postorderv2--;
            return new TreeNode(inorder[left]);
        }

        TreeNode node = new TreeNode(postorder[postorderv2--]);
        int index = cache.get(node.val);
        node.right = buildTreev2(inorder, postorder, index + 1, right, cache);
        node.left = buildTreev2(inorder, postorder, left, index - 1, cache);
        return node;
    }

    public TreeNode buildTreeUsingRecursionv4(int[] inorder, int[] postorder) {

        if (inorder.length == 0) return null;

        System.out.println("inorder: " + Arrays.toString(inorder));
        System.out.println("postorder: " + Arrays.toString(postorder));

        int lastElem = postorder[postorder.length - 1];
        int index = 0;
        for (int j = 0; j < inorder.length; j++) {
            System.out.println("j: " + j + "jhjh\t" + (postorder.length - 1) + ", \tinorder[j]:" + inorder[j] + ", \tlastElem: " + lastElem);
            if (inorder[j] == lastElem) {
                index = j;
                break;
            }
        }

        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        if (inorder.length == 1) return node;

        int numberOfElementsInRightIndex = inorder.length - 1 - index;
        int numberOfElementsInLeftIndex = index - 0;

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, numberOfElementsInLeftIndex), Arrays.copyOfRange(postorder, 0, numberOfElementsInLeftIndex));
        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, numberOfElementsInLeftIndex, postorder.length - 1));

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
