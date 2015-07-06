package String.problems.palindrome;

public class IsPalindromeAfterRemovingOneCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arr_str_input[] = { "RACECAAR", "RACECCAR", "RRACECAR",
				"RAACECAR" };

		for (String input : arr_str_input) {
			// System.out.println("Is palindrome: " + isPalindrome(input));
			System.out.println("Palindrom index: " + getPalindromeIndex(input));
			System.out.println();

		}

	}

	/**
	 * Check if string is a palindrome
	 */
	private static boolean isPalindrome(String str_input) {

//		System.out.println("Checking whether string " + str_input
//				+ " is a palindrome.");

		char[] input = str_input.toCharArray();

		for (int i = 0; i < (input.length / 2); i++) {

			// System.out.println("i: " + i + "\t" + input[i] + "\ti: "
			// + (input.length - i - 1) + "\t"
			// + input[input.length - i - 1]);

			if (input[i] != input[input.length - i - 1]) {
				// System.out.println("Not a palindrom. Exit");
				return false;
			}
		}

		return true;
	}

	private static int getPalindromeIndex(String str_input) {

		if (isPalindrome(str_input))
			return -1;

		int left = 0;
		int right = str_input.length() - 1;

		while (str_input.charAt(left) == str_input.charAt(right)) {
			left++;
			right--;
		}

		System.out.println("Left: " + left+" Right: " + right);
		
		if (isPalindrome(str_input.substring(0, right)
				+ str_input.substring(right+1, str_input.length())))
			return right;

		return left;

	}
}
