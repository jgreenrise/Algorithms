package Stack.problems;

import Stack.implementSTack.BoundedArray;

public class TowerOfHanoi {

	private static BoundedArray[] towers;

	public static void main(String[] args) {

		System.out.println("Running 3 disk problem:");
		towersOfHanoi(3);

	}

	public static void towersOfHanoi(int n) {

		// create three stacks, tower[0] is scratch
		towers = new BoundedArray[4];

		for (int i = 0; i <= 3; i++) {
			towers[i] = new BoundedArray(4);
		}

		for (int d = n; d > 0; d--) {
			// initialize
			// add disk d to towers 1
			towers[1].push(new Integer(d));
		}

		solve(n, 1, 2, 3);
	}

	private static void solve(int n, int src, int dest, int aux) {

		if (n == 1) {

			if (!towers[src].isEmpty()) {
				Integer value = (Integer) towers[src].pop();
				towers[dest].push(value);
				System.out.println("Move disk " + value + " from tower " + src + " to tower" + dest);
			}

		} else {
			solve(n - 1, src, aux, dest);

			if (!towers[src].isEmpty()) {
				Integer value = (Integer) towers[src].pop();
				towers[dest].push(value);
				System.out.println("Move disk " + value + " from tower " + src + " to tower" + dest);
			}

			solve(n - 1, aux, dest, src);

		}

	}

}
