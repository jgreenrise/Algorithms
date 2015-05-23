package list.linkedlist.problems.duplicate;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.Node;

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

		Node output = mergeSort(list.start);

		System.out.println("Output");
		while (output != null) {
			System.out.print(output.value + ", ");
			output = output.next_node;
		}

	}

	/**********************************************************
	 * SORT A LINKED LIST
	 ***********************************************************/

	public static Node mergeSort(Node node) {

		if (node == null || node.next_node == null) {
			return node;
		}

		Node middle = getMiddle(node);
		Node right = middle.next_node;

		// Do this to make sure that left list only travels till midpoint
		middle.next_node = null;
		return mergeLinkedList(mergeSort(node), mergeSort(right));
	}

	public static Node getMiddle(Node node) {

		if (node == null || node.next_node == null)
			return node;

		Node slow, fast = null;
		slow = fast = node;

		while (fast.next_node != null && fast.next_node.next_node != null) {
			slow = slow.next_node;
			fast = fast.next_node;
		}

		return slow;
	}

	private static Node mergeLinkedList(Node left, Node right) {

		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		if (left.value > right.value) {
			right.next_node = mergeLinkedList(left, right.next_node);
			return right;
		} else if (left.value < right.value) {
			left.next_node = mergeLinkedList(left.next_node, right);
			return left;
		} else {
			if (left.next_node != null) {
				left = mergeLinkedList(left.next_node, right);
				return left;
			} else if (right.next_node != null) {
				right = mergeLinkedList(left, right.next_node);
				return right;
			} else{
				return left;
			}
		}

	}
}
