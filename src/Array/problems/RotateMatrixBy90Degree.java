package Array.problems;

public class RotateMatrixBy90Degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4 by 4
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		System.out.println("\n Input");
		printUndirectedGraph(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printUndirectedGraph(matrix);

		// 5 by 5
		matrix = new int[][] { { 1, 2, 3, 4, 13 }, { 5, 6, 7, 8, 14 },
				{ 9, 10, 11, 12, 16 }, { 13, 14, 15, 16, 17 },
				{ 18, 19, 20, 21, 22 } };

		System.out.println("\n Input");
		printUndirectedGraph(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printUndirectedGraph(matrix);

		// 2 by 2
		matrix = new int[][] { { 1, 2 }, { 3, 4 } };

		System.out.println("\n Input");
		printUndirectedGraph(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printUndirectedGraph(matrix);

		// 6 by 6
		matrix = new int[][] { { 1, 2, 3, 4, 13, 20 }, { 5, 6, 7, 8, 91, 14 },
				{ 9, 10, 11, 12, 16, 38 }, { 56, 13, 14, 15, 16, 17 },
				{ 18, 19, 20, 47, 21, 22 }, { 180, 109, 202, 470, 28, 68 } };

		System.out.println("\n Input");
		printUndirectedGraph(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printUndirectedGraph(matrix);

	}

	private static void printUndirectedGraph(int[][] matrix) {
		// TODO Auto-generated method stub

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				System.out.print(matrix[row][column] + "\t");
			}
			System.out.println();
		}

	}

	/**
	 * Loop from outer boundary to inner boundary
	 * 
	 * Deal with a then b then c
	 * 
	 * A	A	A	A	A
	 * A	B	B	B	A
	 * A	B	C	B	A
	 * A	B	B	B	B
	 * A	A	A	A	A
	 */
	public static void rotate(int[][] M) {

		int N = M.length;

		for (int i = 0; i < Math.ceil(N / 2); i++) {
			for (int j = 0; j < (N - 1) - (2 * i); j++) {

				/**
				 * 2: since we work with 2 rows of matrix, in single loop.
				 */

				int tmp = M[N - 1 - j - i][i];
				M[N - 1 - j - i][i] = M[N - 1 - i][N - 1 - j - i];
				M[N - 1 - i][N - 1 - j - i] = M[j + i][N - 1 - i];
				M[j + i][N - 1 - i] = M[i][j + i];
				M[i][j + i] = tmp;

				// System.out.println(N - 1 - j - i + " "
				// + i);
				// System.out.println(i + " " + (j + i));
				// System.out.println((j + i) + " "
				// + (N - 1 - i));
				// System.out.println((N - 1 - i) + " "
				// + (N - 1 - j - i));
			}

			// System.out.println("\n Outer: "+i);
			// printUndirectedGraph(M);
			// System.out.println("\n");
		}

	}

}
