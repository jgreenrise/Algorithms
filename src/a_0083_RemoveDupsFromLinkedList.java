import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class a_0083_RemoveDupsFromLinkedList {

    public static void main(String[] args) {

        a_0083_RemoveDupsFromLinkedList obj = new a_0083_RemoveDupsFromLinkedList();
        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{10, 10, 10, 20, 20});
        obj.deleteDuplicates(node.start);
        node.printList();

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode out = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next == null ? null : head.next.next;
            } else {
                head = head.next;
            }
        }
        return out;

    }

}
