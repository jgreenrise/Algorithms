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
public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack numbers = new Stack();
		numbers.push(10);
		numbers.push(50);
		numbers.push(60);
		numbers.push(100);
		numbers.push(70);
		numbers.push(90);
		numbers.push(200);
		numbers.push(30);
		
		System.out.println("\nInput: "+numbers.toString());

		/**
		 * Space complexity 0(2n) => O(n)
		 */
		System.out.println("Output1");
		sortStackUsing2Stacks(numbers);

		numbers.push(10);
		numbers.push(50);
		numbers.push(60);
		numbers.push(100);
		numbers.push(70);
		numbers.push(90);
		numbers.push(200);
		numbers.push(30);

		/**
		 * SpaceComplexity O(n)
		 */
		System.out.println("Output2");
		sortStackUsing1Stack(numbers);
	}

	public static void sortStackUsing2Stacks(Stack numbers) {

		Stack output = new Stack();
		Stack buffer = new Stack();

		output.push(numbers.pop());

		while (!numbers.isEmpty()) {

			if (!output.isEmpty()
					&& Integer.valueOf(numbers.peek().toString()) < Integer
							.valueOf(output.peek().toString())) {

				while (!output.isEmpty()
						&& Integer.valueOf(numbers.peek().toString()) < Integer
								.valueOf(output.peek().toString())) {
					buffer.push(output.pop());
				}

				output.push(numbers.pop());

				while (!buffer.isEmpty()) {
					output.push(buffer.pop());
				}

			} else {
				output.push(numbers.pop());
			}

		}

		System.out.println(output);
	}

	public static void sortStackUsing1Stack(Stack input) {
		Stack output = new Stack();

		while (!input.isEmpty()) {

			int value = (int) input.pop();

			while (!output.isEmpty()
					&& Integer.valueOf(output.peek().toString()) > value) {
				
				// Add elements back to input stack
				input.push(output.pop());
			}

			output.push(value);
		}
		System.out.println(output);
	}

}
