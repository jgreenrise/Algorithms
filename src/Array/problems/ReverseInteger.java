package Array.problems;

public class ReverseInteger {

	public static void main(String[] args) {

		System.out.println(reverse(123));
		System.out.println(reverse(1534236469));
	}


	public static int reverse(int x) {
		int reverse = 0;

		while(x != 0){

			if(overflowHappens(reverse))
				return 0;

			int mod = x % 10;
			int div = x / 10;
			reverse = reverse * 10 + mod;
			x = div;
		}

		return reverse;
	}

	/**
	 * Integer.MAX_VALUE: 2147483647
	 * Integer.MIN_VALUE: -2147483648
	 */
	private static boolean overflowHappens(int reverse) {

		int pop = reverse%10;

		// Integer.MAX_VALUE: 2147483647
		// Overflow will happen if number > 2147483647

		// reverse > 214748364 (last digit 7 is missing)(e.g. 214748365, 214748366, 214748367 etc)
		if(reverse > Integer.MAX_VALUE/10 ||
				// e.g.: reverse = 2147483640, pop allow till 7
				reverse == Integer.MAX_VALUE/10 && pop > 7)
			return true;

		// Integer.MIN_VALUE: -2147483648
		// Overflow will happen if number < -2147483648

		// reverse < -214748364 (last digit 8 is missing)(e.g. -214748363, -214748362, -214748361 etc)
		if(reverse < Integer.MIN_VALUE/10 ||
				// e.g.: reverse = 2147483640, pop allow till 7
				reverse == Integer.MIN_VALUE/10 && pop < -8)
			return true;

		return false;

	}


}