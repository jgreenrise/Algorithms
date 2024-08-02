import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class a_2095_DeleteMiddleLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Add FIRST
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(6);
        list.addFirst(4);

        System.out.println(deleteMiddle(list.start).val);

    }

    public static ListNode deleteMiddle(ListNode head) {

        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = head;
        ListNode out = prevSlow;
        int counter = 0;

        while (fast.next != null && fast.next.next != null) {
            counter++;
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (counter == 0) {
            head.next = null;
            return head;
        }

        if (fast.next == null) {
            prevSlow.next = slow.next;
            return out;
        } else {
            prevSlow.next.next = slow.next.next;
            return out;
        }

    }
}
