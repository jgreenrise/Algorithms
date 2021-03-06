package tree.problems;

import tree.bst.TreeNode;

/*-
 * 1. make the mid element of array as root element.
 * 2. root.left - Mid from left array
 * 3. root.right = mid from right array
 * 4. Do it recursively 
 */
public class SortedArrayToBinaryTreeOfMinimumHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr_i_input = { 100, 120, 150, 170, 180, 190, 250 };
		TreeNode response = createBinaryTreeWithMinimumHeight(arr_i_input, 0, arr_i_input.length-1);
		System.out.println(response);
		
	}

	/**
	 * Time complexity: O(n)
	 */
	private static TreeNode createBinaryTreeWithMinimumHeight(int[] arr, int i_index_start, int i_index_end) {

		if (i_index_end - i_index_start < 1) {
			return new TreeNode(arr[i_index_start]);
		}

		/**
		 * Find the middle element and make it parent node
		 */
		int mid = (int) Math.floor((i_index_start + i_index_end) / 2);
		TreeNode node = new TreeNode(arr[mid]);
		
		/**
		 * Child nodes
		 */
		node.left = createBinaryTreeWithMinimumHeight(arr, i_index_start, mid - 1);
		node.right = createBinaryTreeWithMinimumHeight(arr, mid + 1, i_index_end);
		
		return node;
	}
}
