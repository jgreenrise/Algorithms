package tree.bst;

public class BinaryNode {

	Comparable element;
	public BinaryNode left_node, right_node;

	public BinaryNode(Comparable element) {
		super();
		this.element = element;
		this.left_node = null;
		this.right_node = null;
	}
	
	public BinaryNode(Comparable element, BinaryNode left, BinaryNode right) {
		super();
		this.element = element;
		this.left_node = left;
		this.right_node = right;
	}

}
