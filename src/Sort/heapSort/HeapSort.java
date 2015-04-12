package sort.heapSort;

import java.util.Arrays;

/**
 * O/p
 * Before sorting: 	[18, 16, 17, 14, 11, 12, 15, 13]
Max heap 		[18, 16, 17, 14, 11, 12, 15, 13]
After sorting: 		[11, 12, 13, 14, 15, 16, 17, 18]
 *
 */
public class HeapSort {

	public static int[] i_arr_input = { 18, 16, 17, 14, 11, 12, 15, 13 };

	public static void main(String[] args) {
		System.out.println("Before sorting: \t" + Arrays.toString(i_arr_input));

		// Looping though index (n/2-1 [Index is 0 based] to [Index 0])
		for (int i = (i_arr_input.length / 2 - 1); i >= 0; i--)
			buildMaxHeap(i_arr_input, i);
		
		System.out.println("Max heap \t\t" + Arrays.toString(i_arr_input));
		
		// Execute heap sort
		executeHeapSort(i_arr_input);

		System.out.println("After sorting: \t\t" + Arrays.toString(i_arr_input));
	}
	
	public static void executeHeapSort(int [] input){

		int i_counter= input.length-1;		// F 8
		int i_heap_size = input.length;		// F 8

		while(i_counter >= 0){
			swap(0, i_counter);				// F 13 becomes root
			i_heap_size = i_heap_size - 1;	// F 7 (So we have 8 elements in heap)
			siftDown(input, i_heap_size);				
			i_counter = i_counter -1;
		}
		
	}

	private static void siftDown(int [] input, int i_heap_Size ){
		
		int i = 0;

		while(i < i_heap_Size){							// F	0 < 7
			int i_index_left_child = (2*i)+1; 			// F	1
			int i_index_right_child = (2*i)+2;			// F	2
			int i_index_largest_element = i;			// F	0

			// Comparing with left child
			if(i_index_left_child < i_heap_Size && input[i_index_left_child] > input[i_index_largest_element]){
				i_index_largest_element = i_index_left_child;
			}

			// Comparing with right child
			if(i_index_right_child < i_heap_Size && input[i_index_right_child] > input[i_index_largest_element]){
				i_index_largest_element = i_index_right_child;
			}

			if(i != i_index_largest_element){
				swap(i, i_index_largest_element);
				i = i_index_largest_element;
			}else{
				break;
			}
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
			buildMaxHeap(input, (largest_number));
		}
	}

	private static void swap(int i, int largest) {
		int t = i_arr_input[i];
		i_arr_input[i] = i_arr_input[largest];
		i_arr_input[largest] = t;
	}

}
