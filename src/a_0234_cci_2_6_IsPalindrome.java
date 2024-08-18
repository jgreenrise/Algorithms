import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class a_0234_cci_2_6_IsPalindrome {

    public static void main(String[] args) {

        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{1, 1, 2, 1});
        System.out.println("Input Value - Odd elems: " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1});
        System.out.println("Input Value - Odd elems " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 3, 2, 1});
        System.out.println("Input Value - Odd elems " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 2, 1});
        System.out.println("Input Value - Odd elems - Negative Test case " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 0, 0});
        System.out.println("Input Value - Odd elems - Negative Test case " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));
        node = SinglyLinkedList.createLL(new int[]{1, 2, 2, 1});
        System.out.println("Input Value - Even elems " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 1});
        System.out.println("Input Value - Even elems " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 3});
        System.out.println("Input Value - Even elems - Negative Test case " + node.printLL() + "\tIs palindrome: " + isPalindrome(node.start));
    }

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

    public boolean isPalindromeReverseSecondHalf(ListNode head) {

        /**
         * 1. Reach to the center of node
         */
        ListNode slow = head;
        ListNode fast = head;
        ListNode right;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        right = slow.next;
        slow.next = null;

        ListNode secondHalfStart = reverseList(right);

        // Compare the first and second half nodes
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode tmp = null;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

}
