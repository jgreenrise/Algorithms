import list.linkedlist.single.ListNode;

public class a_0148_SortLinkedList {

    public ListNode sortList(ListNode head) {

        if (head == null)
            return head;
        if (head.next == null)
            return head;

        if (head.next != null) {
            ListNode slow = head, fast = head;
            ListNode out = slow;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode left;
            ListNode right;
            right = slow.next;
            slow.next = null;
            left = out;

            left = sortList(left);
            right = sortList(right);
            return merge(left, right);
        }
        return head;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            if (left.val <= right.val) {
                left.next = merge(left.next, right);
                return left;
            } else {
                right.next = merge(left, right.next);
                return right;
            }
        }
    }

}
