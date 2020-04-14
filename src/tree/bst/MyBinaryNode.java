package tree.bst;

public class MyBinaryNode {

	public Comparable value;
	public MyBinaryNode left_node, right_node;
    public boolean isVisited;

	public MyBinaryNode(Comparable value) {
		super();
		this.value = value;
		this.left_node = null;
		this.right_node = null;
	}
	
	public MyBinaryNode(Comparable value, MyBinaryNode left, MyBinaryNode right) {
		super();
		this.value = value;
		this.left_node = left;
		this.right_node = right;
	}

}
