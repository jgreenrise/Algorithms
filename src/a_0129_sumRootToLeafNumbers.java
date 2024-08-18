import java.util.ArrayList;
import java.util.List;
import tree.bst.TreeNode;

public class a_0129_sumRootToLeafNumbers {
    int total = 0;

    public int sumNumbers(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left == null && root.right != null) {
            sumNumbersv3(root.right, root.val);
        } else if (root.left != null && root.right == null) {
            sumNumbersv3(root.left, root.val);
        } else {
            sumNumbersv3(root.left, root.val);
            sumNumbersv3(root.right, root.val);
        }
        return total;
    }

    public void sumNumbersv3(TreeNode root, int num) {

        if (root.left == null && root.right == null) {
            total += num * 10 + root.val;
            //buffer += Integer.parseInt(String.valueOf(num) + root.val);
            //buffer.add(num * 10 + root.val);
            // Learning 1: buffer.add(int(String.valueOf(num +""+ root.val)));

        } else if (root.left != null && root.right == null) {
            //sumNumbersv2(root.left, buffer, Integer.parseInt(String.valueOf(num) + root.val));
            sumNumbersv3(root.left, num * 10 + root.val);
        } else if (root.left == null && root.right != null) {
            sumNumbersv3(root.right, num * 10 + root.val);
        } else {
            sumNumbersv3(root.left, num * 10 + root.val);
            sumNumbersv3(root.right, num * 10 + root.val);
        }

    }

    public int sumNumbersUsingBuffer(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val;
        }

        // Learning 2 Integer buffer = new Integer(0);
        List<Integer> buffer = new ArrayList();
        if (root.left == null && root.right != null) {
            sumNumbersv2(root.right, buffer, root.val);
        } else if (root.left != null && root.right == null) {
            sumNumbersv2(root.left, buffer, root.val);
        } else {
            sumNumbersv2(root.left, buffer, root.val);
            sumNumbersv2(root.right, buffer, root.val);
        }

        //return buffer;
        int total = 0;
        for (Integer a : buffer) {
            total = total + a;
        }
        return total;

    }

    public void sumNumbersv2(TreeNode root, List<Integer> buffer, int num) {

        if (root.left == null && root.right == null) {
            System.out.println(buffer);
            //buffer += Integer.parseInt(String.valueOf(num) + root.val);
            buffer.add(num * 10 + root.val);
            // Learning 1: buffer.add(int(String.valueOf(num +""+ root.val)));

        } else if (root.left != null && root.right == null) {
            //sumNumbersv2(root.left, buffer, Integer.parseInt(String.valueOf(num) + root.val));
            sumNumbersv2(root.left, buffer, num * 10 + root.val);
        } else if (root.left == null && root.right != null) {
            sumNumbersv2(root.right, buffer, num * 10 + root.val);
        } else {
            sumNumbersv2(root.left, buffer, num * 10 + root.val);
            sumNumbersv2(root.right, buffer, num * 10 + root.val);
        }

    }
}
