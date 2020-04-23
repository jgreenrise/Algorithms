package list.linkedlist.problems.sumList;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class SumLists {

    public static void main(String[] args) {
        //7 > 1 > 6,         //5 > 9 >2
        SinglyLinkedList list1 = SinglyLinkedList.createLL(new int[] {6, 1, 7});
        SinglyLinkedList list2 = SinglyLinkedList.createLL(new int[] {2, 9, 5});
        ListNode node = null;
        node = sumLL(list1.start, list2.start);
        System.out.println("Approach 1: Carry Over technique"); printLL(node);

        list1 = SinglyLinkedList.createLL(new int[] {6, 1, 7});
        list2 = SinglyLinkedList.createLL(new int[] {2, 9, 5});
        node = sumListUsingRecursion(list1.start, list2.start, 0);
        System.out.println("Approach 2: Recursion");    printLL(node);

        // 1 > 2 > 4,         // 9 > 9 > 7
        list1 = SinglyLinkedList.createLL(new int[] {4, 2,1});
        list2 = SinglyLinkedList.createLL(new int[] {7,9,9});
        node = sumLL(list1.start, list2.start);
        System.out.println("Approach 1: While LOOP");   printLL(node);

        list1 = SinglyLinkedList.createLL(new int[] {4, 2,1});
        list2 = SinglyLinkedList.createLL(new int[] {7,9,9});
        node = sumListUsingRecursion(list1.start, list2.start, 0);
        System.out.println("Approach 2: Recursion");    printLL(node);

        // 9 > 9 > 9
        list1 = SinglyLinkedList.createLL(new int[] {9,9,9});
        // 9 > 9 > 9
        list2 = SinglyLinkedList.createLL(new int[] {9,9,9});

        node = sumLL(list1.start, list2.start);
        System.out.println("Approach 1: Carry Over technique");
        printLL(node);

        node = sumListUsingRecursion(list1.start, list2.start, 0);
        System.out.println("Approach 2: Recursion");
        printLL(node);

    }

    private static ListNode sumLL(ListNode leftNode, ListNode rightNode) {

        int carryOver = 0;
        ListNode list3 = null;
        ListNode original = null;

        while (leftNode != null || rightNode != null) {

            int valueLeftNode, valueRightNode, tot = 0;

            if (leftNode == null) {
                valueLeftNode = 0;
            } else {
                valueLeftNode = leftNode.val;
                leftNode = leftNode.next;
            }

            if (rightNode == null) {
                valueRightNode = 0;
            } else {
                valueRightNode = rightNode.val;
                rightNode = rightNode.next;
            }

            tot = valueLeftNode + valueRightNode + carryOver;

            if (tot < 10) {
                carryOver = 0;

                if (list3 == null) {
                    list3 = new ListNode(tot);
                    original = list3;
                } else {
                    list3.next = new ListNode(tot);
                    list3 = list3.next;
                }

            } else {
                carryOver = 1;

                if (list3 == null) {
                    list3 = new ListNode(tot % 10);
                    original = list3;
                } else {
                    list3.next = new ListNode(tot % 10);
                    list3 = list3.next;
                }
            }
        }

        if(carryOver == 1){
            list3.next = new ListNode(1);
        }

        return original;
    }

    public static ListNode sumListUsingRecursion(ListNode left, ListNode right, int carryOver){

        if(left == null || right == null){
            return carryOver == 0 ? null : new ListNode(carryOver);
        }

        int total = left.val + right.val + carryOver;
        ListNode newNode = new ListNode(total % 10);
        carryOver = total < 10 ? 0 : 1;
        newNode.next = sumListUsingRecursion(left.next, right.next, carryOver);
        return newNode;

    }


}
