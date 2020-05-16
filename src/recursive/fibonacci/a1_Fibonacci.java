package recursive.fibonacci;

public class a1_Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int j = 0; j < 10; j++){
			System.out.println("Basic \t"+fibonacci(j)+", B+ Memo \t"+fibonacciMemo(j, new int [j+1])+", Bottom up: \t"+fibonacciBottomUp(j)+", Efficient: \t"+fibonacciBottomUpEffecient(j));
		}

	}

	public static int fibonacciBottomUpEffecient(int n)  {

		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;

		int output = 0;
		int father=0;
		int grandfather=1;
		for (int i = 2; i <= n; i++) {
			output = father + grandfather;
			grandfather = father;
			father = output;
		}
		return father + grandfather;
	}

	public static int fibonacciBottomUp(int n)  {

		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;

		int [] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	
	public static int fibonacci(int n)  {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciMemo(int n, int [] memo)  {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else{
			if(memo[n] != 0){
				return memo[n];
			}
			memo[n]=fibonacci(n - 1) + fibonacci(n - 2);
			return memo[n];
		}
	}





}
