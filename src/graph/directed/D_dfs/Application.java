package graph.directed.D_dfs;

public class Application {

	public static void main(String args[]) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);

		n1.addAssosciatedNodes(n2);
		n1.addAssosciatedNodes(n3);
		n1.addAssosciatedNodes(n4);

		n2.addAssosciatedNodes(n5);
		n2.addAssosciatedNodes(n6);

		n3.addAssosciatedNodes(n11);

		n5.addAssosciatedNodes(n9);
		n5.addAssosciatedNodes(n10);

		n4.addAssosciatedNodes(n7);
		n4.addAssosciatedNodes(n8);

		n7.addAssosciatedNodes(n11);
		n7.addAssosciatedNodes(n12);

		Graph graph = new Graph();

		// Search Node 7
		System.out.println("\nIs there a path between Node 4 and 11");
		// graph.depthFirstSearch(n4, n11);

		System.out.println("\nIs there a path between Node 3 and 11");
		// graph.depthFirstSearch(n3, n11);

		System.out.println("\nIs there a path between Node 1 and 8");
		// graph.depthFirstSearch(n1, n8);

		System.out.println("\nIs there a path between Node 1 and 12");
		// graph.depthFirstSearch(n1, n12);

		System.out.println("\nIs there a path between Node 3 and 12");
		//graph.depthFirstSearch(n3, n12);

		System.out.println("\nIs there a path between Node 2 and 10");
		graph.depthFirstSearch(n2, n10);
	}

}