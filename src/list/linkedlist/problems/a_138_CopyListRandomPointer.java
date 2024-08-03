import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
<<<<<<<< HEAD:src/a_0138_CopyListRandomPointer.java
public class a_0138_CopyListRandomPointer {
========
public class a_138_CopyListRandomPointer {
>>>>>>>> 538c1fccf32dce871c338b5b51613fc7da6abca6:src/list/linkedlist/problems/a_138_CopyListRandomPointer.java

    public static void main(String[] args) {

        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node13.random = node7;
        node10.random = node11;
        node11.random = node1;
        node1.random = node7;

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

<<<<<<<< HEAD:src/a_0138_CopyListRandomPointer.java
        a_0138_CopyListRandomPointer class1 = new a_0138_CopyListRandomPointer();
========
        a_138_CopyListRandomPointer class1 = new a_138_CopyListRandomPointer();
>>>>>>>> 538c1fccf32dce871c338b5b51613fc7da6abca6:src/list/linkedlist/problems/a_138_CopyListRandomPointer.java

        /*System.out.println("Hashmap and iteration: " + class1.printLL(class1.iteration(node7)));

        System.out.println("Recursive: " + class1.printLL(class1.copyRandomListRecursive(node7)));

        System.out.println("Iteration - recursive: " + class1.printLL(class1.iterationRecursive(node7)));*/

        System.out.println("Weaving: " + class1.printLL(class1.copyRandomListv2(node7)));
    }

    public Node copyRandomListv2(Node head) {

        Node dummy = new Node(-1);
        dummy.next = head;
        head = dummy;

        Node origHead = head;
        head = head.next;
        // 1. Insert a new node after each node, Only assign next ptr
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next != null ? head.next.next : null;
        }

        // 2 Assign random pt to the new node.
        head = origHead;
        head = head.next;
        while (head != null) {
            if (head.next != null && head.random != null) {
                head.next.random = head.random.next != null ? head.random.next : null;
            }
            head = head.next.next != null ? head.next.next : null;
        }

        // 3 Remove orignal nodes
        head = origHead;
        Node out = head;
        while (head != null) {
            if (head.next != null) {
                head.next = head.next.next;
                head = head.next != null ? head.next : null;
            } else {
                head = null;
            }
        }

        return origHead;
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }


        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave list
        Node oldList = head;        // a> b >c
        Node newList = head.next;   // a#> b# >c#
        Node out = head.next;
        while (oldList != null) {

            oldList.next = oldList.next.next;
            newList.next = (newList.next != null) ? newList.next.next : null;
            oldList = oldList.next;
            newList = newList.next;
        }

        return out;


    }

    Map<Node, Node> hashMap2 = new HashMap<>();

    public Node iterationRecursive(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(head.val);
        hashMap2.put(head, newNode);

        while (oldNode != null) {
            newNode.next = getClonedNode(oldNode.next);
            newNode.random = getClonedNode(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return hashMap2.get(head);
    }

    private Node getClonedNode(Node next) {

        if (next == null)
            return null;
        if (hashMap2.containsKey(next)) {
            return hashMap2.get(next);
        } else {
            Node nn = new Node(next.val);
            hashMap2.put(next, nn);
            return nn;
        }
    }

    Map<Node, Node> hashMap = new HashMap<>();

    /**
     * RECURSIVE
     */
    public Node copyRandomListRecursive(Node node) {

        if (node == null) {
            return null;
        }

        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }


        Node nn = new Node(node.val);
        hashMap.put(node, nn);

        nn.next = copyRandomListRecursive(node.next);
        nn.random = copyRandomListRecursive(node.random);

        return nn;

    }

    private Node printLL(Node node) {

        while (node.next != null) {
            System.out.print(node.val + " > ");
            node = node.next;
        }
        System.out.println(node.val);
        return node;

    }

    /**
     * HASH TABLE
     */
    public Node usingHashTable(Node head) {

        Node orig = head;
        Map<Node, Node> map = new HashMap();

        Node out = null;
        Node origOut = null;

        while (head != null) {
            if (out == null) {
                out = new Node(head.val);
                origOut = out;
            } else {
                Node tmp = new Node(head.val);
                out.next = tmp;
                out = out.next;
            }

            //map.put(head.val, out);
            map.put(head, out);
            head = head.next;
        }

        // Rollback to starting position
        head = orig;
        out = origOut;
        origOut = out;

        while (head != null && out != null) {
            if (head.random != null) {
                Node childNode = map.get(head.random);
                out.random = childNode;
            }
            head = head.next;
            out = out.next;
        }

        return origOut;
    }

    public static class Node {

        public int val;
        public Node next;
        public Node random;
        public int index;

        public Node() {
            val = 0;
            next = null;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int[] nums) {
            Node out = new Node(nums[0]);
            for (int i = 0; i < nums.length; i++) {
                Node nn = new Node(nums[i]);

            }

        }

        public static void printLL(Node node) {
            while (node.next != null) {
                System.out.print(node.val + " > ");
                node = node.next;
            }
            System.out.println(node.val);
        }


    }

}
