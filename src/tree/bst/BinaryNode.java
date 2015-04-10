package tree.bst;

public class BinaryNode {

	Comparable element;
	BinaryNode left_node, right_node;

	public BinaryNode(Comparable element) {
		super();
		this.element = element;
		this.left_node = null;
		this.right_node = null;
	}

}
