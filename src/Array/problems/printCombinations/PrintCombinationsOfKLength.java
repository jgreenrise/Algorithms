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
}
