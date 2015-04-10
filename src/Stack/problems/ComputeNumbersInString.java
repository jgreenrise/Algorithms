package Stack.problems;

import java.util.Stack;

public class ComputeNumbersInString {

	public static void main(String[] args) {
		System.out.println(computeString("123+/"));
	}

	private static int computeString(String string) {
		
		Stack<Integer> stack = new Stack<Integer> ();
		int i_final_output = 0;
		
		for(int i=0; i< string.length(); i++){
			
			if(isNumeric((string.subSequence(i, string.length()-i)).toString())){
				stack.add(Integer.parseInt((string.subSequence(i, string.length()-i)).toString()));
			}else{
				
			}
			
		}
		
		return i_final_output;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
