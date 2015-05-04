package graph.undirected.bfs;

/*-
* *** OUTPUT ***

Root node: 1
Adding root node to queue
Removing node from queue: 1
Child node: 2
Child node: 3
Child node: 4
Removing node from queue: 2
Child node: 5
Child node: 6
Removing node from queue: 3
Removing node from queue: 4
Node is found
Removing node from queue: 5
Child node: 9
Child node: 10
Removing node from queue: 6
Removing node from queue: 9
Removing node from queue: 10
Node is not found


Root node: 1
Adding root node to queue
Removing node from queue: 1
Child node: 2
Child node: 3
Child node: 4
Removing node from queue: 2
Child node: 5
Child node: 6
Removing node from queue: 3
Removing node from queue: 4
Child node: 7
Child node: 8
Removing node from queue: 5
Child node: 9
Child node: 10
Removing node from queue: 6
Removing node from queue: 7
Child node: 11
Child node: 12
Removing node from queue: 8
Removing node from queue: 9
Removing node from queue: 10
Removing node from queue: 11
Removing node from queue: 12
Node is not found

 * 
 **/
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
