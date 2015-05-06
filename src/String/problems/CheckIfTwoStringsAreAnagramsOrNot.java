package String.problems;

public class CheckIfTwoStringsAreAnagramsOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "at";
		String input2 = "ta";
		System.out.println(isAnagram(input, input2));

		input = "ab   cc   ";
		input2 = "cbac";
		System.out.println(isAnagram(input, input2));

		input = "temple";
		input2 = "mplete";
		System.out.println(isAnagramMethod2(input.toUpperCase(), input2.toUpperCase()));
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity :O(n)
	 */
	private static boolean isAnagramMethod2(String input, String input2) {
		int [] counts = new int[26];

	    for (char c: input.toCharArray())
	        counts[(int)c-65]++;

	    for (char c: input2.toCharArray())
	        counts[(int)c-65]++;

	    for (int count: counts)
	        if (count != 0)
	            return false;

	    return true;
	            		
	}

	/**
	 * O(n2) time complexity or O(nlgn) time complexity, if merge sort was used.
	 * No
	 * extra buffer
	 */
	private static boolean isAnagram(String input, String input2) {

		input = sortString(input);
		input2 = sortString(input2);

		if (input.equals(input2)) {
			return true;
		} else {
			return false;
		}
	}

	public static String sortString(String wordSt) {
		char[] word = wordSt.toCharArray();

		for (int i = 0; i < (word.length - 1); i++) {
			for (int j = i + 1; j > 0; j--) {
				if (word[j] < word[j - 1]) {
					char temp = word[j - 1];
					word[j - 1] = word[j];
					word[j] = temp;
				}
			}
		}

		return String.valueOf(word);
	}

}
