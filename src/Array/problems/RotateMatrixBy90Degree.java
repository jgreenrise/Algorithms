package Array.problems;

/*-
 * 
 Input
1	2	3	4	
5	6	7	8	
9	10	11	12	
13	14	15	16	

 Final output
13	9	5	1	
14	10	6	2	
15	11	7	3	
16	12	8	4	

 Input
1	2	3	4	13	
5	6	7	8	14	
9	10	11	12	16	
13	14	15	16	17	
18	19	20	21	22	

 Final output
18	13	9	5	1	
19	14	10	6	2	
20	15	11	7	3	
21	16	12	8	4	
22	17	16	14	13	

 Input
1	2	
3	4	

 Final output
3	1	
4	2	

 Input
1	2	3	4	13	20	
5	6	7	8	91	14	
9	10	11	12	16	38	
56	13	14	15	16	17	
18	19	20	47	21	22	
180	109	202	470	28	68	

 Final output
180	18	56	9	5	1	
109	19	13	10	6	2	
202	20	14	11	7	3	
470	47	15	12	8	4	
28	21	16	16	91	13	
68	22	17	38	14	20	
 
 *
 */
public class RotateMatrixBy90Degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4 by 4
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		System.out.println("\n Input");
		printMatrix(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printMatrix(matrix);

		// 5 by 5
		matrix = new int[][] { { 1, 2, 3, 4, 13 }, { 5, 6, 7, 8, 14 },
				{ 9, 10, 11, 12, 16 }, { 13, 14, 15, 16, 17 },
				{ 18, 19, 20, 21, 22 } };

		System.out.println("\n Input");
		printMatrix(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printMatrix(matrix);

		// 2 by 2
		matrix = new int[][] { { 1, 2 }, { 3, 4 } };

		System.out.println("\n Input");
		printMatrix(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printMatrix(matrix);

		// 6 by 6
		matrix = new int[][] { { 1, 2, 3, 4, 13, 20 }, { 5, 6, 7, 8, 91, 14 },
				{ 9, 10, 11, 12, 16, 38 }, { 56, 13, 14, 15, 16, 17 },
				{ 18, 19, 20, 47, 21, 22 }, { 180, 109, 202, 470, 28, 68 } };

		System.out.println("\n Input");
		printMatrix(matrix);

		rotate(matrix);

		System.out.println("\n Final output");
		printMatrix(matrix);

	}

	private static void printMatrix(int[][] matrix) {
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
