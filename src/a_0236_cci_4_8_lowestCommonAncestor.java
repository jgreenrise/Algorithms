import tree.bst.TreeNode;

public class a_0236_cci_4_8_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        boolean isMatchFound = false;
        Node left = buildLL(root, p, isMatchFound);

        isMatchFound = false;
        Node right = buildLL(root, q, isMatchFound);

        int prevCA = 0;
        while (left != null && right != null && left.val == right.val) {
            prevCA = left.val;
            left = left.next;
            right = right.next;
        }
        return new TreeNode(prevCA);

    }

    public Node buildLL(TreeNode node, TreeNode r, boolean isMatchFound) {

        if (node == null || isMatchFound)
            return null;

        if (node.val == r.val) {
            isMatchFound = true;
            return new Node(node.val);
        } else {

            Node left = buildLL(node.left, r, isMatchFound);
            Node right = buildLL(node.right, r, isMatchFound);

            if (left != null) {
                Node newNode = new Node(node.val);
                newNode.next = left;
                return newNode;
            } else if (right != null) {
                Node newNode = new Node(node.val);
                newNode.next = right;
                return newNode;
            } else {
                return null;
            }
        }
    }

    public class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
