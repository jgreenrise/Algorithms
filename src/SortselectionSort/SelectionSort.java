package sort;

import java.util.Arrays;

/*- Output
 * 
 * [0, 3, 1, 0, 5, 2, 4, 5, 2]
[2, 1, 2, 1, 1, 2]
[2, 3, 5, 6, 7, 9]
At index: 1, store :0
At index: 5, store :3
At index: 2, store :1
At index: 0, store :0
At index: 8, store :5
At index: 4, store :2
At index: 6, store :4
At index: 7, store :5
At index: 3, store :2
[0, 0, 1, 2, 2, 3, 4, 5, 5]
 * 
 *
 */
public class SelectionSort {

	public static void main(String[] args) {

		int[] input = { 0, 3, 1, 0, 5, 2, 4, 5, 2 };
		System.out.println(Arrays.toString(input));
		executeSelectionSort(input);

	}

	private static void executeSelectionSort(int[] input) {

		int[] result = new int[input.length];
		int maximum = getMaxVal(input);
		int[] tmp = new int[maximum+1];

		//O(n) to create tmp array
		for (int i = 0; i < input.length; i++) {
			tmp[input[i]] = tmp[input[i]] + 1;
		}
		System.out.println(Arrays.toString(tmp));

		
		for (int i = 1; i < tmp.length; i++) {
			tmp[i] = tmp[i] + tmp[i - 1];
		}
		System.out.println(Arrays.toString(tmp));

		for (int i = 0; i < input.length; i++) {

			System.out.println("At index: " + (tmp[input[i]] - 1) + ", store :" + input[i]);
			result[tmp[input[i]] - 1] = input[i];
			tmp[input[i]] = tmp[input[i]] - 1;

		}

		System.out.println(Arrays.toString(result));
	}

	private static int getMaxVal(int[] arrayToSort) {
		int maxVal = Integer.MIN_VALUE;
		for (int i : arrayToSort) {
			if (i > maxVal) {
				maxVal = i;
			}
		}
		return maxVal;
	}

}
