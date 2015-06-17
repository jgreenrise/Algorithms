package String.problems;

public class PrintAllCommonWordsBetween2Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input1 = "catdogmonkey";
		String input2 = "catcowmonkey";

		boolean[] counts = new boolean[26];

		for (char c : input1.toUpperCase().toCharArray())
			counts[(int)c - 65] = true;

		for (char c : input2.toUpperCase().toCharArray())
			if (counts[(int)c - 65]){
				System.out.print(c);
				counts[(int)c - 65] = false;
			}
				
	}

}
