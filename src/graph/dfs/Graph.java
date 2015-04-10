package graph.dfs;

import java.util.Stack;

public class Graph {

	public void depthFirstSearch(Node rootNode, Node nodeToBeFound) {

		System.out.println();
		Stack<Node> stack = new Stack<Node>();
		System.out.println("Adding root node to stack: " + rootNode.value);
		stack.add(rootNode);
		rootNode.isVisited = true;

		while (!stack.isEmpty()) {

			System.out.println("Node which will be removed from stack: "
					+ (stack.peek()).value);
			Node node = stack.pop();

			for (Node adjNode : node.adjacentNodes) {
				
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
