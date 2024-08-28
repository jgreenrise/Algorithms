import java.util.HashMap;
import java.util.Map;
import tree.bst.TreeNode;

public class a_0106_constructBinaryTree {

    public int currindex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        currindex = postorder.length - 1;
        int n = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < inorder.length; k++)
            map.put(inorder[k], k);

        return buildTree(inorder, postorder, map, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> map, int start, int end) {

        if (currindex < 0) return null;
        TreeNode node = new TreeNode(postorder[currindex--]);
        if (start >= end) return node;

        int index = map.get(node.val);
        if (index != end) node.right = buildTree(inorder, postorder, map, index + 1, end); // Node with no right elems
        if (index != start) node.left = buildTree(inorder, postorder, map, start, index - 1); // Node with no left elems
        return node;
    }


}

