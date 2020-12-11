package tree.bst;

public class TreeNode {

	public Comparable value;
	public TreeNode left, right;
    public boolean isVisited;
	public int val;

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

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
