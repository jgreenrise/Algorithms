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
        node = partitionLinkedListUsingWhileAndIfLoop(list.start, 5);
        //ListNode node = partitionLinkedListUsingRecursion(list.start, 5);
        System.out.println("Approach 2: Create LowLL and HighLL and combine");
        printLL(node);
    }

    private static ListNode partitionLinkedListUsingWhileAndIfLoop(ListNode node, int partition) {

        ListNode lowNode = null;
        ListNode highNode = null;

        while (node != null) {
            ListNode nodeToBeAdded = new ListNode();
            nodeToBeAdded.val = node.val;

            if (node.val < partition) {
                if (lowNode == null) {
                    lowNode = nodeToBeAdded;
                } else {
                    nodeToBeAdded.next = lowNode;
                    lowNode = nodeToBeAdded;
                }
            } else {
                if (highNode == null) {
                    highNode = nodeToBeAdded;
                } else {
                    nodeToBeAdded.next = highNode;
                    highNode = nodeToBeAdded;
                }
            }
            node = node.next;
        }

        ListNode original = lowNode;

        while (lowNode.next != null) {
            lowNode = lowNode.next;
        }
        lowNode.next = highNode;

        return original;
    }

    private static ListNode partitionLinkedListUsingHeadAndTailPointers(ListNode node, int partition) {

        ListNode tail = null;
        ListNode head = null;
        ListNode startLowNode = null;

        while (node != null) {

            ListNode newNode = new ListNode();
            newNode.val = node.val;

            if (node.val < partition) {
                if (tail == null) {
                    tail = newNode;
                    startLowNode = tail;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            } else {
                if (head == null) {
                    head = newNode;
                } else {
                    newNode.next = head;
                    head = newNode;
                }
            }
            node = node.next;
        }

        tail.next = head;
        return startLowNode;

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
