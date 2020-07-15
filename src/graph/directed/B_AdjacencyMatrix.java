package graph.directed;

/*-
 * 
 * 0 1 1 0 0 1 1 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 1 0 0 0 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 1 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 1 1 1 
0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 1 
0 0 0 0 0 0 0 0 0 0 0 0 0 

Has edge from 0 to 5 	true
Has edge from 4 and 3 	true
Has edge from 3 and 5 	false

 * 
 */
public class  B_AdjacencyMatrix {

	private static int[][] matrix = null;
	private static int i_total_nodes = 0;

	public B_AdjacencyMatrix(int i_number_of_nodes) {

		if (i_number_of_nodes < 0)
			throw new RuntimeException("Number of vertices must be nonnegative");

		matrix = new int[i_number_of_nodes][i_number_of_nodes];
		i_total_nodes = i_number_of_nodes;
	}

	private void add(int source, int destination) {

		try {
			matrix[source][destination] = 1;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Unable to set edge between " + source + " and "
					+ destination);
		}
	}

	/**
	 * Remove undirected edge
	 */
	public void removeEdge(int from_vertex, int to_vertex) {

		try {
			matrix[from_vertex][to_vertex] = 0;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Unable to remove edge between " + from_vertex
					+ " and " + to_vertex);
		}

	}

	/**
	 * Has edge
	 */
	public boolean hasEdge(int from_vertex, int to_vertex) {

		try {
			return matrix[from_vertex][to_vertex] == 1;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Unable to remove edge between " + from_vertex
					+ " and " + to_vertex);
			return false;
		}
	}

	private void print() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B_AdjacencyMatrix matrix = new B_AdjacencyMatrix(
				13);

		// Source node 0
		matrix.add(0, 1);
		matrix.add(0, 2);
		matrix.add(0, 6);
		matrix.add(0, 5);

		// Source node 5
		matrix.add(5, 3);
		matrix.add(5, 4);

		// Source node 6
		matrix.add(6, 4);

		// Source node 4
		matrix.add(4, 3);

		// Source node 7
		matrix.add(7, 8);

		// Source node 9
		matrix.add(9, 10);
		matrix.add(9, 11);
		matrix.add(9, 12);
 
		// Source node 11
		matrix.add(11, 12);

		matrix.print();

		System.out.println("Has edge from 0 to 5 \t" + matrix.hasEdge(0, 5));
		System.out.println("Has edge from 4 and 3 \t" + matrix.hasEdge(4, 3));
		System.out.println("Has edge from 3 and 5 \t" + matrix.hasEdge(3, 5));

	}

}
