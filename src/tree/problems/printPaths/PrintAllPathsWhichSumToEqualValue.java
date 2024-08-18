package tree.problems.printPaths;

import graph.directed.C_bfs.CustomTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
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

		CustomTreeNode n1 = new CustomTreeNode(1);
		CustomTreeNode n2 = new CustomTreeNode(2);
		CustomTreeNode n4 = new CustomTreeNode(4);
		CustomTreeNode n5 = new CustomTreeNode(5);
		CustomTreeNode n6 = new CustomTreeNode(6);
		CustomTreeNode n7 = new CustomTreeNode(7);
		CustomTreeNode n8 = new CustomTreeNode(8);
		CustomTreeNode n9 = new CustomTreeNode(9);
		CustomTreeNode n10 = new CustomTreeNode(10);
		CustomTreeNode n11 = new CustomTreeNode(11);
		CustomTreeNode n12 = new CustomTreeNode(12);

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

	public static CustomTreeNode printPaths(CustomTreeNode node, int sum) {

		/**
		 * Stores Node, assosciated paths
		 */
		HashMap<Integer, LinkedList<String>> map = new HashMap<>();
		LinkedList<String> child_paths = null;
		StringBuilder sbr = new StringBuilder();
		Stack<CustomTreeNode> stack = new Stack<CustomTreeNode>();

		if (node == null)
			return null;

		if (node.adjacentNodes == null)
			return node;

		stack.add(node);

		child_paths = new LinkedList<>();
		child_paths.add(String.valueOf(node.value));
		map.put(node.value, child_paths);

		while (!stack.isEmpty()) {

			node = (CustomTreeNode) stack.pop();

			for (CustomTreeNode tmp : node.adjacentNodes) {
				stack.add(tmp);

				child_paths = new LinkedList<>();
				for (String path : map.get(node.value))
					child_paths.add(path + " " + String.valueOf(tmp.value));

				if (tmp.adjacentNodes != null && (tmp.adjacentNodes).size() > 0) 
					child_paths.add(String.valueOf(tmp.value));

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
