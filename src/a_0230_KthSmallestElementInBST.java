import java.util.ArrayList;
import java.util.List;
import tree.bst.TreeNode;

public class a_0230_KthSmallestElementInBST {

    private boolean stop = false;

    public int kthSmallest(TreeNode root, int k) {
        int out = kthSmallestUsingRecursion(root, k, 0);
        return out < 0 ? out * -1 : out;
    }

    public int kthSmallestUsingRecursion(TreeNode node, int k, int counter) {

        int out = 0;
        if (node.left == null && node.right == null) {
            // Leaf Node
            // Increment counter for leaf node
            counter++;
            if (counter == k) {
                stop = true;
                return node.val;
            }
            return counter;
        } else if (node.left != null && node.right == null) {
            // Node.left != null, node.right == null
            // Increment for left node
            out = kthSmallestUsingRecursion(node.left, k, counter);
            if (stop)
                return out;

            // Increment for parent node
            counter = out + 1;
            if (counter == k) {
                stop = true;
                return node.val;
            }
            return counter;
        } else if (node.left == null && node.right != null) {
            // Increment for parent node
            counter++;
            if (counter == k) {
                stop = true;
                return node.val;
            }

            // Increment for right node
            out = kthSmallestUsingRecursion(node.right, k, counter);
            return out;
        } else {
            // Increment for left node
            out = kthSmallestUsingRecursion(node.left, k, counter);
            if (stop)
                return out;

            // Increment for parent node
            counter = out + 1;
            if (counter == k) {
                stop = true;
                return node.val;
            }

            // Increment for right node
            out = kthSmallestUsingRecursion(node.right, k, counter);
            return out;
        }

    }

    public int kthSmallestUsingInOrderArray(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        buildInOrderList(root, k, list);
        //System.out.println(Arrays.asList(list));
        return list.get(list.size() - 1);

    }

    public void buildInOrderList(TreeNode node, int k, List<Integer> list) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        if (node.left != null) {
            buildInOrderList(node.left, k, list);
            if (list.size() == k) return;
        }
        list.add(node.val);
        if (list.size() == k) return;
        if (node.right != null) {
            buildInOrderList(node.right, k, list);
            if (list.size() == k) return;
        }

    }

}
