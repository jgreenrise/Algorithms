package tree.problems;

import java.util.Random;

public class RandomTree {
    // Individual node of the tree
    private class Node {
        Node left;
        Node right;
        int val;
        int children;
    }

    // The root of the tree
    private Node root;
    private Random rand;

    public RandomTree() {
        rand = new Random();
    }

    // This is for the tests
    public RandomTree(long seed) {
        rand = new Random(seed);
    }

    // Recursively traverse the tree to find the right place for the node in
    // order
    public void addNode(int val) {
        Node n = new Node();
        n.val = val;
        if (root == null) {
            root = n;
            return;
        }

        // Recursive call
        addNode(root, n);
    }

    // Recursive method for adding a node
    private void addNode(Node curr, Node n) {
        // We are definitely adding the node to this subtree, so go ahead and
        // increment curr.children
        curr.children++;

        // Go left if its smaller and right if its greater than or equal
        if (n.val < curr.val) {
            if (curr.left == null) curr.left = n;
            else addNode(curr.left, n);
        } else {
            if (curr.right == null) curr.right = n;
            else addNode(curr.right, n);
        }
    }

    public void deleteNode(int val) {
        throw new UnsupportedOperationException("deleteNode() is not implemented");
    }

    // Return each node with probability 1/N
    public int getRandomNode() {
        if (root == null) throw new NullPointerException();

        // This is an index of a node in the tree. Indices go in sorted order.
        int count = rand.nextInt(root.children + 1);
        return getRandomNode(root, count);
    }

    private int getRandomNode(Node curr, int count) {
        if (count == children(curr.left)) return curr.val;
        if (count < children(curr.left)) return getRandomNode(curr.left, count);
        return getRandomNode(curr.right, count - children(curr.left) - 1);
    }

    private int children(Node n) {
        if (n == null) return 0;
        return n.children + 1;
    }

    public int getRandomNodeMethod2() {
        if (root == null) throw new NullPointerException();
        return getRandomNodeMethod2(root);
    }

    private int getRandomNodeMethod2(Node node) {

        if(node.left == null && node.right == null){
            return node.val;
        }

        int rand = new Random().nextInt(node.children);;

        if(node.left.children+1 == rand){
            return node.val;
        }else if(rand < node.left.children+1){
            return getRandomNodeMethod2(node.left);
        }else{
            return getRandomNodeMethod2(node.right);
        }

    }

    // Sample test cases
    // Generates the tree:
    //        4
    //      /   \
    //     2     6
    //    / \   / \
    //   1   3 5   7

    public static void main(String[] args) {


        RandomTree t = new RandomTree(0);
        t.addNode(4);
        t.addNode(2);
        t.addNode(6);
        t.addNode(1);
        t.addNode(3);
        t.addNode(5);
        t.addNode(7);

        System.out.println(t.getRandomNode());

        assert t.getRandomNode() == 6;
        assert t.getRandomNode() == 3;
        assert t.getRandomNode() == 5;
        assert t.getRandomNode() == 3;
        assert t.getRandomNode() == 5;
        assert t.getRandomNode() == 1;
        System.out.println("Passed all tests");

        for (int i = 0; i < 100; i++) {
            System.out.println(t.getRandomNodeMethod2());
        }
    }
}
