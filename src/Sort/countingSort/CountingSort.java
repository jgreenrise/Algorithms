package Sort.countingSort;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] i_arr_input = { 3, 5, 4, 1, 4, 5};
		int max = 7;

		System.out.println("Before sorting: " + Arrays.toString(i_arr_input));
		executeCountingSort(i_arr_input);
		System.out.println("After sorting: " + Arrays.toString(i_arr_input));

	}

	private static void executeSelectionSort(int[] i_arr_input) {

		for (int i = 0; i < i_arr_input.length; i++) {
			for (int j = i + 1; j < i_arr_input.length; j++) {

				if (i_arr_input[i] > i_arr_input[j]) {
					int tmp = i_arr_input[i];
					i_arr_input[i] = i_arr_input[j];
					i_arr_input[j] = tmp;
				}
			}
		}
	}

}
