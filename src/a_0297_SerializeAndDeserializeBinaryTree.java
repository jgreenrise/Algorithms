import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class a_0297_SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        // Create the tree from the array [1, 2, 3, null, null, 4, 5]
        Integer[] array = {1, 2, 3, null, null, 4, 5};
        TreeNode root = createTreeFromArray(array);

        // Call the serialize method
        a_0297_SerializeAndDeserializeBinaryTree obj = new a_0297_SerializeAndDeserializeBinaryTree();
        obj.serialize(root);
        TreeNode node = obj.deserialize(obj.serialize(root));
        System.out.println(node);
    }

    // Method to create a binary tree from a given array
    public static TreeNode createTreeFromArray(Integer[] array) {
        if (array == null || array.length == 0) return null;

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();
            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public String serialize(TreeNode node) {
        StringBuilder sbr = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {

            int size = q.size();
            boolean hasLeafNodes = false;

            for (int j = 0; j < size; j++) {
                TreeNode newNode = q.poll();             // 1 2 3
                sbr.append(String.valueOf(newNode.val).trim() + " ");

                if (newNode.val != -1 && newNode.left != null) {
                    q.offer(newNode.left);              // 2, 4
                    hasLeafNodes = true;
                } else {
                    q.offer(new TreeNode(-1));
                }

                if (newNode.val != -1 && newNode.right != null) {
                    q.offer(newNode.right);              // 3  4
                    hasLeafNodes = true;
                } else {
                    q.offer(new TreeNode(-1));
                }
            }

            if (!hasLeafNodes) {
                q.clear();
                break;
            }
        }
        System.out.println(sbr);
        return sbr.toString();
    }

    // Decodes your encoded data to tree.
    // 1 2 3 4 5 -1 -1 6
    // 0 1 2 3 4  5  6 7
    public TreeNode deserialize(String data) {

        TreeNode root = null;
        TreeNode node = null;
        Map<Integer, TreeNode> map = new HashMap<>();

        if (data == null) {
            return new TreeNode(-1);
        }

        String[] strs = data.split(" ");
        for (int j = 0; j < strs.length; j++) {
            TreeNode newNode = new TreeNode(Integer.valueOf(strs[j]));
            if (j == 0) {
                root = newNode;
                node = root;
                map.put(0, node);
            } else {
                if (!strs[j].equals("-1")) {
                    int parentIndex = (j - 1) / 2;
                    int childIndex = j;
                    if (2 * parentIndex + 1 == childIndex) {
                        // left child
                        if (map.get(parentIndex) != null)
                            (map.get(parentIndex)).left = newNode;
                    } else {
                        // right child
                        if (map.get(parentIndex) != null)
                            (map.get(parentIndex)).right = newNode;
                    }
                    map.put(j, newNode);
                }
            }
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
