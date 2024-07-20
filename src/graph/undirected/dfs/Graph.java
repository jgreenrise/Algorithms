package graph.undirected.dfs;

import java.util.Stack;

public class Graph {

	public void depthFirstSearch(CustomNode rootNode, CustomNode nodeToBeFound) {

		System.out.println();
		Stack<CustomNode> stack = new Stack<CustomNode>();
		System.out.println("Adding root node to stack: " + rootNode.value);
		stack.add(rootNode);
		rootNode.isVisited = true;

		while (!stack.isEmpty()) {

			System.out.println("Node which will be removed from stack: "
					+ (stack.peek()).value);
			CustomNode node = stack.pop();

			for (CustomNode adjNode : node.adjacentNodes) {
				
				System.out.println("Examining node: "+adjNode.value);
				
				if(adjNode.value == nodeToBeFound.value){
					System.out.println("***Node found****");
					break;
				}

				if (!adjNode.isVisited) {
					adjNode.isVisited = true;
					stack.push(adjNode);
				}
			}

		}

	}

}
