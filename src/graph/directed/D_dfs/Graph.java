package graph.directed.D_dfs;

import java.util.Stack;

public class Graph {

	public void depthFirstSearch(CustomNode sourceNode, CustomNode destinationNode) {

		System.out.println();
		Stack<CustomNode> stack = new Stack<CustomNode>();
		boolean isDestNodeFound = false;

		System.out.println("Adding root node to stack: " + sourceNode.value);
		stack.add(sourceNode);
		sourceNode.isVisited = true;

		while (!stack.isEmpty()) {

			System.out.println("Node which will be removed from stack: "
					+ (stack.peek()).value);
			CustomNode node = stack.pop();

			for (CustomNode adjNode : node.adjacentNodes) {

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
