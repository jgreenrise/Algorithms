package String.reverse;

public class inBuiltFunctions {

	public static void main(String[] args) {

		String str_nameOfEmployee = "Jatin Patel";

		System.out.println(new StringBuilder(str_nameOfEmployee).reverse().toString());
		System.out.println(new StringBuffer(str_nameOfEmployee).reverse().toString());

	}

}
