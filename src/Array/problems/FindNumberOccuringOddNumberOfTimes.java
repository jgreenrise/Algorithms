package Array.problems;

import java.util.HashMap;
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
		//int[] arr_i_input = { 1, 2, 3, 2, 3, 1, 3 };
		int[] arr_i_input = { 4,1,2,1,2};

		// INt array
		System.out.println(singleNumber(arr_i_input));

		// USing XOR
		findNumberOccuringOddNumberOfTimes(arr_i_input);

		// Using hashset
		findNumberOccuringOddNumberOfTimes_hashset(arr_i_input);

		// Using HashMap
		findNumberOccuringOddNumberOfTimes_hashMap(arr_i_input);*/
	}

	public static int singleNumber(int[] nums) {

		if(nums.length == 1){
			return nums[0];
		}

		// 1. Loop through elements
		for(int i =0; i < nums.length; i++){

			if(nums[i] == Integer.MIN_VALUE){
				continue;
			}

			// 2. save item at index i
			int item = nums[i];
			nums[i] = 1;

			for(int k = i+1; k < nums.length; k++){
				if(nums[k] == item){

					// 3. If equal to ITEM, assign MIN value
					nums[k] = Integer.MIN_VALUE;

					// 4. Increase counter at Index I and not K
					nums[i]++;
				}
			}

			// 5 Check item at index has odd number of elments
			if(nums[i]%2 != 0){
				return item;
			}

		}

		return 0;

	}

	/**
	 * 
	 * TIME COMPLEXITY: 0(n)
	 * 
	 * Add elements to hashmap, if they don't exist in map. If elements already
	 * exist, remove it from the last. With this approach, we have map with odd
	 * number of times.
	 */
	public static void findNumberOccuringOddNumberOfTimes_hashMap(int[] input) {

		HashMap map = new HashMap<>();

		for (int i = 0; i < input.length; i++) {

			int value = 0;

			if (map.containsKey(input[i])) {
				map.remove(input[i]);
			} else {
				map.put(input[i], input[i]);
			}

		}

		System.out.println("Using hashmap: " + map.entrySet().iterator().next());

	}

	/**
	 * TIME COMPLEXITY: 0(n)
	 * 
	 * Add elements to hashset, if they don't exist in map. If elements already
	 * exist, remove it from the last. With this approach, we have map with odd
	 * number of times.
	 */
	public static void findNumberOccuringOddNumberOfTimes_hashset(int[] arr_i_input) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr_i_input.length; i++) {

			if (set.contains(arr_i_input[i]))
				set.remove(arr_i_input[i]);
			else
				set.add(arr_i_input[i]);

		}

		System.out.println(set.iterator().next());

	}

	/*-
	 * TIME COMPLEXITY: 0(n)
	 * 
	 * 1. TC: O(n)	Find max value
	 * 2. SC: O(n)	Create aux array with array size = max value.
	 * 3. TC: O(n)	Put the info in aux array.
	 * 4. Keep a count of each item in input array in aux array.
	 * 
	 */
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

	/*-
	 * TIME COMPLEXITY: 0(n)
	 * 
	 * The definition of the XOR (exclusive OR) operator, over bits, is that:

	0 XOR 0 = 0
	0 XOR 1 = 1
	1 XOR 0 = 1
	1 XOR 1 = 0

	 */
	public static void findNumberOccuringOddNumberOfTimes(int[] arr_i_input) {

		int response = 0;

		for (int i = 0; i < arr_i_input.length; i++) {
			// System.out.println("XOR " + response + " XOR " + arr_i_input[i]+
			// ": ");
			response = response ^ arr_i_input[i];
			// System.out.println(response);
		}

		System.out.println("XOR approach: " + response);

	}

}