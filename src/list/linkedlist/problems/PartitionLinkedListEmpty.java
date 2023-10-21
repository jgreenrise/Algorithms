package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class PartitionLinkedListEmpty {

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
        ListNode node = partition(list.start, 5);
        System.out.println("Approach 1: Head and Tail approach");
        printLL(node);

    }

    private static ListNode partition(ListNode node, int i) {


        return null;

    }


}
