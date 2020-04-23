package tree.problems.printPaths;

import java.util.LinkedList;

import tree.bst.MyBinaryNode;

/**
 * Time complexity: O(nlgn)
 * 
 */
public class PrintAllPathsWhichSumToEqualUsingRecurcsion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyBinaryNode n9 = new MyBinaryNode(9);
		MyBinaryNode n10 = new MyBinaryNode(10);
		MyBinaryNode n11 = new MyBinaryNode(11);
		MyBinaryNode n12 = new MyBinaryNode(12);
		MyBinaryNode n8 = new MyBinaryNode(8);
		MyBinaryNode n5 = new MyBinaryNode(5, n9, n10);
		MyBinaryNode n6 = new MyBinaryNode(6);
		MyBinaryNode n7 = new MyBinaryNode(7, n11, n12);
		MyBinaryNode n4 = new MyBinaryNode(4, n7, n8);
		MyBinaryNode n2 = new MyBinaryNode(2, n5, n6);
		MyBinaryNode n1 = new MyBinaryNode(1, n2, n4);

		MyResponseBody myResponseBody = printAllPaths(n1, 17);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

		myResponseBody = printAllPaths(n1, 12);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

		myResponseBody = printAllPaths(n1, 9);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

		myResponseBody = printAllPaths(n1, 13);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

	}

	private static MyResponseBody printAllPaths(MyBinaryNode node, int sum) {

		MyResponseBody response = new MyResponseBody();
		LinkedList<String> paths = null;
		MyResponseBody left, right = null;

		if (node.left_node == null || node.right_node == null) {
			paths = new LinkedList<String>();
			paths.add(node.value.toString());
			response.response = paths;
			return response;
		}

		/**
		 * Add left child
		 */
		paths = new LinkedList<String>();
		left = printAllPaths(node.left_node, sum);
		for (String path : left.response) {
			paths.add(path + " " + node.value.toString());

			String[] str_arr_left = path.split(" ");

			int value1 = 0;
			for (String item : str_arr_left) {
				value1 = value1 + Integer.parseInt(item);
			}

			if (value1 + Integer.parseInt(node.value.toString()) == sum) {
				response.finalresponse.add(path + " " + node.value.toString());
			}

		}

		/**
		 * Add right child
		 */
		right = printAllPaths(node.right_node, sum);
		for (String path : right.response) {
			paths.add(path + " " + node.value.toString());

			String[] str_arr = path.split(" ");

			int value1 = 0;
			for (String item : str_arr) {
				value1 = value1 + Integer.parseInt(item);
			}

			if (value1 + Integer.parseInt(node.value.toString()) == sum) {
				response.finalresponse.add(path + " " + node.value.toString());
			}
		}

		/**
		 * Add node
		 */
		paths.add(node.value.toString());
		response.response = paths;

		System.out.println(paths);

		return response;

	}
}
