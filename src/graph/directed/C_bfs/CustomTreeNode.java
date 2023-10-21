package graph.directed.C_bfs;

import java.util.LinkedList;
import java.util.List;

public class CustomTreeNode {
	
	public int value;
	public boolean isVisited = false;
	public List<CustomTreeNode> adjacentNodes = new LinkedList<CustomTreeNode>();
	
	public CustomTreeNode(int value){
		this.value = value;
	}
	
	public void addAssosciatedNodes(CustomTreeNode node){
		adjacentNodes.add(node);
	}

}
