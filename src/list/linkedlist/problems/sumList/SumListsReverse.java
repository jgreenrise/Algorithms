package list.linkedlist.problems.sumList;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class SumListsReverse {

    public static void main(String[] args) {
        // 6 > 1 > 7
        SinglyLinkedList list1 = SinglyLinkedList.createLL(new int[] {7,1,6});
        // 2 > 9 > 5
        SinglyLinkedList list2 = SinglyLinkedList.createLL(new int[] {5,9,2});

        // O/P = 9 > 1 > 2

        ListNode node = null;
        node = sumLL(list1.start, list2.start);
        System.out.println("Recursion");
        printLL(node);

    }

    private static ListNode sumLL(ListNode leftNode, ListNode rightNode) {

        if(leftNode == null || rightNode == null)
            return null;

        int carryOver = 0;
        ListNode newNode = new ListNode();
        newNode.next = sumLL(leftNode.next, rightNode.next);

        if(newNode.next == null){
            carryOver = 0;
        }else{
            int totalOfNextNode = newNode.next.val;
            if (totalOfNextNode > 9){

                newNode.next.val = totalOfNextNode % 10;
                carryOver = 1;
            }
        }

        newNode.val = leftNode.val + rightNode.val + carryOver;
        return newNode;
    }


}
