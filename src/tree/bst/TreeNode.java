package tree.bst;

public class TreeNode {

	public Comparable value;
	public TreeNode left, right;
    public boolean isVisited;

	public TreeNode(Comparable value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(Comparable value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
