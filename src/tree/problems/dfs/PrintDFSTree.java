package tree.problems.dfs;

import tree.bst.MyBinaryNode;

import java.util.Stack;

public class PrintDFSTree {

    public static void main(String[] args) {

        MyBinaryNode n5 = new MyBinaryNode(5);
        MyBinaryNode n6 = new MyBinaryNode(6);
        MyBinaryNode n7 = new MyBinaryNode(7);
        MyBinaryNode n8 = new MyBinaryNode(8);
        MyBinaryNode n2 = new MyBinaryNode(2, n5, n6);
        MyBinaryNode n4 = new MyBinaryNode(4, n7, n8);
        MyBinaryNode n1 = new MyBinaryNode(1, n2, n4);

		System.out.println(printdepthFirstSearch(n1));

    }

    public static StringBuilder printdepthFirstSearch(MyBinaryNode sourceNode) {

        Stack<MyBinaryNode> stack = new Stack<MyBinaryNode>();
        stack.add(sourceNode);
        sourceNode.isVisited = true;
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {

            MyBinaryNode pop = stack.pop();
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
