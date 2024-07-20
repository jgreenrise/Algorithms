package graph.undirected.dfs;

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
		graph.depthFirstSearch(n1, n7);
	}

}