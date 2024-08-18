import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a_0437_cci_4_12_pathWithSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree (you need to initialize this according to your structure)
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.right = new TreeNode(1000000000);

        // Use the 'root' TreeNode in your a_0437_cci_4_12_pathWithSum class for testing
        a_0437_cci_4_12_pathWithSum pathWithSumInstance = new a_0437_cci_4_12_pathWithSum();
        int targetSum = 0;
        // Print the binary tree
        printTree(root);

        int result = pathWithSumInstance.pathSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + result);


    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current != null) {
                System.out.print(current.val + " ");
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                System.out.print("null ");
            }
        }
    }

    public int counter = 0;

    public int pathSum(TreeNode root, int targetSum) {
        List<Long> headList = new ArrayList<>();
        pathSum(root, new ArrayList<>(), targetSum);
        return counter;
    }

    public void pathSum(TreeNode node, List<Long> list, int targetSum) {

        if (node == null)
            return;

        if (list.isEmpty()) {
            List<Long> newList = new ArrayList();
            newList.add(Long.valueOf(node.val));
            if (node.val == targetSum) {
                counter++;
            }
            pathSum(node.left, newList, targetSum);
            pathSum(node.right, newList, targetSum);
        } else {
            List<Long> newList = new ArrayList();
            newList.add(Long.valueOf(node.val));
            if (node.val == targetSum) {
                System.out.println("A1: " + node.val);
                counter++;
            }
            for (long item : list) {
                newList.add(Long.valueOf(node.val + item));
                if (node.val + item == targetSum) {
                    System.out.println("A3: " + (node.val + item));
                    counter++;
                }
            }
            pathSum(node.left, newList, targetSum);
            pathSum(node.right, newList, targetSum);
        }

    }
}
