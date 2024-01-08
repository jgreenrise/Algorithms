import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

/**
 * Input
 * 1, 7, 6, 6, 1, 1, 2, 0, Size: 8
 */
public class a_0048_SortLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SinglyLinkedList list = new SinglyLinkedList();

        // Add FIRST
        list.addFirst(3);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(4);

        System.out.println("Input");
        list.printList();

        ListNode output = sortList(list.start);

        System.out.println("Output");
        while (output != null) {
            System.out.print(output.val + ", ");
            output = output.next;
        }

    }

    public static ListNode sortList(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode out = null;

        if (head != null && head.next != null) {
            ListNode slowPtr = head;
            ListNode leftPtr = slowPtr;
            ListNode fastPtr = head;
            ListNode left, right = null;

            while (fastPtr.next != null && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }

            right = slowPtr.next;
            slowPtr.next = null;
            left = leftPtr;

            ListNode leftList = sortList(left);
            ListNode rightList = sortList(right);

            out = sortTwoListNode(leftList, rightList);
        }

        return out;

    }

    public static ListNode sortTwoListNode(ListNode left, ListNode right) {

        if (left == null) return right;
        else if (right == null) return left;

        if (left.val <= right.val) {
            left.next = sortTwoListNode(left.next, right);
            return left;
        } else {
            right.next = sortTwoListNode(left, right.next);
            return right;
        }

    }

}
