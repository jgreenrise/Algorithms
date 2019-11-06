package String.problems;

public class ReplaceAllSpaceByPercent20 {

	public static void main(String[] args) {
		String input = "Mr John Smith     ";
		System.out.println(replaceUsingStringBuilder(input.trim()));

		System.out.println(replaceInPlaceFromBackwards(input.toCharArray(), 13));

	}

	private static String replaceInPlaceFromBackwards(char[] input, int trueLenght) {

		int countNoOfSpaces = 0;

		for (int i = 0; i < trueLenght; i++) {
			if(input[i] == ' '){
				countNoOfSpaces++;
			}
		}

		int index = trueLenght + countNoOfSpaces * 2;

		for (int i = trueLenght-1; i >= 0; i--) {

				if(input[i] == ' '){
					input[index-1] = '0';
					input[index-2] = '2';
					input[index-3] = '%';
					index = index - 3;
				}else{
					input[index-1] = input[i];
					index = index -1;
				}
		}

		System.out.println(input);

		return input.toString();


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
