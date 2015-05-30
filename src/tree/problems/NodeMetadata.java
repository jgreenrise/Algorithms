package tree.problems;

import tree.bst.BinaryNode;

public class NodeMetadata {

	public NodeMetadata(BinaryNode node, boolean isBST, int size, int min,
			int max) {
		this.node = node;
		this.isBST = isBST;
		this.size = size;
		this.max = max;
		this.min = min;
	}

	public BinaryNode node;
	public boolean isBST;
	public int size;
	public int min;
	public int max;

}
