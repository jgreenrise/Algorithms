package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

/**
8, 0, 8, 
8, 0, 9, 1, 
 */
public class AddSingleDigitLinkedList {

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(5);
		list.addFirst(1);
		list.addFirst(3);

		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.addFirst(2);
		list2.addFirst(9);
		list2.addFirst(5);

		printList(addLinkedList(list.start, list2.start));
		
		list = new SinglyLinkedList();
		list.addFirst(9);
		list.addFirst(1);
		list.addFirst(3);

		list2 = new SinglyLinkedList();
		list2.addFirst(9);
		list2.addFirst(9);
		list2.addFirst(5);

		printList(addLinkedList(list.start, list2.start));
	}
	
	/**********************************************************
	 * PRINT
	 **********************************************	*************/

	public static void printList(ListNode start) {

		ListNode node = start;

		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}

		System.out.println("\n");

	}

	public static ListNode addLinkedList(ListNode left, ListNode right) {

		int carry = 0;
		ListNode response = null;
		ListNode node = null;
		int sum = 0;
		ListNode top = null;

		while (left != null || right != null || carry != 0) {

			sum = 0;

			if (left != null && right != null) {
				sum = left.val + right.val;
				left = left.next;
				right = right.next;
			} else if (left == null && right != null) {
				sum = right.val;
				right = right.next;
			} else if (left != null && right == null) {
				sum = left.val;
				left = left.next;
			}else{
				
			}

			node = new ListNode((sum + carry) % 10, null);

			if (sum + carry / 10 > 0)
				carry = sum / 10;
			else
				carry = 0;

			if (response == null) {
				response = node;
				top = node;
			} else {
				response.next = node;
				response = response.next;
			}

		}
		
		return top;

	}

}
