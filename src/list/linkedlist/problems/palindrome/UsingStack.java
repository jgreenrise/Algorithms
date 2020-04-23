package list.linkedlist.problems.palindrome;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsingStack {

    public static void main(String[] args) {

        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 2, 1});
        System.out.println("Input Value - Odd elems: "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1});
        System.out.println("Input Value - Odd elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 3, 2, 1});
        System.out.println("Input Value - Odd elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 2, 1});
        System.out.println("Input Value - Odd elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 2, 1});
        System.out.println("Input Value - Even elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 1});
        System.out.println("Input Value - Even elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 3});
        System.out.println("Input Value - Even elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));
    }

    public static boolean isPalindrome(ListNode node) {

        // Expected Business Requirement
        if (node == null || node.next == null)    return true;

        // Handle negative scenarios
        if(node.next.next == null){
            // Compare 1st and 2nd element (0 -> 0)
            return node.val == node.next.val;
        }

        // 1. Add Nodes to stack from Start to Center (Including center)
        ListNode slow = node;
        ListNode fast = node;
        ListNode centerNode = null;
        Stack<ListNode> stack = new Stack<>();
        stack.add(node);
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.add(slow);
        }

        // 2. Detect if has odd number of nodes
        boolean hasOddNumberOfNode = fast.next == null;

        // 3. Remove Center Elements from Stack (If Odd number of nodes exist)
        if (hasOddNumberOfNode) {
            // Remove Center element from stack
            stack.pop();
        }

        // 4. Get reference to center node
        centerNode = slow.next;

        // 5. Compare between Stack and Original Node.
        return compareStackAndNode(stack, centerNode);
    }

    private static boolean compareStackAndNode(Stack<ListNode> stack, ListNode node) {

        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (pop.val != node.val) {
                return false;
            }
            node = node.next;
        }

        return true;
    }

}
