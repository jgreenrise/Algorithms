package Array.problems.prime;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Approach 1
		 */
		System.out.println(isPrime(7));
		System.out.println(isPrime(10));
		System.out.println(isPrime(37));
		System.out.println(isPrime(50));
		
		/**
		 * Approach 2
		 */
		System.out.println(isPrime2(17));
		System.out.println(isPrime2(50));
		System.out.println(isPrime2(4));
		System.out.println(isPrime2(41));

	}
	
	private static boolean isPrime(int item){
		if(item < 2){
			return false;
		}
		
		for(int i=2; i<=item; i++){
			if(item % 2 == 0){
				return false;
			}
		}
		
		return true;
		
	}
	
	private static boolean isPrime2(int item){
		if(item < 2){
			return false;
		}
		
		for(int i=2; i<=Math.sqrt(item); i++){
			if(item % 2 == 0){
				return false;
			}
		}
		
		return true;
		
	}

}
