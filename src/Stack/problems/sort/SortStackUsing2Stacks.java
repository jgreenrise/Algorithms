package Stack.problems.sort;


import Stack.implementStack.Approach2_BoundedArray;
import Stack.implementStack.LinkedStack;

import java.util.Stack;

public class SortStackUsing2Stacks {

	public static void main(String[] args) {

		LinkedStack numbers = new LinkedStack();
		numbers.push(8);
		numbers.push(5);
		numbers.push(7);
		numbers.push(6);
		numbers.push(9);
		sortStackUsing2Stacks(numbers);

		System.out.println("\nInput: "+numbers.toString());

	}

	public static void sortStackUsing2Stacks(LinkedStack left) {

		LinkedStack right = new LinkedStack();

		if(right.isEmpty()){
			right.push(left.pop());
		}

		while(!left.isEmpty()){

			if((int)(right.peek()) > (int)(left.peek())){
				right.push(left.pop());
			}

			if(!left.isEmpty() && !right.isEmpty() && (int)left.peek() > (int)right.peek()){

				int value = (int)left.pop();

				while(right.peek() != null && value > (int)right.peek())
					left.push(right.pop());

				right.push(value);
			}
		}

		System.out.println(right);
		System.out.println(right.isEmpty());
	}

}
