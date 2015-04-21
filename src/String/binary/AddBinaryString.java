package string;

/**
 * Output
 * 12
1100
100
 */
public class AddBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Using api
		System.out.println(addBinaryString("1010", "10"));

		// Using char loop
		System.out.println(addBinaryString_without_api("1010", "10"));
		System.out.println(addBinaryString_without_api("11", "1"));

	}

	private static String addBinaryString_without_api(String str_input_1, String str_input_2) {

		int carry = 0; // 0
		int i_length_str_input_1 = str_input_1.length()-1; // 4
		int i_length_str_input_2 = str_input_2.length()-1; // 2
		StringBuilder response = new StringBuilder();

		// 4>0 AND 2>0, 3>0 & 1>0, 2>0, 0>0
		while (i_length_str_input_2 >= 0 || i_length_str_input_1 >= 0 || carry > 0) {
			int value1 = 0;
			int value2 = 0;
			int i_curr_response = 0;

			if (i_length_str_input_1 >= 0)
				value1 = str_input_1.charAt(i_length_str_input_1--) == '1' ? 1 : 0; // 0,
																					// 1,
																					// 0

			if (i_length_str_input_2 >= 0)
				value2 = str_input_1.charAt(i_length_str_input_2--) == '1' ? 1 : 0; // 0,
																					// 1,

			i_curr_response = (value1 + value2 + carry) % 2; // 0, 0

			carry = (value1 + value2 + carry) / 2; // 0, 1
			response.insert(0, i_curr_response); // 00
		}

		return response.toString();
	}

	private static String addBinaryString(String value1, String value2) {
		// TODO Auto-generated method stub

		int number = Integer.parseInt(value1, 2);
		int number2 = Integer.parseInt(value2, 2);
		return String.valueOf(number + number2);
	}

}
