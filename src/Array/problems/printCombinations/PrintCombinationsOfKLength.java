package Array.problems.printCombinations;

import java.util.ArrayList;

/**
 * http://www.careercup.com/question?id=15203851
 * 
 * For example:
 * 
 * char[] alphabet = new char[] {'a','b'}; possibleStrings(3, alphabet,""); This
 * will output:
 * 
 * aaa aab aba abb baa bab bba bbb
 */
public class PrintCombinationsOfKLength {

	public static void main(String[] args) {
		possibleStrings(3, "abc".toCharArray(), "");
		possibleStrings_usingBinaryRepresentation(3, "abc".toCharArray(), "");
	}

	public static void possibleStrings(int maxLength, char[] alphabet,
			String curr) {

		// If the current string has reached it's maximum length
		if (curr.length() == maxLength) {
			System.out.println(curr);

			// Else add each letter from the alphabet to new strings and process
			// these new strings again
		} else {
			for (int i = 0; i < alphabet.length; i++) {
				String oldCurr = curr;
				curr += alphabet[i];
				possibleStrings(maxLength, alphabet, curr);
				curr = oldCurr;
			}
		}
	}
	
	/**
	 * Limitation for this approach: Will work only for alphabet with max 2
	 * characters. Since we are dealing with binary representation of string,
	 * which has 0 and 1 only
	 */
	private static void possibleStrings_usingBinaryRepresentation(int i, char[] alphabet, String string) {
		// TODO Auto-generated method stub

		for (int j = 0; j < Math.pow(2, i); j++) {
			String value = Integer.toBinaryString(j);
			String response = "";

			while (value.length() < i) {
				value = "0" + value;
			}

			for (int k = 0; k < value.length(); k++) {
				int index = Integer.parseInt(value.substring(k, k + 1));
				response = response + alphabet[index];
			}

			System.out.println(value + " " + response);

		}

	}
}
