package tree.problems.printPaths;

import java.util.LinkedList;

import tree.bst.TreeNode;

/**
 * Time complexity: O(nlgn)
 * 
 */
public class PrintAllPathsWhichSumToEqualUsingRecurcsion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n8 = new TreeNode(8);
		TreeNode n5 = new TreeNode(5, n9, n10);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7, n11, n12);
		TreeNode n4 = new TreeNode(4, n7, n8);
		TreeNode n2 = new TreeNode(2, n5, n6);
		TreeNode n1 = new TreeNode(1, n2, n4);

		MyResponseBody myResponseBody = printAllPaths(n1, 17);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

		myResponseBody = printAllPaths(n1, 12);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

		myResponseBody = printAllPaths(n1, 9);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

		myResponseBody = printAllPaths(n1, 13);
		System.out.println("\nFinal response: " + myResponseBody.finalresponse);

	}

	private static MyResponseBody printAllPaths(TreeNode node, int sum) {

		MyResponseBody response = new MyResponseBody();
		LinkedList<String> paths = null;
		MyResponseBody left, right = null;

		if (node.left == null || node.right == null) {
			paths = new LinkedList<String>();
			paths.add(node.value.toString());
			response.response = paths;
			return response;
		}

		/**
		 * Add left child
		 */
		paths = new LinkedList<String>();
		left = printAllPaths(node.left, sum);
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
		right = printAllPaths(node.right, sum);
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
