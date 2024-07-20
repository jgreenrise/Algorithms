import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class a_0117_populatingNextRightpointers {

    public Node connect(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll != null) {
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                    if (prevNode != null) prevNode.next = poll;
                    prevNode = poll;
                }
                if (i == size - 1) prevNode = null;
            }
        }

        return root;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}
