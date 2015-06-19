package Array.problems;

import java.util.Arrays;

/**
 * Given an array of size n, the array contains numbers in range from 0 to k-1
 * where k is a positive integer and k <= n. Find the maximum repeating number
 * in this array. For example, let k be 10 the given array be arr[] = {1, 2, 2,
 * 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum repeating number would be 2.
 * Expected time complexity is O(n) and extra space allowed is O(1).
 * Modifications to array are allowed.
 * 
 */

/*- Output
 * 
 * 
 [1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3]
 i	input[i]	k	input[i] % k	input[input[i] % k]	+k
 0	1			10		1					2			12
 1	12			10		2					2			12
 2	12			10		2					12			22
 3	2			10		2					22			32
 4	0			10		0					1			11
 5	2			10		2					32			42
 6	0			10		0					11			21
 7	2			10		2					42			52
 8	3			10		3					2			12
 9	8			10		8					3			13
 10	0			10		0					21			31
 11	9			10		9					8			18
 12	2			10		2					52			62
 13	3			10		3					12			22
 Most repeated 2

 Test case 2
 i_arr_input = new int[] { 30, 30, 30, 40, 50, 50, 60, 70, 70, 90 };
 Cannot find most frequent number .  k>n

 * 
 */
public class MostFrequentNumberInArray {

	public static void main(String args[]) {

		int[] i_arr_input = { 1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3 };
		int k = 10;

		if (i_arr_input.length >= k) {
			retrieveNthMostFrequentNumber_usingArray(i_arr_input, k);
		}

		System.out.println();
		i_arr_input = new int[] { 30, 30, 30, 40, 50, 50, 60, 70, 70, 90 };
		k = 91;

		if (i_arr_input.length >= k) {
			retrieveNthMostFrequentNumber_usingArray(i_arr_input, k);
		} else {
			System.out.println("Cannot find most frequent number .  k>n");
		}
	}

	private static void retrieveNthMostFrequentNumber_usingArray(int[] input, int k) {

		int max = -1;

		// O(n)
		System.out.println("\n" + Arrays.toString(input));
		System.out.println("i\tinput[i]\tk\tinput[i] % k\tinput[input[i] % k]\t+k");
		for (int i = 0; i < input.length; i++) {
			System.out.println(i + "\t" + input[i] + "\t\t" + k + "\t\t" + input[i] % k + "\t\t" + input[input[i] % k] + "\t\t" + (input[input[i] % k] + k));
			input[input[i] % k] += k;
			// System.out.print(input[input[i] % k]);
		}

		// O(n)
		int index = 0;
		for (int i = 0; i < input.length; i++)
			if (max < input[i]) {
				max = input[i];
				index = i;
			}

		// O(n)
		for (int i = 0; i < input.length; i++)
			input[i] = input[i] % k;

		System.out.println("Most repeated " + input[index]);

	}

}