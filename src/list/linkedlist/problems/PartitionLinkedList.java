package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class PartitionLinkedList {

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
        ListNode node = partitionLinkedListUsingHeadAndTailPointers(list.start, 5);
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
        node = partitionLinkedListUsingRecursion(list.start, 5);
        System.out.println("Approach 2: Create LowLL and HighLL and combine");
        printLL(node);
    }


    private static ListNode partitionLinkedListUsingHeadAndTailPointers(ListNode node, int partition) {

            ListNode root_head = new ListNode(-1);
            ListNode root_tail = new ListNode(-1);
            ListNode head = root_head;
            ListNode tail = root_tail;

            while(node != null){

                if(node.val < partition){
                    head.next = new ListNode(node.val);
                    head = head.next;
                }else{
                    tail.next = new ListNode(node.val);
                    tail = tail.next;
                }

                node = node.next;
            }

            head.next = root_tail.next;
            return root_head.next;

        }

    private static ListNode partitionLinkedListUsingRecursion(ListNode node, int partition) {
        ListNode tail = null;
        ListNode head = null;
        ListNode out = null;
        return partition(node, tail, head, partition, out);
    }

    private static ListNode partition(ListNode node, ListNode tail, ListNode head, int partition, ListNode out) {

        if(node == null){
            tail.next = head;
            return out;
        }

        ListNode tmp = new ListNode(node.val);
        if(node.val >= partition){
            if(tail == null){
                tail = tmp;
            }else{
                tail.next = tmp;
                tail = tmp;
            }
            tmp.next = partition(node.next, tail, head, partition, out);
            return tmp;
        }else{
            if (head == null) {
                out = tmp;
            }
            tmp.next = head;
            head = tmp;
            return partition(node.next, tail, head, partition, out);
        }

    }

}
