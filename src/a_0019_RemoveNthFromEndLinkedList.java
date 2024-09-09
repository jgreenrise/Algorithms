import list.linkedlist.single.ListNode;

public class a_0019_RemoveNthFromEndLinkedList {

    public ListNode removeNthFromEnd(ListNode node, int n) {
        if (node == null) return node;

        // Navigate to fast Node
        ListNode prev = new ListNode(-1);
        prev.next = node;
        ListNode slow = prev;
        ListNode fast = prev;
        for (int j = 0; j <= n; j++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // n > length of list
                return node;
            }
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return prev.next;
    }


}
