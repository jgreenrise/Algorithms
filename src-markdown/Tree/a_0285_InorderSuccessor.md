# Inorder Successor

**Problem:**

Given a node `p` in a binary search tree (BST), find its inorder successor, which is the node with the next greater
value in the inorder traversal. If no such node exists, return `null`.

**Hints:**

- **BST Properties:** Recall that in a BST, each node's left subtree contains nodes with smaller values, and its right
  subtree contains nodes with larger values.

**Diagram:**

Imagine the following BST:

```
          8
        /   \
       5     13
      / \    / \
     3   6  11  15

```

If `p` is node 5, its inorder successor would be node 6. Let's trace the steps of the algorithm with this example:

**Step 1:**

- `current` starts at the root (node 8).
- `successor` is initially `null`.

**Step 2 (Iteration 1):**

- `p.val` (5) is less than `current.val` (8).
- `current` becomes a potential successor (`successor` is updated to 8).
- `current` moves to the left subtree (`current = current.left`).

**Step 2 (Iteration 2):**

- `p.val` (5) is still less than `current.val` (5).
- `current` is now at node 5, so it's not a potential successor anymore.
- We've reached the leftmost node, so there are no more nodes in the left subtree.

**Step 3:**

- Since we've exhausted the left subtree, we need to explore the right subtree.
- Because `p.val` (5) is less than `current.val` (5), we don't need to update the `successor` here.
- `current` moves to the right subtree (`current = current.right`).

**Step 2 (Iteration 3):**

- `p.val` (5) is less than `current.val` (6).
- `current` (node 6) becomes the actual successor, as it's the first node encountered with a value greater than `p.val`.
- There are no more nodes to explore, so the loop terminates.

**Step 3:**

- The `successor` node (node 6) is returned.

**Steps:**

```java
    public TreeNode inorderSuccessor(TreeNode root,TreeNode p){
        TreeNode successor=null;
        TreeNode current=root;

        while(current!=null){
        if(p.val<current.val){
        // Potential successor found, keep track and explore left subtree
        successor=current;
        current=current.left;
        }else{
        // Move to the right subtree as potential successors will be there
        current=current.right;
        }
        }

        return successor;
        }
```

**Additional Notes:**

- If `p` has no right subtree, its successor does not exist, and the function returns `null`.
- The algorithm can be modified to directly handle the case where `p` is the rightmost node in the BST. In this case,
  the successor is either the parent of `p` (if its value is greater than `p.val`) or `null`.

I hope this enhanced explanation with the diagram proves even more helpful!