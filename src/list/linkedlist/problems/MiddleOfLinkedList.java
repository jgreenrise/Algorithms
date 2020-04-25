package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Add FIRST
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(6);
        list.addFirst(4);

        System.out.println(usingLength(list.start).val);
        System.out.println(usingSlowPointerFastPointer(list.start).val);

    }

    public static ListNode usingLength(ListNode node) {

        if(node.next == null)
            return node;

        if(node.next.next == null)
            return node.next;

        // GET TOTAL NUMBER OF NODES
        int totalNodes = getCountTotalNodes(node, 1);

        // GET INDEX OF CENTER NODE
        int centerNode = totalNodes / 2 + totalNodes % 2;

        // Business requirement
        if(totalNodes % 2 == 0){
            centerNode = centerNode+1;
        }

        int counter = 1;
        while(node.next!= null){
            if(counter == centerNode){
                return node;
            }else{
                node = node.next;
                counter++;
            }
        }

        return null;

    }

    public static int getCountTotalNodes(ListNode node, int index){
        if(node.next != null){
            return getCountTotalNodes(node.next, index + 1);
        }else{
            return index;
        }
    }

    public static ListNode usingSlowPointerFastPointer(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;

        while(slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == null){
            return slow;
        }else{
            return slow.next;
        }

    }
}
