package tree.bst;

public class BinaryNode {

	public Comparable value;
	public BinaryNode left_node, right_node;

	public BinaryNode(Comparable value) {
		super();
		this.value = value;
		this.left_node = null;
		this.right_node = null;
	}
	
	public BinaryNode(Comparable value, BinaryNode left, BinaryNode right) {
		super();
		this.value = value;
		this.left_node = left;
		this.right_node = right;
	}

}
