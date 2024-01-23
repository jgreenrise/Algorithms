# Traversal Orders

Binary Search Trees (BSTs) are hierarchical data structures that organize data in a way that allows for efficient
search, insertion, and deletion operations. Tree traversal is the process of visiting each node in the tree exactly
once.

## Mnemonic Trick

![](https://lh5.googleusercontent.com/63bUUZdT3TPXbTrShHVMGycwVhcQ5Xgww21UqCI8dlQAQa_C8zCyU0GGPoI-5C-Ejt1RbAmlPqwf_-d5DdHo_DLR4I3Yb2Et9bTb9KlWvuk5hGF2nqUVFmOg4W94q_rJmqm0VVFK)

* The term "pre" in "preorder" signifies that the root node is processed before its subtrees.
  root, left, right
* Post-order: Left, Right, Root
* In order
  Left, Root, Right

## Code Explanation

Now, let's dive into the provided Java code that demonstrates the insertion and printing of nodes in a BST using the
mentioned traversal orders.

```java

private void printPreOrder(TreeNode node){
        if(node==null)return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
        }

private void printPostOrder(TreeNode node){
        if(node==null)return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
        }

private void printInOrder(TreeNode node){
        if(node==null)return;
        printPostOrder(node.left);
        System.out.println(node.value);
        printPostOrder(node.right);
        }

```