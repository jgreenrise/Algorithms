package list.linkedlist;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;


/**
 * This is a programming question asked during a written test for an interview. "You have two singly linked lists that are already sorted, you have to merge them and return a the head of the new list without creating any new extra nodes. The returned list should be sorted as well"

The method signature is: Node MergeLists(Node list1, Node list2);

Node class is below:

class Node{
    int data;
    Node next;
}
 *
 */
public class SortTwoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();
		list.addLast(10);
		list.addLast(24);
		list.addLast(62);
		System.out.println("Input list 1");
		list.printList();

		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.addLast(1);
		list2.addLast(13);
		list2.addLast(20);
		System.out.println("Input list 2");
		list2.printList();

		ListNode output = mergeLinkedList(
				list.start, list2.start);

		System.out.println("Output");
		while (output != null) {
			System.out.print(output.val + ", ");
			output = output.next;
		}

	}

	public static ListNode mergeLinkedList(
			ListNode left,
			ListNode right) {

		if (left == null)
			return right;
		if (right == null)
			return left;

		if (left.val > right.val) {
			
			/**
			 * Order of argument doesn't matter. It can be vice versa too.
			 */
			right.next = mergeLinkedList(left, right.next);
			return right;
		} else {
			left.next = mergeLinkedList(left.next, right);
			return left;
		}
	}

}
