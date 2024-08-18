package graph.directed.C_bfs;

public class Application {

	public static void main(String args[]) {
		CustomTreeNode n1 = new CustomTreeNode(1);
		CustomTreeNode n2 = new CustomTreeNode(2);
		CustomTreeNode n3 = new CustomTreeNode(3);
		CustomTreeNode n4 = new CustomTreeNode(4);
		CustomTreeNode n5 = new CustomTreeNode(5);
		CustomTreeNode n6 = new CustomTreeNode(6);
		CustomTreeNode n7 = new CustomTreeNode(7);
		CustomTreeNode n8 = new CustomTreeNode(8);
		CustomTreeNode n9 = new CustomTreeNode(9);
		CustomTreeNode n10 = new CustomTreeNode(10);
		CustomTreeNode n11 = new CustomTreeNode(11);
		CustomTreeNode n12 = new CustomTreeNode(12);

		n1.addAssosciatedNodes(n2);
		n1.addAssosciatedNodes(n3);
		n1.addAssosciatedNodes(n4);
		
		n2.addAssosciatedNodes(n5);
		n2.addAssosciatedNodes(n6);
		
		n3.addAssosciatedNodes(n11);
		
		n5.addAssosciatedNodes(n9);
		n5.addAssosciatedNodes(n10);
		
		n4.addAssosciatedNodes(n7);
		n4.addAssosciatedNodes(n8);
		
		n7.addAssosciatedNodes(n11);
		n7.addAssosciatedNodes(n12);
		
		Graph graph = new Graph();
		
		// Search Node 7
		System.out.println("\nIs there a path between Node 4 and 11");
		//graph.breadthFirstSearch(n4, n11);
		
		System.out.println("\nIs there a path between Node 3 and 11");
		//graph.breadthFirstSearch(n3, n11);
		
		System.out.println("\nIs there a path between Node 1 and 8");
		//graph.breadthFirstSearch(n1, n8);
		
		System.out.println("\nIs there a path between Node 1 and 12");
		//graph.breadthFirstSearch(n1, n12);
		
		System.out.println("\nIs there a path between Node 3 and 12");
		//graph.breadthFirstSearch(n3, n12);
		
		System.out.println("\nIs there a path between Node 2 and 10");
		graph.breadthFirstSearch(n2, n10);
		
	}

}
