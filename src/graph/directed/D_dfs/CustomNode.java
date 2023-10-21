package graph.directed.D_dfs;

import java.util.LinkedList;
import java.util.List;

public class CustomNode {
	
	public int value;
	public boolean isVisited = false;
	public List<CustomNode> adjacentNodes = new LinkedList<CustomNode>();
	
	public CustomNode(int value){
		this.value = value;
	}
	
	public void addAssosciatedNodes(CustomNode node){
		adjacentNodes.add(node);
	}

}
