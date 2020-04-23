package tree.problems.dfs;

import java.util.Stack;

public class PrintDFSTree {

    public static class Node {

        public Comparable value;
        public Node left_node, right_node;
        public boolean isVisited;

        public Node(Comparable value) {
            super();
            this.value = value;
            this.left_node = null;
            this.right_node = null;
        }

        public Node(Comparable value, Node left, Node right) {
            super();
            this.value = value;
            this.left_node = left;
            this.right_node = right;
        }

    }


    public static void main(String[] args) {

        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n2 = new Node(2, n5, n6);
        Node n4 = new Node(4, n7, n8);
        Node n1 = new Node(1, n2, n4);

		System.out.println(printdepthFirstSearch(n1));

    }

    public static StringBuilder printdepthFirstSearch(Node sourceNode) {

        Stack<Node> stack = new Stack<Node>();
        stack.add(sourceNode);
        sourceNode.isVisited = true;
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {

            Node pop = stack.pop();
            pop.isVisited = true;

            stringBuilder.append(" " + pop.value);

            if (pop.right_node != null && !pop.right_node.isVisited) {
                stack.add(pop.right_node);
            }

            if (pop.left_node != null && !pop.left_node.isVisited) {
                stack.add(pop.left_node);
            }
        }

        return stringBuilder;
    }


}
