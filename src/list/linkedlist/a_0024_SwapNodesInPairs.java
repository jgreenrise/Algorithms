package list.linkedlist;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;


/**
 * This is a programming question asked during a written test for an interview. "You have two singly linked lists that are already sorted, you have to merge them and return a the head of the new list without creating any new extra nodes. The returned list should be sorted as well"
 * <p>
 * The method signature is: Node MergeLists(Node list1, Node list2);
 * <p>
 * Node class is below:
 * <p>
 * class Node{
 * int data;
 * Node next;
 * }
 */
public class a_0024_SwapNodesInPairs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("Input list 1");
        list.printList();

        ListNode output = swapPairs(list.start);

        System.out.println("Output");
        while (output != null) {
            System.out.print(output.val + ", ");
            output = output.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {

        // 1->null, null
        if (head == null || head.next == null)
            return head;

        // 1 -> 2-> null;
        if (head.next.next == null) {
            ListNode currHead = head.next.next;
            currHead.next = head;
            head.next = null;
            return currHead; // 2 > 1 > null
        }

        // 1 > 2 > 3 > 4
        ListNode prev = head;       //  1
        ListNode curr = head.next;  //  2
        ListNode currHead = null;   //  n
        ListNode newHead = null;    //  n
        ListNode next = curr.next;  //  3

        while (next != null) {

            if (prev.next != null) {
                // we have a pair
                next = curr.next;       //  3           null
                curr.next = null;       //  2.n = n     4.n = n
                curr.next = prev;       //  2.n = 1     4.n = 3
                if (newHead == null) {
                    newHead = curr;     //  2
                    currHead = prev;    //  1
                } else {
                    currHead.next = curr;   //          1.n = 4
                    currHead = prev;        //          3
                }
                prev = next;            //  3           null
                curr = prev != null && prev.next != null ? prev.next : null;     //  4
            } else {
                // one node left
                currHead.next = next;
            }
        }

        return newHead;


    }

}
