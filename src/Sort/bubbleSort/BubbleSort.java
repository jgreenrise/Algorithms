package sort.bubbleSort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String args[]) {

		int[] input = { 50, 30, 20, 90, 70 };
		System.out.println(Arrays.toString(input));
		executeBubbleSort(input);
		System.out.println(Arrays.toString(input));

	}

	/**
	 * Time complexity: O(n2)
	 */
	public static void executeBubbleSort(int[] A) {

		int tmp;
		boolean flag = true;

		while (flag) {

			// Assuming no swap will take place
			flag = false;

			for (int i = 0; i < A.length - 1; i++) {

				/**
				 * Change to < for descending order
				 */
				if (A[i] > A[i + 1]) { 
					tmp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = tmp;

					// Indicating swap took place
					flag = true;
				}

			}

		}

	}
}
