package Array.problems.prime;

/**
 * Sieve of Eratosthenes
 */
public class PrimeSieve {
	public static void main(String[] args) {
		int n = 10;

		// initially assume all integers are prime
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= n; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime[i]) {
				for (int j = i; i * j <= n; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		// count primes
		int primes = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				primes++;
		}
		System.out.println("The number of primes <= " + n + " is " + primes);
	}
}
