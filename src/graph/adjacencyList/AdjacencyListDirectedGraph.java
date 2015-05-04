package graph.adjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*-
 * BUILDING ADJACENCY LIST FOR UNDIRECTED GRAPH
 * 
 * 0 -> [5, 6, 2, 1]
1 -> []
2 -> []
3 -> []
4 -> [3]
5 -> [4, 3]
6 -> [4]
7 -> [8]
8 -> []
9 -> [12, 11, 10]
10 -> []
11 -> [12]
12 -> []

After readding nodes

 Remove edge between 4 and 3

 Remove edge between 9 and 12
 
0 -> [5, 6, 2, 1]
1 -> []
2 -> []
3 -> []
4 -> []
5 -> [4, 3]
6 -> [4]
7 -> [8]
8 -> []
9 -> [11, 10]
10 -> []
11 -> [12]
12 -> []

 Has directed edge from 0 to 1: true

 Has directed edge from 3 to 4: false

 **/

public class AdjacencyListDirectedGraph {

	int i_number_of_vertices;
	Map<Integer, LinkedList<Integer>> map = null;

	public AdjacencyListDirectedGraph(int i_number_of_vertices) {
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
	}

	/**
	 * Has edge
	 **/
	public boolean hasEdge(int from, int to) {

		LinkedList<Integer> adjacency_list = map.get(Integer.valueOf(from));
		return adjacency_list.contains(Integer.valueOf(to));

	}

	private void print() {
		// TODO Auto-generated method stub

		for (Map.Entry pair : map.entrySet()) {
			System.out.println(pair.getKey() + " -> " + pair.getValue());
		}

	}

	public static void main(String args[]) {

		AdjacencyListDirectedGraph list = new AdjacencyListDirectedGraph(13);
		list.setEdge(0, 1);
		list.setEdge(0, 2);
		list.setEdge(0, 6);
		list.setEdge(0, 5);
		list.setEdge(5, 3);
		list.setEdge(5, 4);
		list.setEdge(4, 3);
		list.setEdge(6, 4);
		list.setEdge(7, 8);
		list.setEdge(9, 10);
		list.setEdge(9, 11);
		list.setEdge(9, 12);
		list.setEdge(11, 12);

		// Print adjacency list
		list.print();

		System.out.println("\nAfter readding nodes");

		System.out.println("\n Remove edge between 4 and 3");
		list.removeEdge(4, 3);
		System.out.println("\n Remove edge between 9 and 12");
		list.removeEdge(9, 12);

		list.print();

		System.out.println("\n Has directed edge from 0 to 1: "+list.hasEdge(0, 1));
		System.out.println("\n Has directed edge from 3 to 4: "+list.hasEdge(3, 4));

	}

}
