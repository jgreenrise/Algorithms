package Array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatingNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] i_arr_input = { 3, 5, 4, 1, 4, 5, 5, 6, 7 };

		System.out.println("Before sorting: " + Arrays.toString(i_arr_input));
		Arrays.sort(i_arr_input);
		System.out.println("After sorting: " + Arrays.toString(i_arr_input));

		// Approach 1: O(n square)
		retrieveSecondMostRepeatingNumber_approach1(i_arr_input);
		
		// Approach 2: O(n)
		retrieveSecondMostRepeatingNumber(i_arr_input);
		
		// Approach 3: Using hashmap
		retrieveSecondMostRepeatingNumberUsingHahsmap(i_arr_input);
	}

	/**
	 * Using hashmap
	 */
	private static void retrieveSecondMostRepeatingNumberUsingHahsmap(int[] i_arr_input) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : i_arr_input) {
		    Integer count = map.get(i);
		    map.put(i, count != null ? count+1 : 0);
		}
		
		int max = -1;
	    int mostFrequent = -1;

	    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
	        if (e.getValue() > max) {
	            mostFrequent = e.getKey();
	            max = e.getValue();
	        }
	    }

	    System.out.println("Most frequent: "+mostFrequent);
	}

	/**
	 * Time complexity: O(n)
	 * We check a counter for repeating numbers;
	 */
	private static void retrieveSecondMostRepeatingNumber(int[] i_arr_input) {
		// TODO Auto-generated method stub

		int i_counter_famous = 0;
		int i_popular_number = 0;

		int i_counter_current = 0;
		int i_current_number = 0;

		int i_counter_second_famous = 0;
		int i_second_famous_popular_number = 0;

		for (int i = 0; i < i_arr_input.length; i++) {

			i_counter_current = 1;
			i_current_number = i_arr_input[i];

			if ((i+1) < i_arr_input.length && i_arr_input[i + 1] == i_current_number) {

				while ((i+1) < i_arr_input.length && i_arr_input[++i] == i_current_number)
					i_counter_current++;

				if (i < i_arr_input.length) {
					i = i - 1;
				}
			}

			if (i_counter_famous == 0) {
				i_counter_famous = i_counter_current;
				i_popular_number = i_current_number;
			} else {

				if (i_counter_current > i_counter_famous) {
					
					// Second famous
					i_counter_second_famous = i_counter_famous;
					i_second_famous_popular_number = i_popular_number;
					
					// First famous
					i_counter_famous = i_counter_current;
					i_popular_number = i_current_number;
				}

			}

		}

		System.out.println("The first most famous number : " + i_popular_number + ", was repeated: " + i_counter_famous);
		System.out.println("The second most famous number : " + i_second_famous_popular_number + ", was repeated: " + i_counter_second_famous);

	}

	/**
	 * Time complexity: O(n2)
	 */
	private static void retrieveSecondMostRepeatingNumber_approach1(int[] i_arr_input) {
		// TODO Auto-generated method stub

		int i_counter_famous = 0;
		int i_popular_number = 0;

		int i_counter_current = 0;

		int i_counter_second_famous = 0;
		int i_second_famous_popular_number = 0;

		for (int i = 0; i < i_arr_input.length; i++) {

			i_counter_current = 0;

			for (int j = i+1; j < i_arr_input.length; j++) {
				if (i_arr_input[i] == i_arr_input[j])
					i_counter_current++;
			}

			if (i_counter_current > i_counter_famous) {

				i_second_famous_popular_number = i_popular_number;
				i_counter_second_famous = i_counter_famous;

				i_popular_number = i_arr_input[i];
				i_counter_famous = i_counter_current;
			}

		}

		System.out.println("The first most famous number : " + i_popular_number + ", was repeated: " + i_counter_famous);
		System.out.println("The second most famous number : " + i_second_famous_popular_number + ", was repeated: " + i_counter_second_famous);

	}
}
