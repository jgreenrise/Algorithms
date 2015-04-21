package Array.problems.printCombinations;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find all possible combinations of input string
 * 
 * abc
 * 
 * Output [cba, bca, bac, cab, acb, abc]
 *
 */
public class RetrieveAllPossibleCombinationsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllStringCombinations("abc");

	}

	public static void printAllStringCombinations(String input) {

		ArrayList<String> list_1 = new ArrayList<String>();
		ArrayList<String> list_2 = new ArrayList<String>();
		char[] values = input.toCharArray();

		if (input.length() > 1) {

			list_1.add(Character.toString(values[0]));

			for (int i = 1; i < values.length; i++) {

				for (String value : list_1) {

					for (int position = 0; position < value.length() + 1; position++) {

						list_2.add(((new StringBuilder(value)).insert(position,
								values[i])).toString());

					}
				}

				list_1 = list_2;
				list_2 = new ArrayList<String>();

			}

			System.out.println(list_1.toString());

		} else {
			System.out.println(input);
		}

	}

}
