package Array.heap;

import java.util.Arrays;

/**
 * Max heap using array
 */

/*-
 *
 * 
Input array 		[4, 1, 3, 2, 16, 9, 10, 14, 8, 7]
Max heap 		[16, 14, 10, 8, 7, 9, 3, 2, 4, 1]

New array 		[16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 0]
Value added (12): 	[16, 14, 10, 8, 12, 9, 3, 2, 4, 1, 7]
New array 		[16, 14, 10, 8, 12, 9, 3, 2, 4, 1, 7, 0]
Value added (30): 	[30, 14, 16, 8, 12, 10, 3, 2, 4, 1, 7, 9]

Before deleting 16 	[30, 14, 16, 8, 12, 10, 3, 2, 4, 1, 7, 9]
After deleting 16 	[30, 14, 10, 8, 12, 9, 3, 2, 4, 1, 7, 0]
Before deleting 30 	[30, 14, 10, 8, 12, 9, 3, 2, 4, 1, 7, 0]
After deleting 16 	[14, 12, 10, 8, 7, 9, 3, 2, 4, 1, 0, 0]
 *
 */
public class MaxHeap {

	/**
	 * Building a max heap
	 * http://homepages.ius.edu/rwisman/C455/html/notes/Chapter6/BldHeap.htm
	 */
	public static int[] Arr = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };

	public static void main(String[] args) {

		System.out.println("Input array \t\t" + Arrays.toString(Arr));

		// Looping though index (n/2-1 [Index is 0 based] to [Index 0])
		for (int i = (Arr.length / 2 - 1); i >= 0; i--)
			buildMaxHeap(Arr, i);

		System.out.println("Max heap \t\t" + Arrays.toString(Arr));

		/**
		 * ADD TO HEAP
		 */

		// Increasing array length by 1
		Arr = Arrays.copyOf(Arr, 11);
		System.out.println("\nNew array \t\t" + Arrays.toString(Arr));
		// Adding value 12 at index 10
		Arr[10] = 12;
		siftUp(Arr);
		System.out.println("Value added (12): \t" + Arrays.toString(Arr));
		// Increasing array length by 1
		Arr = Arrays.copyOf(Arr, 12);
		System.out.println("New array \t\t" + Arrays.toString(Arr));
		// Adding value 30 at index 11
		Arr[11] = 30;
		siftUp(Arr);
		System.out.println("Value added (30): \t" + Arrays.toString(Arr));

		/**
		 * DELETE FROM HEAP
		 */
		// delete 16 (swap it with last element)
		System.out.println("\nBefore deleting 16 \t" + Arrays.toString(Arr));
		int i_index_of_element_to_be_removed = 0;
		i_index_of_element_to_be_removed = 2;
		swap(i_index_of_element_to_be_removed, Arr.length - 1);
		Arr[Arr.length - 1] = 0;
		siftDown(Arr, i_index_of_element_to_be_removed);
		System.out.println("After deleting 16 \t" + Arrays.toString(Arr));
		
		// delete root node 30
		System.out.println("Before deleting 30 \t" + Arrays.toString(Arr));
		i_index_of_element_to_be_removed = 0;
		swap(i_index_of_element_to_be_removed, Arr.length - 1);
		Arr[Arr.length - 1] = 0;
		siftDown(Arr, i_index_of_element_to_be_removed);
		System.out.println("After deleting 16 \t" + Arrays.toString(Arr));

	}

	/**
	 * Use sift up for adding new elements logn
	 */
	private static void siftUp(int[] input) {
		int index = input.length - 1;
		while (index > 0) {
			int parent_index = (index - 1) / 2;
			if (input[parent_index] < input[index]) {
				swap(index, parent_index);
				index = parent_index;
			} else
				break;
		}
	}

	/**
	 * Use sift down for deleting element in an array.
	 * logn
	 */
	private static void siftDown(int[] input, int i_start_index) {
		int index = i_start_index;
		while (index < input.length - 1) {

			int i_left_child_index = (2 * index) + 1;
			int i_right_child_index = (2 * index) + 2;
			int i_index_largest_number = i_start_index;

			if (i_left_child_index < input.length
					&& input[i_start_index] < input[i_left_child_index])
				i_index_largest_number = i_left_child_index;

			if (i_right_child_index < input.length
					&& input[i_right_child_index] > input[i_index_largest_number])
				i_index_largest_number = i_right_child_index;
			
			if (i_start_index != i_index_largest_number) {
				swap(i_start_index, i_index_largest_number);
				siftDown(input, i_index_largest_number);
			} else
				break;
		}
	}

	/**
	 * O(n)
	 */
	private static void buildMaxHeap(int[] input, int index) {

		/**
		 * Left child
		 */
		int left = 2 * index + 1;

		/**
		 * Right child
		 */
		int right = 2 * index + 2;
		int largest_number = index;

		if (left < input.length && input[left] > input[index])
			largest_number = left;

		if (right < input.length && input[right] > input[largest_number])
			largest_number = right;

		if (input[largest_number] != input[index]) {
			swap(largest_number, index);

			/**
			 * Sift down [This makes sure that all child, grandchildren nodes...
			 * nodes are correctly placed]
			 */
			buildMaxHeap(Arr, (largest_number));
		}
	}

	private static void swap(int i, int largest) {
		int t = Arr[i];
		Arr[i] = Arr[largest];
		Arr[largest] = t;
	}

}
