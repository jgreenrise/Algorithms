package tree.findMaxLengthBetweenNodes;

import java.util.LinkedList;

public class Node {

	/**
	 * Stores node values
	 */
	private int value;

	/**
	 * Stores child nodes
	 */
	private LinkedList<Node> childNodes;

	public Node(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedList<Node> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(LinkedList<Node> childNodes) {
		this.childNodes = childNodes;
	}

}
