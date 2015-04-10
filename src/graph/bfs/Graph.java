package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	public void breadthFirstSearch(Node rootNode, Node nodeToBeFound) {

		System.out.println("Root node: "+rootNode.value);
		Queue<Node> q = new LinkedList<Node>();
		
		System.out.println("Adding root node to queue");
		q.add(rootNode);
		rootNode.isVisited = true;

		while (!q.isEmpty()) {
			
			System.out.println("Removing node from queue: "+(q.peek()).value);
			Node node = q.poll();

			for (Node adjNode : node.adjacentNodes) {
				
				if(adjNode == nodeToBeFound){
					System.out.println("Node is found");
					break;
				}
				
				if (!adjNode.isVisited) {
					
					System.out.println("Child node: "+adjNode.value);
					
					adjNode.isVisited = true;
					q.add(adjNode);
				}
			}

		}
		
		System.out.println("Node is not found");

	}

}
