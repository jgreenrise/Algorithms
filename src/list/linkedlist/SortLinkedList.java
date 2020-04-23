package list.linkedlist;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;

/**
 * Input
6, 1, 1, 2, 0, Size: 5


Output
0, 1, 1, 2, 6, 
 * 
 */
public class SortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();

		// Add FIRST
		list.addFirst(0);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(1);
		list.addFirst(6);
		// list.addFirst(7);
		// list.addFirst(5);
		// list.addFirst(4);

		System.out.println("Input");
		list.printList();

		ListNode output = mergeSort(list.start);

		System.out.println("Output");
		while (output != null) {
			System.out.print(output.val + ", ");
			output = output.next;
		}

	}

	/**********************************************************
	 * SORT A LINKED LIST
	 ***********************************************************/

	public static ListNode mergeSort(ListNode node) {

		if (node == null || node.next == null) {
			return node;
		}

		ListNode middle = getMiddle(node);
		ListNode right = middle.next;

		// Do this to make sure that left list only travels till midpoint
		middle.next = null;
		
//		Node tmp = node;
//		System.out.println("\nLeft: ");
//		while (tmp != null) {
//			System.out.print(tmp.value + " -> ");
//			tmp = tmp.next_node;
//		}
//
//		tmp = right;
//		System.out.println("\nRight: ");
//		while (tmp != null) {
//			System.out.print(tmp.value + " -> ");
//			tmp = tmp.next_node;
//		}

		return mergeLinkedList(mergeSort(node), mergeSort(right));
	}

	public static ListNode getMiddle(ListNode node) {

		if (node == null || node.next == null)
			return node;

		ListNode slow, fast = null;
		slow = fast = node;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private static ListNode mergeLinkedList(ListNode left, ListNode right) {

		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		if (left.val > right.val) {
			right.next = mergeLinkedList(left, right.next);
			return right;
		} else {
			left.next = mergeLinkedList(left.next, right);
			return left;
		}

	}

}
