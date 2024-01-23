# Deleting a Node in a Binary Search Tree

## Question

Given a Binary Search Tree (BST) and a key, implement a method `deleteNode` to delete the node with the given key from
the BST. Also, provide a method `printTree` to print the BST in-order.

![BST Deletion](https://assets.leetcode.com/uploads/2020/09/04/del_node_1.jpg)

## Hints

- In a Binary Search Tree (BST), to delete a node with a given key:
    - If the node has no children, simply remove it.
    - If the node has one child, replace the node with its child.
    - If the node has two children, find the minimum node in its right subtree, replace the node's value with the
      minimum node's value, and then delete the minimum node.

## Time Complexity

- The time complexity of deleting a node in a BST is O(log n), where n is the number of nodes in the BST.
- The time complexity of finding the minimum node in the right subtree is O(log n).

## Space Complexity

The space complexity is O(1) since no additional space is used other than the input and a few variables.

## Code

```java

public TreeNode deleteNode(TreeNode node,int key){
        if(node==null)return node;
        if(node.val==key){
        if(node.left==null&&node.right==null){
        return null;
        }else if(node.left==null){
        return node.right;
        }else if(node.right==null){
        return node.left;
        }else{
        TreeNode min=findMin(node.right);
        node.val=min.val;
        node.right=deleteNode(node.right,node.val);
        return node;
        }
        }
        else{
        node.left=deleteNode(node.left,key);
        node.right=deleteNode(node.right,key);
        return node;
        }
        }

private TreeNode findMin(TreeNode node){
        while(node.left!=null){
        node=node.left;
        }
        return node;
        }
```
