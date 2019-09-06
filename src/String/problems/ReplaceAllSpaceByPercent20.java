package String.problems;

public class ReplaceAllSpaceByPercent20 {

	public static void main(String[] args) {
		String input = "Mr  John Smith     ";

		System.out.println(replaceUsingStringBuilder(input));

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
