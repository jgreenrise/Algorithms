package graph.undirected.adjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*-
 * BUILDING ADJACENCY LIST FOR UNDIRECTED GRAPH
 * 
 * o/p
 * 
0 -> [4, 1]
1 -> [2, 3, 4, 0]
2 -> [3, 1]
3 -> [2, 4, 1]
4 -> [3, 1, 0]

After readding nodes
0 -> [4, 1]
1 -> [2, 3, 4, 0]
2 -> [3, 1]
3 -> [2, 4, 1]
4 -> [3, 1, 0]

 Remove edge between 2 and 3
0 -> [4, 1]
1 -> [2, 3, 4, 0]
2 -> [1]
3 -> [4, 1]
4 -> [3, 1, 0]


 * 
 **/

public class AdjacencyList {

	int i_number_of_vertices;
	Map<Integer, LinkedList<Integer>> map = null;

	public AdjacencyList(int i_number_of_vertices) {
		this.i_number_of_vertices = i_number_of_vertices;

		map = new HashMap<>();

		// Creating map with blank list for each key
		for (int i = 0; i < i_number_of_vertices; i++) {
			map.put(Integer.valueOf(i), new LinkedList<Integer>());
		}
	}

	/**
	 * Set edge between 2 vertex
	 **/
	public void setEdge(int from, int to) {

		LinkedList<Integer> adjacency_list = map.get(Integer.valueOf(from));

		if (!adjacency_list.contains(Integer.valueOf(to))) {
			adjacency_list.addFirst(Integer.valueOf(to));
			map.put(Integer.valueOf(from), adjacency_list);
		}

		adjacency_list = map.get(Integer.valueOf(to));

		if (!adjacency_list.contains(Integer.valueOf(from))) {
			adjacency_list.addFirst(Integer.valueOf(from));
			map.put(Integer.valueOf(to), adjacency_list);
		}

	}

	/**
	 * Remove edge
	 **/
	public void removeEdge(int from, int to) {

		LinkedList<Integer> adjacency_list = map.get(Integer.valueOf(from));

		if (adjacency_list.contains(Integer.valueOf(to))) {
			adjacency_list.remove(Integer.valueOf(to));
			map.put(Integer.valueOf(from), adjacency_list);
		}

		adjacency_list = map.get(Integer.valueOf(to));

		if (adjacency_list.contains(Integer.valueOf(from))) {
			adjacency_list.remove(Integer.valueOf(from));
			map.put(Integer.valueOf(to), adjacency_list);
		}

	}

	private void print() {
		// TODO Auto-generated method stub

		for (Map.Entry pair : map.entrySet()) {
			System.out.println(pair.getKey() + " -> " + pair.getValue());
		}


	}

	public static void main(String args[]) {

		AdjacencyList list = new AdjacencyList(5);
		list.setEdge(0, 1);
		list.setEdge(0, 4);
		list.setEdge(1, 0);
		list.setEdge(1, 4);
		list.setEdge(1, 3);
		list.setEdge(1, 2);
		list.setEdge(3, 4);
		list.setEdge(3, 1);
		list.setEdge(3, 2);
		list.setEdge(2, 1);
		list.setEdge(2, 3);

		// Print adjacency list
		list.print();
		
		System.out.println("\nAfter readding nodes");

		// Re-add edge,
		list.setEdge(0, 1);
		list.setEdge(0, 4);
		list.setEdge(1, 0);
		list.setEdge(1, 4);
		list.setEdge(1, 3);
		list.setEdge(1, 2);
		list.setEdge(3, 4);
		list.setEdge(3, 1);
		list.setEdge(3, 2);
		list.setEdge(2, 1);
		list.setEdge(2, 3);

		list.print();

		System.out.println("\n Remove edge between 2 and 3");
		list.removeEdge(2, 3);

		list.print();

	}

}
