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
public class a_0000_cci_3_5_SortStack {

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
		sort(numbers);

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
		sort(numbers);
	}

	public static Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> bufferStack = new Stack<>();

		while(!s.isEmpty()){
			if(bufferStack.isEmpty()){
				bufferStack.push(s.pop());
			}else{
				if(bufferStack.peek() <= s.peek()){
					bufferStack.push(s.pop());
				}else{
					int sPop = s.pop();
					while(!bufferStack.isEmpty() && bufferStack.peek() > sPop){
						s.push(bufferStack.pop());
					}
					bufferStack.push(sPop);
				}
			}
		}
		return bufferStack;
	}

}
