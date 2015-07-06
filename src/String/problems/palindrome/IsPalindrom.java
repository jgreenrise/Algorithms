package String.problems.palindrome;

public class IsPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str_input = "RACECAR";
		char[] input = str_input.toCharArray();

		for (int i = 0; i < (input.length / 2); i++) {

			System.out.println("i: "+i+"\t"+input[i] +"\ti: "+(input.length - i - 1)+"\t"+input[input.length - i - 1]);
			
			if(input[i] != input[input.length - i - 1]){
				System.out.println("Not a palindrom. Exit");
				break;
			}
		}
		
		System.out.println("Is a palindrome");

	}

}
