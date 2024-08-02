import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class a_0019_RemoveNthFromEndLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SinglyLinkedList list = new SinglyLinkedList();

        // Node to be deleted is given
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        System.out.println("Input list");
        list.printList();
        ListNode node = null;
        //removeNodeFromCenterOfLinkedList(list, 30);
        System.out.println("Approach 1");
        //printLL(node);

        // Center node not given
        list = new SinglyLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        node = removeNthFromEnd(list.start, 2);
        printLL(node);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Find total Nodes
        ListNode slow = head;
        ListNode fast = head;
        int counter = 1;
        int totalNodes = 0;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            counter++;
        }
        if (fast.next == null)
            totalNodes = 2 * counter - 1;
        else if (fast.next.next == null)
            totalNodes = 2 * counter;

        //System.out.println("Total Node: "+totalNodes+"\tCounter: "+counter);

        // Step 2: Find nth node from the start: TotalNodes - N
        counter = totalNodes - n;

        // Step 3. Recursively navigate to nth node, return n.next;
        return removeNthNodeFromStartv2(head, counter);

    }

    public static ListNode removeNthNodeFromStartv2(ListNode head, int n) {

        if (head == null) return head;
        if (n == 0) return head.next;
        if (head.next != null)
            head.next = removeNthNodeFromStartv2(head.next, n - 1);
        return head;


    }


}
