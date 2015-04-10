package String.reverse;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverse("jatin"));
	}

	public static String reverse(String arg) {
		if (arg.length() < 2)
			return arg;
		else {
			return reverse(arg.substring(1)) + arg.substring(0, 1);
		}

	}

}
