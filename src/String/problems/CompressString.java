package String.problems;

public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "aabcccdeeaaa";
		compressString(input);

	}

	private static String compressString(String input) {

		int compressedSize = countCompression(input);
		if(compressedSize >= input.length()){
			return input;
		}
		
		
		
		return input;
		// TODO Auto-generated method stub

	}

	private static int countCompression(String input) {

		char last = input.charAt(0);
		int count = 1;
		int size = 0;

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count++;
			} else {
				size = 1 + count;
				count = 1;
				last = input.charAt(i);
			}
		}

		return size;

	}
}
