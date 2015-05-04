package graph.directed.dfs;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	public int value;
	public boolean isVisited = false;
	public List<Node> adjacentNodes = new LinkedList<Node>(); 
	
	public Node(int value){
		this.value = value;
	}
	
	public void addAssosciatedNodes(Node node){
		adjacentNodes.add(node);
	}

}
