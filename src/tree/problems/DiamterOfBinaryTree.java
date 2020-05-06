package tree.problems;

import tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class DiamterOfBinaryTree {

	public static void main(String[] args) {

		Integer[] tree = new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
		DiamterOfBinaryTree tr = new DiamterOfBinaryTree();
		TreeNode treeNode = tr.fromArray(tree);
		System.out.println(tr.diameterOfBinaryTree(treeNode));

	}

	public int diameterOfBinaryTree(TreeNode root) {
		return getDiameter(root, true);
	}

	public int getDiameter(TreeNode node, boolean isRootNode){

		if(node == null){
			return 0;
		}

		if(node.left == null && node.right == null)
			return 0;
		else if(node.left == null && node.right != null)
			return getDiameter(node.right, false)+1;
		else if(node.right == null && node.left != null)
			return getDiameter(node.left, false)+1;
		else{
			int left = getDiameter(node.left, false)+1;
			int right = getDiameter(node.right, false)+1;

			if(isRootNode){
				return left + right;
			}else{
				return Math.max(left,right);
			}

		}
	}

	public TreeNode fromArray(Integer[] tree) {
		if (tree.length == 0) return null;
		TreeNode root = new TreeNode(tree[0]);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		for (int i = 1; i < tree.length; i++) {
			TreeNode node = q.peek();
			if (node.left == null) {
				node.left = new TreeNode(tree[i]);
				if (tree[i] != null) q.add(node.left);
			} else if (node.right == null) {
				node.right = new TreeNode(tree[i]);
				if (tree[i] != null) q.add(node.right);
				q.remove();
			}
		}
		return root;
	}


}
