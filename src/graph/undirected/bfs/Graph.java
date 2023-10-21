package graph.undirected.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	public void breadthFirstSearch(CustomNode rootNode, CustomNode nodeToBeFound) {

		System.out.println("Root node: "+rootNode.value);
		Queue<CustomNode> q = new LinkedList<CustomNode>();
		
		System.out.println("Adding root node to queue");
		q.add(rootNode);
		rootNode.isVisited = true;

		while (!q.isEmpty()) {
			
			System.out.println("Removing node from queue: "+(q.peek()).value);
			CustomNode node = q.poll();

			for (CustomNode adjNode : node.adjacentNodes) {
				
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
