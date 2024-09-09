import java.util.HashMap;
import java.util.Map;
import tree.bst.TreeNode;

public class a_0106_constructBinaryTree {

    int globalIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        globalIndex = inorder.length - 1;

        return buildTreeNodeByRange(map, inorder, postorder, 0, inorder.length - 1);
    }

    /**
     * 9,  3,  15,     20,     7
     * 0,  1,  2,      3,      4
     * <p>
     * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * Output: [3,9,20,null,null,15,7]
     */
    public TreeNode buildTreeNodeByRange(Map<Integer, Integer> map, int[] inorder, int[] postorder, int left, int right) {

        TreeNode node = new TreeNode(postorder[globalIndex--]);
        Integer nodeIndex = map.get(node.val);

        if (nodeIndex < right) node.right = buildTreeNodeByRange(map, inorder, postorder, nodeIndex + 1, right);
        if (nodeIndex > left) node.left = buildTreeNodeByRange(map, inorder, postorder, left, nodeIndex - 1);

        return node;
    }

}

