package Array.problems;

import java.util.HashSet;

/**
 * Given an array of positive integers. All numbers occur even number of times
 * except one number which occurs odd number of times. Find the number in O(n)
 * time & constant space.
 * 
 * Example: I/P = [1, 2, 3, 2, 3, 1, 3] O/P = 3
 * 
 */

public class FindNumberOccuringOddNumberOfTimes {

	public static void main(String[] args) {

		// int[] arr_i_input = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int[] arr_i_input = { 1, 2, 3, 2, 3, 1, 3 };

		// USing XOR
		findNumberOccuringOddNumberOfTimes(arr_i_input);

		// Using partial counting sort
		findNumberOccuringOddNumberOfTimes_method2(arr_i_input);

		// Using hashset
		findNumberOccuringOddNumberOfTimes_hashset(arr_i_input);
	}

	public static void findNumberOccuringOddNumberOfTimes_hashset(int[] arr_i_input) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr_i_input.length; i++) {

			if (i == 0) {
				set.add(arr_i_input[i]);
			} else {

				if (set.contains(arr_i_input[i])) {
					set.remove(arr_i_input[i]);
				} else {
					set.add(arr_i_input[i]);
				}
			}
		}

		System.out.println(set.iterator().next());

	}

	private static void findNumberOccuringOddNumberOfTimes_method2(int[] arr_i_input) {

		int max = 0;
		int[] tmp = null;

		for (int i = 0; i < arr_i_input.length; i++)
			if (max < arr_i_input[i]) {
				max = arr_i_input[i];
			}

		// Adding values to tmp array
		tmp = new int[max + 1];
		for (int i = 0; i < arr_i_input.length; i++)
			tmp[arr_i_input[i]] = tmp[arr_i_input[i]] + 1;

		// Retrieving output from tmp array
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] != 0) {
				if (tmp[i] % 2 != 0) {
					System.out.println(i);
				}
			}

		}

	}

	public static void findNumberOccuringOddNumberOfTimes(int[] arr_i_input) {

		int response = 0;

		for (int i = 0; i < arr_i_input.length; i++) {
			// System.out.println(arr_i_input[i]);
			// System.out.println(response);
			// System.out.println(response ^ arr_i_input[i]);
			response = response ^ arr_i_input[i];
		}

		System.out.println(response);

	}

}
