package sort.mergeSort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		/**
		 * Input: Even number of elements
		 */

		//System.out.println("EVEN NUMBER OF ELEMENTS");
		int[] input = new int[] { 10, 1, 4, 90, 43, 45, 50, 64 };
		
		//System.out.println("EVEN NUMBER OF ELEMENTS, with dups");
		//int[] input = new int[] { 10, 1, 4, 90, 43, 90, 50, 64 };

		System.out.println("Before sorting: " + Arrays.toString(input));
		mergeSort(input);
		System.out.println("After sorting: " + Arrays.toString(input));

		/**
		 * Input: Odd number of elements
		 */
		System.out.println("\nODD NUMBER OF ELEMENTS");
		input = new int[] { 10, 1, 4, 90, 43, 45, 45 };

		System.out.println("Before sorting: " + Arrays.toString(input));
		mergeSort(input);
		System.out.println("After sorting: " + Arrays.toString(input));

	}

	private static void mergeSort(int[] input) {
		// TODO Auto-generated method stub

		if (input.length > 1) {
			
			System.out.println("");

			// split array into two halves
			int[] left = leftSubList(input);
			int[] right = rightSubList(input);

			mergeSort(left);
			mergeSort(right);

			merge(input, left, right);
		}

	}

	private static void merge(int[] input, int[] left, int[] right) {
		
		System.out.println("\nBS: "+Arrays.toString(input));

		int i_counter_left = 0;
		int i_counter_right = 0;

		for (int i = 0; i < input.length; i++) {

			if (i_counter_right == right.length) {
				input[i] = left[i_counter_left];
				i_counter_left++;
			} else if (i_counter_left == left.length) {
				input[i] = right[i_counter_right];
				i_counter_right++;
			} else if (left[i_counter_left] <= right[i_counter_right]) {
				input[i] = left[i_counter_left];
				i_counter_left++;
			} else if (left[i_counter_left] > right[i_counter_right]) {
				input[i] = right[i_counter_right];
				i_counter_right++;
			}
		}
		
		System.out.println("AS: "+Arrays.toString(input));

	}

	/**
	 * @param input
	 *            : Input array
	 * @return: Output array which is half the size of input array from index
	 *          (input.lenght/2 .. input.length)
	 */
	private static int[] rightSubList(int[] input) {

		int i_size_of_input_array = input.length;
		int i_size_of_right_sublist = i_size_of_input_array - (i_size_of_input_array / 2);

		int[] i_arr_response = new int[i_size_of_right_sublist];

		for (int i = 0; i < i_size_of_right_sublist; i++)
			i_arr_response[i] = input[i_size_of_input_array - (i_size_of_right_sublist) + i];

		System.out.println("Right Sublist: " + Arrays.toString(i_arr_response));
		return i_arr_response;
	}

	/**
	 * @param input
	 *            : Input array
	 * @return: Output array which is half the size of input array from index
	 *          (0..input.lenght/2)
	 */
	private static int[] leftSubList(int[] input) {

		int[] i_arr_response = new int[input.length / 2];

		for (int i = 0; i < (input.length / 2); i++)
			i_arr_response[i] = input[i];

		System.out.println("Left Sublist: " + Arrays.toString(i_arr_response));
		return i_arr_response;
	}

}