public class a_0125_cci_1_4_ValidPalindrome_PalindromePermutation {

	public static void main(String[] args) {
		String str_input = "RACECAR";
		System.out.println("Is a palindrome: "+isPalindrome(str_input));
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		char [] chars = s.toCharArray();
		int leftPtr     = 0;
		int rightPtr    = chars.length-1;
		while(leftPtr < rightPtr){
			while(leftPtr < rightPtr && !Character.isLetterOrDigit(chars[leftPtr]))
				leftPtr++;
			while(leftPtr < rightPtr && !Character.isLetterOrDigit(chars[rightPtr]))
				rightPtr--;

			if(chars[leftPtr] != chars[rightPtr]) return false;
			leftPtr++;
			rightPtr--;
		}

		return true;

	}

}
