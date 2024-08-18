package graph.directed.C_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	public void breadthFirstSearch(CustomTreeNode sourceNode, CustomTreeNode destinationNode) {

		System.out.println("Root node: " + sourceNode.value);
		Queue<CustomTreeNode> q = new LinkedList<CustomTreeNode>();
		boolean isDestinationNodeFound = false;

		System.out.println("Adding root node to queue");
		q.add(sourceNode);
		sourceNode.isVisited = true;

		while (!q.isEmpty()) {

			System.out.println("Removing node from queue: " + (q.peek()).value);
			CustomTreeNode node = q.poll();

			for (CustomTreeNode adjNode : node.adjacentNodes) {

				if (adjNode == destinationNode) {
					System.out.println("Node is found");
					isDestinationNodeFound = true;
					q.clear();
					break;
				}

				if (!adjNode.isVisited) {
					System.out.println("Child node: " + adjNode.value);
					adjNode.isVisited = true;
					q.add(adjNode);
				}
			}

		}

		if (!isDestinationNodeFound)
			System.out.println("Node is not found");

	}

}
