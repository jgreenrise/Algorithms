package Stack.problems;

import java.util.Stack;

public class TowersOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> src = new Stack<Integer>();
		src.add(1);
		src.add(0);
		Stack<Integer> dest = new Stack<Integer>();
		Stack<Integer> aux = new Stack<Integer>();
		
		solveTowerOfHanoi(src, dest, aux);
	}

	private static void solveTowerOfHanoi(Stack<Integer> src, Stack<Integer> dest, Stack<Integer> aux) {
		
		if(src.size() == 1){
			dest.add(src.pop());
		}else{
			aux.add(src.pop());
			solveTowerOfHanoi(src, aux, dest);
			dest.add(src.pop());
			solveTowerOfHanoi(aux, dest, src);
		}
		
		System.out.println(src.size()+" "+dest.size()+" "+aux.size());
		
	}

}
