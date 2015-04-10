package Array.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromIntegerArray {

	public static void main(String[] args) {
		
		int [] input = new int[] { 20, 40, 20, 60, 40, 10, -1, 10, 0, -2, -1, };
		
		// TODO Auto-generated method stub
		System.out.println(removeDups(input).toString());
		
		// Using api
		Set<Integer> set_output = new HashSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			set_output.add(input[i]);
		}
		System.out.println(set_output.toString());
		
	}

	public static ArrayList<Integer> removeDups(int[] input) {

		ArrayList<Integer> output = new ArrayList<Integer>();
		Boolean exists = false;

		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				output.add(input[i]);
			} else {
				exists = false;

				for (int j = i - 1; j >= 0; j--) {

					if (input[i] == input[j]) {
						exists = true;
						break;
					} else {
						continue;
					}
				}

				if (!exists)
					output.add(input[i]);
			}
		}

		return output;
	}
}
