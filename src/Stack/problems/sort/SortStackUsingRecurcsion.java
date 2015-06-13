package Stack.problems.sort;

import java.util.Stack;

/**
 * Time complexity: 0(N2) 
 * 
 * Sort stack
 * 
Input: [10, 50, 60, 100, 70, 90, 200, 30]
Output1
[10, 30, 50, 60, 70, 90, 100, 200]
Output2
[10, 30, 50, 60, 70, 90, 100, 200]

 */
public class SortStackUsingRecurcsion {
	
	private static Stack myStack;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortStackUsingRecurcsion stack = new SortStackUsingRecurcsion();
		myStack = new Stack();
		stack.push(10);
		stack.push(50);
		stack.push(60);
		stack.push(100);
		stack.push(70);
		stack.push(90);
		stack.push(200);
		stack.push(30);
		
		System.out.println("\nInput: "+myStack.toString());

	}

	private void push(int i) {
		// TODO Auto-generated method stub
		if(myStack.isEmpty()){
			myStack.push(i);
		}else{
			
			if(i < Integer.parseInt(myStack.peek().toString())){
				Object item = myStack.pop();
				push(i);
				myStack.push(item);
			}else{
				myStack.push(i);
			}
			
		}
		
	}

	

}
