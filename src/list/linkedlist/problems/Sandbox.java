package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class Sandbox {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SinglyLinkedList list = null;
        list = SinglyLinkedList.createLL(new int[] {3,5,10,2,8,2,1});
        System.out.println("------------ APPROACH 1: using separate linked list ---------------");
        System.out.println("Input list: ");
        list.printList();
        ListNode output = partition(list.start, 5);
        System.out.println("Output list ");
        list.printList();

    }

    public static ListNode partition(ListNode node, int x) {

        return partition2(node, x);

    }

    public static ListNode partition2(ListNode node, int x)
    {
        ListNode left = null;
        ListNode right = null;
        ListNode center = null;

        if(node == null)
            return null;

        if(node.val < x){
            left = new ListNode(node.val);
            left.next = partition2(node.next,  x);
            return left;
        }else if(node.val > x){
            right = new ListNode(node.val);
            right.next = partition2(node.next,  x);
            return right;
        }else{
            center = new ListNode(node.val);
            center.next = partition2(node.next,  x);
            return center;
        }

    }
}
