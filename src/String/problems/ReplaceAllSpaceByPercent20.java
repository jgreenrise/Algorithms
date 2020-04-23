package String.problems;

import java.util.Arrays;

public class ReplaceAllSpaceByPercent20 {

	public static void main(String[] args) {
		String input = "Mr John Smith";
		int length = 13;
		System.out.println("\nInput String: "+input);
		System.out.println("Using String Builder "+replaceUsingStringBuilder(input.trim()));
		System.out.println("Using char array: "+URLify(input, 13));

		input = "Mr John  Smith";
		length = 14;
		System.out.println("\nInput String - Multiple Space: "+input);
		System.out.println("Using String Builder "+replaceUsingStringBuilder(input.trim()));
		System.out.println("Using char array: "+URLify(input, 13));

		input = "Mr John Smith ";
		length = 14;
		System.out.println("\nInput String - Space at the end: "+input);
		System.out.println("Using String Builder "+replaceUsingStringBuilder(input.trim()));
		System.out.println("Using char array: "+URLify(input, 13));

		input = "  ";
		length = 2;
		System.out.println("\nInput String - With only spaces: "+input);
		System.out.println("Using String Builder "+replaceUsingStringBuilder(input.trim()));
		System.out.println("Using char array: "+URLify(input, 13));

	}

	public static String URLify(String input, int length){

		int countNumberOfSpaces = 0;
		char [] chars = input.toCharArray();

		for (char aChar : chars) {
			if (aChar == ' ') {
				countNumberOfSpaces++;
			}
		}

		String [] out = new String [chars.length - countNumberOfSpaces + 3 * countNumberOfSpaces];
		int counterOut = out.length-1;
		boolean isSpaceChar = false;

		for(int j = chars.length - 1; j >= 0; j--){
			if(chars[j] != ' '){
				isSpaceChar = false;
				out[counterOut--] = String.valueOf(chars[j]);
			}else{
				if(!isSpaceChar){
					isSpaceChar = true;
					out[counterOut--] = "O";
					out[counterOut--] = "2";
					out[counterOut--] = "%";
				}
			}
		}

		return Arrays.toString(out);

	}

	private static String replaceUsingStringBuilder(String input) {

		StringBuilder response = new StringBuilder();
		int counter = 0;

		for (int i = 0; i< input.length(); i++){

			if(counter == 1 && input.charAt(i) == " ".charAt(0))
				continue;

			if(input.charAt(i) != " ".charAt(0)){
				response.append(input.charAt(i));
				counter = 0;
			}else{
				response.append("%20");
				counter = 1;
			}

		}

		return response.toString();
	}

}
