package list.linkedlist.problems.duplicate;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;

/**
Input
1, 7, 6, 6, 1, 1, 2, 0, Size: 8

Output
0, 1, 2, 6, 7, 
 * 
 * Time complexity: O(nlgn)
 * 
 * Limitation
 * Order is not maintained
 * 
 */
public class RemoveDupsFromLinkedListUsingMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();

		// Add FIRST
		list.addFirst(0);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(1);
		list.addFirst(6);
		list.addFirst(6);
		list.addFirst(7);
		list.addFirst(1);

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

	public static ListNode mergeSort(ListNode node){

		if(node == null || node.next == null){
			return node;
		}

		ListNode slowPtr = node;
		ListNode orig = slowPtr;
		ListNode fastPtr = node;

		while(slowPtr != null && fastPtr != null && slowPtr.next != null && fastPtr.next.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		ListNode left = orig;
		ListNode right = slowPtr.next;
		slowPtr.next = null;

		mergeSort(left);
		mergeSort(right);

		return mergeLinkedList(left, right);

	}

	public static ListNode mergeSort2(ListNode node) {

		if (node == null || node.next == null) {
			return node;
		}

		ListNode middle = getMiddle(node);
		ListNode right = middle.next;

		// Do this to make sure that left list only travels till midpoint
		middle.next = null;
		return mergeLinkedList(mergeSort(node), mergeSort(right));
	}

	public static ListNode getMiddle(ListNode node) {

		if (node == null || node.next == null)
			return node;

		ListNode slow, fast = null;
		slow = fast = node;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
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
		} else if (left.val < right.val) {
			left.next = mergeLinkedList(left.next, right);
			return left;
		} else {
			if (left.next != null) {
				left = mergeLinkedList(left.next, right);
				return left;
			} else if (right.next != null) {
				right = mergeLinkedList(left, right.next);
				return right;
			} else{
				return left;
			}
		}

	}
}
