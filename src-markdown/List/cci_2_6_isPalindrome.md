# Palindrome Linked List

## Question:

Given a singly linked list `head`, determine if it is a palindrome. A palindrome is a word, number, phrase, or other sequence of characters that reads the same forward and backward.

Implement the `isPalindrome` method to check if the linked list is a palindrome. The function should return `true` if the linked list is a palindrome, and `false` otherwise.

https://leetcode.com/problems/palindrome-linked-list/description/

## Answer:

```java
public static boolean isPalindrome(ListNode head) {
    if (head.next == null) return true;
    if (head.next.next == null) return head.val == head.next.val;
    ListNode node1 = isPalindrome(head, head, head);
    return node1 != null;
}

public static ListNode isPalindrome(ListNode slow, ListNode fast, ListNode node) {
    if (fast.next != null && fast.next.next != null) {
        ListNode next = isPalindrome(slow.next, fast.next.next, node.next);
        if (next != null && next.val == node.val) {
            return next.next == null ? next : next.next;
        } else {
            return null;
        }
    }
    if (fast.next == null)
        return slow.next;

    return node.val == slow.next.val ? slow.next.next : null;
}
```


## Time Complexity:

The time complexity of the solution is O(N), where N is the number of nodes in the linked list. The recursive function `isPalindrome` processes each node once, and the algorithm overall traverses the linked list once.

## Solution:

The solution uses a recursive approach to check if the linked list is a palindrome. The `isPalindrome` method takes three pointers: `slow`, `fast`, and `node`. The `slow` pointer moves one step at a time, and the `fast` pointer moves two steps at a time. The recursive function checks the nodes in a way that allows comparing the values from both ends of the linked list.
