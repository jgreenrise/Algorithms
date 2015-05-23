package String.problems;

public class ReplaceAllSpaceByPercent20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "i am in love";

		// Approach 1
		System.out.println(input.replaceAll(" ", "'%20'"));

		// Approach 2 usign string tokenizer
		System.out.println(replaceUsingStringBuilder(input));

	}

	private static String replaceUsingStringBuilder(String input) {
		// TODO Auto-generated method stub

		StringBuilder response = new StringBuilder();

		String[] str_arr_input = input.split(" ");

		for (String item : str_arr_input) {
			response.append(item + "'%20'");
		}

		response.delete(response.length() - 5, response.length());

		return response.toString();
	}

}
