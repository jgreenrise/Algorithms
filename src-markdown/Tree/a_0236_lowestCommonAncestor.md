# Lowest Common Ancestor

## Question

Given a binary tree and two nodes `p` and `q`, find the lowest common ancestor (LCA) of `p` and `q`. The LCA is the
deepest node in the tree that has both `p` and `q` as descendants.
![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

## Hints

1. Consider traversing the tree to find the paths from the root to both nodes `p` and `q`.
2. Build linked lists representing the paths from the root to each node.
3. Compare the linked lists to find the last common node.

## Time Complexity

The time complexity of this algorithm is O(N), where N is the number of nodes in the binary tree.

## Space Complexity

The space complexity is O(N), where N is the number of nodes in the binary tree. This is due to the additional space
required to store linked lists representing the paths.

## Code

```java
public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        boolean isMatchFound=false;
        Node left=buildLL(root,p,isMatchFound);

        isMatchFound=false;
        Node right=buildLL(root,q,isMatchFound);

        int prevCA=0;
        while(left!=null&&right!=null&&left.val==right.val){
        prevCA=left.val;
        left=left.next;
        right=right.next;
        }
        return new TreeNode(prevCA);
        }

public Node buildLL(TreeNode node,TreeNode r,boolean isMatchFound){
        if(node==null||isMatchFound)
        return null;

        if(node.val==r.val){
        isMatchFound=true;
        return new Node(node.val);
        }else{
        Node left=buildLL(node.left,r,isMatchFound);
        Node right=buildLL(node.right,r,isMatchFound);

        if(left!=null){
        Node newNode=new Node(node.val);
        newNode.next=left;
        return newNode;
        }else if(right!=null){
        Node newNode=new Node(node.val);
        newNode.next=right;
        return newNode;
        }else{
        return null;
        }
        }
        }

public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
```

This code finds the lowest common ancestor of two nodes `p` and `q` in a binary tree. It utilizes linked lists to
represent the paths from the root to each node and compares them to find the last common node.