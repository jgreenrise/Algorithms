package recursive.fibonacci;

public class FibonacciMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Final output 2 "+fibonacci(2));
		System.out.println("Final output 3 "+fibonacci(3));
		System.out.println("Final output 4 "+fibonacci(4));
		System.out.println("Final output 5 "+fibonacci(5));
		System.out.println("Final output 6 "+fibonacci(6));
		System.out.println("Final output 7 "+fibonacci(7));
		System.out.println("Final output 8 "+fibonacci(8));
	}
	
	public static int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
