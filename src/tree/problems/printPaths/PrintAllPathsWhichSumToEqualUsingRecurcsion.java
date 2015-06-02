package tree.problems.printPaths;

import java.util.LinkedList;

import tree.bst.BinaryNode;

/**
 * Time complexity: O(nlgn)
 */
public class PrintAllPathsWhichSumToEqualUsingRecurcsion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryNode n9 = new BinaryNode(9);
		BinaryNode n10 = new BinaryNode(10);
		BinaryNode n11 = new BinaryNode(11);
		BinaryNode n12 = new BinaryNode(12);
		BinaryNode n8 = new BinaryNode(8);
		BinaryNode n5 = new BinaryNode(5, n9, n10);
		BinaryNode n6 = new BinaryNode(6);
		BinaryNode n7 = new BinaryNode(7, n11, n12);
		BinaryNode n4 = new BinaryNode(4, n7, n8);
		BinaryNode n2 = new BinaryNode(2, n5, n6);
		BinaryNode n1 = new BinaryNode(1, n2, n4);

		ResponseBody responseBody = printAllPaths(n1, 17);
		System.out.println("\nFinal response: "+responseBody.finalresponse);
		
		responseBody = printAllPaths(n1, 12);
		System.out.println("\nFinal response: "+responseBody.finalresponse);
		
		responseBody = printAllPaths(n1, 9);
		System.out.println("\nFinal response: "+responseBody.finalresponse);
		
		responseBody = printAllPaths(n1, 13);
		System.out.println("\nFinal response: "+responseBody.finalresponse);
		
	}

	private static ResponseBody printAllPaths(BinaryNode node, int sum) {

		ResponseBody response = new ResponseBody();
		LinkedList<String> paths = null;
		ResponseBody left, right = null;

		if (node.left_node == null || node.right_node == null) {
			paths = new LinkedList<String>();
			paths.add(node.element.toString());
			response.response = paths;
			return response;
		}

		/**
		 * Add left child
		 */
		paths = new LinkedList<String>();
		left = printAllPaths(node.left_node, sum);
		for (String path : left.response) {
			paths.add(path + " " + node.element.toString());

			String[] str_arr_left = path.split(" ");

			int value1 = 0;
			for (String item : str_arr_left) {
				value1 = value1 + Integer.parseInt(item);
			}

			if (value1 + Integer.parseInt(node.element.toString()) == sum) {
				response.finalresponse.add(path + " " + node.element.toString());
			}

		}

		/**
		 * Add right child
		 */
		right = printAllPaths(node.right_node, sum);
		for (String path : right.response) {
			paths.add(path + " " + node.element.toString());
			
			String[] str_arr = path.split(" ");
			
			int value1 = 0;
			for (String item : str_arr) {
				value1 = value1 + Integer.parseInt(item);
			}

			if (value1 + Integer.parseInt(node.element.toString()) == sum) {
				response.finalresponse.add(path + " " + node.element.toString());
			}
		}

		/**
		 * Add node
		 */
		paths.add(node.element.toString());
		response.response = paths;

		System.out.println(paths);

		return response;

	}
}
