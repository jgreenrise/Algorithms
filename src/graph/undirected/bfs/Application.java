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
		CustomNode n1 = new CustomNode(1);
		CustomNode n2 = new CustomNode(2);
		CustomNode n3 = new CustomNode(3);
		CustomNode n4 = new CustomNode(4);
		CustomNode n5 = new CustomNode(5);
		CustomNode n6 = new CustomNode(6);
		CustomNode n7 = new CustomNode(7);
		CustomNode n8 = new CustomNode(8);
		CustomNode n9 = new CustomNode(9);
		CustomNode n10 = new CustomNode(10);
		CustomNode n11 = new CustomNode(11);
		CustomNode n12 = new CustomNode(12);

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
		
		CustomNode n50 = new CustomNode(50);
		// Search Node 50
		graph.breadthFirstSearch(n1, n50);
	}

}
