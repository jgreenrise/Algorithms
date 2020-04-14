package tree.problems.largestBSTinBnaryTree;

import tree.bst.MyBinaryNode;

public class NodeMetadata {

	public NodeMetadata(MyBinaryNode node, boolean isBST, int size, int min,
                        int max) {
		this.node = node;
		this.isBST = isBST;
		this.size = size;
		this.max = max;
		this.min = min;
	}

	public MyBinaryNode node;
	public boolean isBST;
	public int size;
	public int min;
	public int max;

}
