package Array.heap;

import java.util.Arrays;

public class MinHeap {

	public static void main(String[] args) {

		int[] arr_i_input = { 24, 23, 8, 22, 5, 7, 1, 3 };
		System.out.println(Arrays.toString(arr_i_input));
		buildMinHeap(arr_i_input);
		System.out.println(Arrays.toString(arr_i_input));

		// remove node from max heap: 3
		//swap(arr_i_input, 1, arr_i_input.length - 1);
		//arr_i_input[arr_i_input.length - 1] = 0;
		//siftDown(arr_i_input, 1);
		//System.out.println("After deleting node 3: " + Arrays.toString(arr_i_input));

		// remove node from max heap: 1
		swap(arr_i_input, 0, arr_i_input.length - 1);
		arr_i_input[arr_i_input.length - 1] = 0;
		siftDown(arr_i_input, 0);
		System.out.println("After deleting node 1: " + Arrays.toString(arr_i_input));
	}

	private static void buildMinHeap(int[] arr_i_input) {
		for (int i = (arr_i_input.length / 2 - 1); i >= 0; i--)
			siftDown(arr_i_input, i);

	}

	private static void siftDown(int[] arr_i_input, int i_index_parent) {

		int i_index_left_child = i_index_parent * 2 + 1;
		int i_index_right_child = i_index_parent * 2 + 2;
		int i_index_of_minimum_node = i_index_parent;

		if (i_index_left_child < arr_i_input.length && arr_i_input[i_index_left_child] < arr_i_input[i_index_parent]) {
			i_index_of_minimum_node = i_index_left_child;
		}

		if (i_index_right_child < arr_i_input.length && arr_i_input[i_index_right_child] < arr_i_input[i_index_of_minimum_node]) {
			i_index_of_minimum_node = i_index_right_child;
		}

		if (i_index_parent != i_index_of_minimum_node) {
			swap(arr_i_input, i_index_parent, i_index_of_minimum_node);
			siftDown(arr_i_input, i_index_of_minimum_node);
		} else {
			return;
		}

	}

	private static void swap(int[] arr_i_input, int i_index_left, int i_index_right) {
		int tmp = arr_i_input[i_index_left];
		arr_i_input[i_index_left] = arr_i_input[i_index_right];
		arr_i_input[i_index_right] = tmp;

	}

}
