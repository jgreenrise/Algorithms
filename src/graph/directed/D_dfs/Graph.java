package graph.directed.D_dfs;

import java.util.Stack;

public class Graph {

	public void depthFirstSearch(Node sourceNode, Node destinationNode) {

		System.out.println();
		Stack<Node> stack = new Stack<Node>();
		boolean isDestNodeFound = false;

		System.out.println("Adding root node to stack: " + sourceNode.value);
		stack.add(sourceNode);
		sourceNode.isVisited = true;

		while (!stack.isEmpty()) {

			System.out.println("Node which will be removed from stack: "
					+ (stack.peek()).value);
			Node node = stack.pop();

			for (Node adjNode : node.adjacentNodes) {

				System.out.println("Examining node: " + adjNode.value);

				if (adjNode.value == destinationNode.value) {
					System.out.println("***Node found****");
					stack.clear();
					isDestNodeFound = true;
					break;
				}

				if (!adjNode.isVisited) {
					adjNode.isVisited = true;
					stack.push(adjNode);
				}
			}
		}

		if (!isDestNodeFound) {
			System.out.println("Destination node not found");
		}

	}

}
