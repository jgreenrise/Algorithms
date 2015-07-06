package String.reverse;

public class ReverseSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] words =  "This is an interesting question".split(" ");

		String rev = "";
		for(int i = words.length - 1; i >= 0 ; i--)
		{
		   rev += words[i] + " ";
		}
		
		System.out.println(rev);

	}

}
