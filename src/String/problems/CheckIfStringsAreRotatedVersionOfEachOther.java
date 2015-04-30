package string;

/**
 * Reference
 * http://k2code.blogspot.in/2011/12/how-will-you-check-if-s1-is-rotated.html
 */
public class CheckIfStringsAreRotatedVersionOfEachOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRotatedVersion("kodenight", "odenightk"));
		System.out.println(isRotatedVersion("kodenight", "denightko"));
		System.out.println(isRotatedVersion("kodenight", "ghtkodeni"));
		System.out.println(isRotatedVersion("kodenight", "ghtkoden"));
	}

	/**
	 * Check if input2 is rotated version of input1
	 */
	public static boolean isRotatedVersion(String input1, String input2) {

		input2 = input2 + input2;

		if (isSubString(input2, input1)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSubString(String patterStr, String test) {
		if (patterStr == null || test == null)
			return false;
		if ((patterStr.indexOf(test)) !=  -1)
			return true;
		else
			return false;

	}
}
