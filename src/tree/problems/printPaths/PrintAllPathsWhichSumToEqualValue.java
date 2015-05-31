package graph.problems;

import graph.directed.bfs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * Output
 * 
 * {1=[1], 2=[1,2, 2], 4=[1,4, 4], 5=[1,2,5, 2,5, 5], 6=[1,2,6, 2,6], 7=[1,4,7,
 * 4,7, 7], 8=[1,4,8, 4,8], 9=[1,2,5,9, 2,5,9, 5,9], 10=[1,2,5,10, 2,5,10,
 * 5,10], 11=[1,4,7,11, 4,7,11, 7,11], 12=[1,4,7,12, 4,7,12, 7,12]}
 * 
 */
public class PrintAllPathsWhichSumToEqualValue {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);

		n1.addAssosciatedNodes(n2);
		n1.addAssosciatedNodes(n4);

		n2.addAssosciatedNodes(n5);
		n2.addAssosciatedNodes(n6);

		n5.addAssosciatedNodes(n9);
		n5.addAssosciatedNodes(n10);

		n4.addAssosciatedNodes(n7);
		n4.addAssosciatedNodes(n8);

		n7.addAssosciatedNodes(n11);
		n7.addAssosciatedNodes(n12);

		printPaths(n1, 12);
		
		printPaths(n1, 13);

	}

	public static Node printPaths(Node node, int sum) {

		HashMap<Integer, LinkedList<String>> map = new HashMap<>();
		LinkedList<String> child_paths = null;
		StringBuilder sbr = new StringBuilder();
		Stack<Node> stack = new Stack<Node>();

		if (node == null)
			return null;

		if (node.adjacentNodes == null)
			return node;

		stack.add(node);

		child_paths = new LinkedList<>();
		child_paths.add(String.valueOf(node.value));
		map.put(node.value, child_paths);

		while (!stack.isEmpty()) {

			node = (Node) stack.pop();

			for (Node tmp : node.adjacentNodes) {
				stack.add(tmp);

				child_paths = new LinkedList<>();
				for (String path : map.get(node.value))
					child_paths.add(path + " " + String.valueOf(tmp.value));

				if (tmp.adjacentNodes != null && (tmp.adjacentNodes).size() > 0) {
					child_paths.add(String.valueOf(tmp.value));
				}

				map.put(tmp.value, child_paths);
			}
		}

		for (Entry<Integer, LinkedList<String>> entry : map.entrySet()) {
			int result = 0;
			for (String paths : entry.getValue()) {

				result = 0;
				String arr[] = paths.split(" ");

				for (int i = 0; i < arr.length; i++) {
					result = result + Integer.parseInt(arr[i].trim());
				}
				
				if(result == sum){
					System.out.println(paths);
				}
			}
		}

		System.out.println(map);
		return node;

	}
}
