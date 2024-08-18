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

    public static ListNode partition(ListNode node, int x) {
        if (node == null) return node;
        ListNode tmp = new ListNode(node.val);
        if (node.val < x) {
            return partition(node.next, x, tmp, tmp, null, null);
        } else {
            return partition(node.next, x, null, null, tmp, tmp);
        }
    }

    public static ListNode partition(ListNode node, int x,
                                     ListNode headHead,
                                     ListNode headTail,
                                     ListNode tailHead,
                                     ListNode tailTail) {
        if (node == null) {
            if (headTail != null) {
                headTail.next = tailHead;
                return headHead;
            } else {
                return tailHead;
            }
        }

        ListNode tmp = new ListNode(node.val);
        if (node.val < x) {
            if (headHead == null) {
                return partition(node.next, x, tmp, tmp, tailHead, tailTail);
            } else {
                headTail.next = tmp;
                return partition(node.next, x, headHead, headTail.next, tailHead, tailTail);
            }
        } else {
            if (tailHead == null) {
                return partition(node.next, x, headHead, headTail, tmp, tmp);
            } else {
                tailTail.next = tmp;
                return partition(node.next, x, headHead, headTail, tailHead, tailTail.next);
            }
        }

    }

}
