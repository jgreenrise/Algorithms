package Array.problems;

public class TowersOfHanoi {

	public void solve(int n, String start, String end, String auxiliary) {

		if (n == 1) {
			System.out.println(start + " -> " + end);
		} else {
			solve(n - 1, start, auxiliary, end);
			System.out.println(start + "->" + end);
			solve(n - 1, auxiliary, end, start);

		}

	}

	public static void main(String[] args) {
		TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
		System.out.print("Enter number of discs: \n");
		int discs = 5;
		towersOfHanoi.solve(discs, "A", "B", "C");
	}

}
