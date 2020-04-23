package list.linkedlist.problems.palindrome;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class IsPalindromeRecursionAndLength {

    public static void main(String[] args) {

        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 2, 1});
        System.out.println("Input Value - Odd elems: "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1});
        System.out.println("Input Value - Odd elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 3, 2, 1});
        System.out.println("Input Value - Odd elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 2, 1});
        System.out.println("Input Value - Odd elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 0, 0});
        System.out.println("Input Value - Odd elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 2, 1});
        System.out.println("Input Value - Even elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 1});
        System.out.println("Input Value - Even elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 3});
        System.out.println("Input Value - Even elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));
    }

    public static boolean isPalindrome(ListNode node){

        // Expected Business Requirement
        if (node == null || node.next == null)    return true;

        // Handle negative scenarios
        if(node.next.next == null){
            // Compare 1st and 2nd element (0 -> 0)
            return node.val == node.next.val;
        }

        ListNode original = node;

        // Counter till center of node and detech whether we have odd/even number of nodes
        ListNode slow = node;
        ListNode fast = node;
        int counter = 0;
        while(slow.next != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            counter ++;
        }

        // 1,0,0
        if(counter == 1 && fast.next == null){
            return fast.val == original.val;
        }

        // Detect if has ODD number of nodes
        boolean hasOddNumberOfNodes = fast.next == null;

        ListNode listNode = isPalindrome(counter, hasOddNumberOfNodes, original, 0);

        return listNode != null;
    }

    private static ListNode isPalindrome(int counter, boolean hasOddNodes, ListNode node, int origCounter) {
        ListNode left = node;
        ListNode right = null;

        if(origCounter == counter){
            if(hasOddNodes){
                return node.next;
            }
            right = node.next;
        }else{
            right = isPalindrome(counter, hasOddNodes, node.next, origCounter + 1);
        }

        if(right == null){
            return right;
        }

        if(left.val == right.val){
            if(right.next == null){
                // For last Node
                return right;
            }
            return right.next;
        }else{
            return null;
        }

    }
}
