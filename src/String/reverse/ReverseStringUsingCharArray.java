package String.reverse;

public class ReverseStringUsingCharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("Mogambo khush hua"));
		
		System.out.println(reverseMethod2("I am impossible"));

	}

	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;

		while (begin < end) {
			char tmp1 = in[begin];
			in[begin] = in[end];
			in[end] = tmp1;
			begin++;
			end--;
		}
		return new String(in);
	}

	public static String reverseMethod2(String sentence) {
		// Get the character array of sentence
		final char[] sentenceChars = sentence.toCharArray();

		// Iterate through the first half of the array and swap each character
		// with its
		// "mirrored" counterpart - first and last swap, second and
		// second-to-last swap...
		final int halfLength = sentenceChars.length / 2;
		for (int i = 0; i < halfLength; ++i) {
			final char temp = sentenceChars[i];
			sentenceChars[i] = sentenceChars[sentenceChars.length - i - 1];
			sentenceChars[sentenceChars.length - i - 1] = temp;
		}

		return new String(sentenceChars);
	}

}
