import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class a_0086_cci_2_4_PartitionList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Input list");
        list.printList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(3);
        //ListNode node = partitionLinkedListUsingHeadAndTailPointers(list.start, 5);
        System.out.println("Approach 1: Head and Tail approach");
        //printLL(node);

        list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(3);
        //node = partitionLinkedListUsingRecursion(list.start, 5);

        list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(1);
        ListNode node = partition(list.start, 0);
        System.out.println("Approach 2: Create LowLL and HighLL and combine");
        printLL(node);
    }

    public static ListNode partition(ListNode head, int x) {

        if (head == null) return head;
        if (head.next == null) return head;
        ListNode lessThenX = null;
        ListNode moreOrEqualThenX = null;

        ListNode headLessThenX = null;
        ListNode headMoreOrequalThenX = null;

        while (head != null) {
            if (head.val < x) {
                if (lessThenX == null) {
                    lessThenX = new ListNode(head.val);
                    headLessThenX = lessThenX;
                } else {
                    lessThenX.next = new ListNode(head.val);
                    lessThenX = lessThenX.next;
                }
            } else {
                if (moreOrEqualThenX == null) {
                    moreOrEqualThenX = new ListNode(head.val);
                    headMoreOrequalThenX = moreOrEqualThenX;
                } else {
                    moreOrEqualThenX.next = new ListNode(head.val);
                    moreOrEqualThenX = moreOrEqualThenX.next;
                }
            }
            head = head.next;
        }
        if (lessThenX == null) return headMoreOrequalThenX;
        lessThenX.next = headMoreOrequalThenX;
        return headLessThenX;
    }

    private static ListNode partitionLinkedListUsingRecursion(ListNode node, int partition) {
        ListNode tail = null;
        ListNode head = null;
        ListNode out = null;
        return partition(node, tail, head, partition, out);
    }

    private static ListNode partition(ListNode node, ListNode tail, ListNode head, int partition, ListNode out) {
        if (node == null) {
            tail.next = head;
            return out;
        }
        ListNode tmp = new ListNode(node.val);
        if (node.val >= partition) {
            if (tail == null) {
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tmp;
            }
            tmp.next = partition(node.next, tail, head, partition, out);
            return tmp;
        } else {
            if (head == null)
                out = tmp;
            tmp.next = head;
            head = tmp;
            return partition(node.next, tail, head, partition, out);
        }
    }

}
