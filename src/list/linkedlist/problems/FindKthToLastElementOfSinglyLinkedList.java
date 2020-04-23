package list.linkedlist.problems;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;

/*
 * Input
 * a -> b-> c
 * 1st element form last c
 * 2nd element from last b
 */

public class FindKthToLastElementOfSinglyLinkedList {

	private static int ctr = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(10);
		list.addFirst(10);
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(7);
		list.addFirst(5);
		list.addFirst(10);
		list.addFirst(8);

		System.out.println("Input list");
		list.printList();

		// APPROACH 1: If size of linked list is known, we subtract length from
		// K
		System.out.println("\n Using linked list size");
		System.out.println("Find 2nd element from last"
				+ returnKthToLastElementFromLinkedList_approach1(list, 2));
		System.out.println("Find 3rd element from last"
				+ returnKthToLastElementFromLinkedList_approach1(list, 3));
		System.out.println("Find 1st element from last"
				+ returnKthToLastElementFromLinkedList_approach1(list, 7));

		// Approach using two pointers
		System.out.println("\n Using pointers");
		System.out.println("Find 2nd element from last"
				+ returnKthToLastElementFromLinkedList_usingPointers(list, 2));
		System.out.println("Find 3rd element from last"
				+ returnKthToLastElementFromLinkedList_usingPointers(list, 3));
		System.out.println("Find 1st element from last"
				+ returnKthToLastElementFromLinkedList_usingPointers(list, 7));

		// Approach using recursion
		System.out.println("\n Using recurcsion");
		ctr = 0;
		returnKthToLastElementFromLinkedList_usingRecurcsion(list.start, 2);

		ctr = 0;
		returnKthToLastElementFromLinkedList_usingRecurcsion(list.start, 3);

		ctr = 0;
		returnKthToLastElementFromLinkedList_usingRecurcsion(list.start, 7);
	}

	/**
	 * Approach 3: RECURCSIVE SOLUTION
	 * iLimtation: Doesnt return value
	 * 
	 */
	private static int returnKthToLastElementFromLinkedList_usingRecurcsion(
            ListNode node, int pos) {

		if (node != null) {
			returnKthToLastElementFromLinkedList_usingRecurcsion(
					node.next, pos);
			ctr++;
			if (pos == ctr) {
				System.out.println("Kth element from last" + node.val);
			}
		}
		return 0;
	}

	/**
	 * APPROACH 1: If size of linked list is known, we subtract length from K
	 */
	private static int returnKthToLastElementFromLinkedList_approach1(
			SinglyLinkedList list, int k) {

		int counter = 0;
		ListNode node = list.start;
		int size_of_linkedList = list.size;

		while (node.next != null) {
			if (counter == list.size - k) {
				break;
			}
			counter++;
			node = node.next;
		}

		return node.val;
	}

	/**
	 * APPROACH 2: Using pointers
	 */
	private static int returnKthToLastElementFromLinkedList_usingPointers(
			SinglyLinkedList list, int k) {

		if (k < 0 || list == null) {
			return 0;
		}

		ListNode p1 = list.start;
		ListNode p2 = list.start;

		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return 0;

			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1.val;
	}

}
