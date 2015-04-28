package graph;

public class GraphAdjacencyMatrix {

	private int i_number_of_vertices = 0;
	private int[][] adjacency_matrix;

	public GraphAdjacencyMatrix(int i_number_of_vertices) {

		if (i_number_of_vertices < 0)
			throw new RuntimeException("Number of vertices must be nonnegative");

		this.i_number_of_vertices = i_number_of_vertices;
		adjacency_matrix = new int[i_number_of_vertices + 1][i_number_of_vertices];
	}

	/**
	 * Add undirected edge
	 */
	public void setEdge(int from_vertex, int to_vertex) {

		try {
			adjacency_matrix[from_vertex][to_vertex] = 1;
			adjacency_matrix[to_vertex][from_vertex] = 1;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Unable to set edge between "+from_vertex+" and "+to_vertex);
		}

	}
	
	/**
	 * Remove undirected edge
	 */
	public void removeEdge(int from_vertex, int to_vertex) {

		try {
			adjacency_matrix[from_vertex][to_vertex] = 0;
			adjacency_matrix[to_vertex][from_vertex] = 0;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Unable to remove edge between "+from_vertex+" and "+to_vertex);
		}

	}
	
	/**
	 * Has edge
	 */
	public boolean hasEdge(int from_vertex, int to_vertex) {

		try {
			return adjacency_matrix[from_vertex][to_vertex] == 1;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Unable to remove edge between "+from_vertex+" and "+to_vertex);
			return false;
		}
	}
	
	private void printUndirectedGraph() {
		// TODO Auto-generated method stub
		
		for (int row = 0; row < i_number_of_vertices; row++) {
			
			for(int column = 0; column < i_number_of_vertices; column ++){
				
				System.out.print(adjacency_matrix[row][column]+"\t");
				
			}
			
			System.out.println();
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Setting matrix 5*5 starting from index 0 * 0
		GraphAdjacencyMatrix matrix = new GraphAdjacencyMatrix(5);

		// add edge
		matrix.setEdge(0, 4);
		matrix.setEdge(0, 1);
		matrix.setEdge(1, 3);
		matrix.setEdge(1, 2);
		matrix.setEdge(1, 4);
		matrix.setEdge(3, 2);
		
		matrix.printUndirectedGraph();
		
		// remove edge
		System.out.println("\nRemove edge betwen 1 and 4");
		matrix.removeEdge(1, 4);
		matrix.printUndirectedGraph();

	}

}
