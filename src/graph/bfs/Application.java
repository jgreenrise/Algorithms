package graph.bfs;

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
		
		n5.addAssosciatedNodes(n9);
		n5.addAssosciatedNodes(n10);
		
		n4.addAssosciatedNodes(n7);
		n4.addAssosciatedNodes(n8);
		
		n7.addAssosciatedNodes(n11);
		n7.addAssosciatedNodes(n12);
		
		Graph graph = new Graph();
		
		// Search Node 7
		graph.breadthFirstSearch(n1, n7);
		
		Node n50 = new Node(50);
		// Search Node 50
		//graph.breadthFirstSearch(n1, n50);
	}

}