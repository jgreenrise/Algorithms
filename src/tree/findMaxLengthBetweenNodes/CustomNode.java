package tree.findMaxLengthBetweenNodes;

import java.util.LinkedList;

public class CustomNode {

	/**
	 * Stores node values
	 */
	private int value;

	/**
	 * Stores child nodes
	 */
	private LinkedList<CustomNode> childNodes;

	public CustomNode(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedList<CustomNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(LinkedList<CustomNode> childNodes) {
		this.childNodes = childNodes;
	}

}
