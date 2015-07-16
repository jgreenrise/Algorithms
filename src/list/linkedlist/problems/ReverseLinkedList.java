package list.linkedlist.problems;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;


/**
 * Output
 * 
 * Index: 1, pointer value: 100
Index: 2, pointer value: 62
------------ APPROACH 1: using seperate linked list ---------------
Input list: 
100 -> 62 -> 250 -> 24 -> 10 -> 98 -> 26 -> 67 -> 200 -> Size: 9


Output list 
200 -> 67 -> 26 -> 98 -> 10 -> 24 -> 250 -> 62 -> 100 -> Size: 9


------------ APPROACH 2: using recurcsion ---------------
Input list: 
200 -> 67 -> 26 -> 98 -> 10 -> 24 -> 250 -> 62 -> 100 -> Size: 9


100 -> 62
62 -> 250
250 -> 24
24 -> 10
10 -> 98
98 -> 26
26 -> 67
67 -> 200
------------ APPROACH 3: using iteration ---------------
Input list: 
10 -> 20 -> 30 -> 40 -> Size: 4


Output list
40 -> 30 -> 20 -> 10 -> 
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();

		// Add FIRST
		list.addFirst(10);
		list.addFirst(24);
		list.addFirst(62);
		list.addLast(98);
		list.addLast(26);
		list.addLast(67);
		list.add(1, 100);
		list.add(7, 200);
		list.add(2, 250);

		System.out
				.println("------------ APPROACH 1: using seperate linked list ---------------");

		System.out.println("Input list: ");
		list.printList();

		list = reverseLinkedList_usingExtraLInkedList(list);

		System.out.println("Output list ");
		list.printList();

		System.out
				.println("------------ APPROACH 2: using recurcsion ---------------");

		System.out.println("Input list: ");
		list.printList();

		Node response = reverseNode_usingRecursion(list.start);

		System.out
				.println("------------ APPROACH 3: using iteration ---------------");

		System.out.println("Input list: ");

		list = new SinglyLinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);

		list.printList();

		Node response2 = reverseLinkedList_iterativeApproach(list.start);

		System.out.println("Output list");

		while (response2 != null) {
			System.out.print(response2.value + " -> ");
			response2 = response2.next_node;
		}

	}

	/**
	 * CREATE A SEPERATE LINKED LIST AND KEEP ON ADDING ITEMS AT THE FIRST OF
	 * NEWLY CREATED LINKEDLIST
	 * 
	 * Time complexity: O(n) Space complexity: O(n)
	 */
	private static SinglyLinkedList reverseLinkedList_usingExtraLInkedList(
			SinglyLinkedList list) {

		Node node = list.start;
		SinglyLinkedList reverse = new SinglyLinkedList();

		while (node.next_node != null) {
			reverse.addFirst(node.value);
			node = node.next_node;
		}

		reverse.addFirst(node.value);

		return reverse;
	}

	/**
	 * RECURSION SOLUTION
	 * 
	 * Reach to the end of list and then modify the reference to the next
	 * pointer starting from the end of list.
	 * 
	 * Time complexity: O(n) Space complexity: O(1)
	 * 
	 * ** Limitation **
	 * We have reference to TAIL of linked list and loose the reference of head of node
	 */
	private static Node reverseNode_usingRecursion(Node node) {

		if (node != null && node.next_node != null) {

			Node tmp = reverseNode_usingRecursion(node.next_node);

			// Remove previous references if any
			tmp.next_node = null;
			node.next_node = null;

			tmp.next_node = node;
			System.out.println(tmp.value + " -> " + tmp.next_node.value);
			return tmp.next_node;

		} else {
			return node;
		}
	}

	/**
	 * ITERATIVE SOLUTION
	 * 
	 * 10 -> 20 -> 30 -> 40
	 * 
	 * Using 2 pointers (next and prev next) and loop through entire list.
	 * Time complexity: O(n) Space complexity: O(1)
	 * 
	 * Advantage
	 * We have reference to the head of list
	 */
	private static Node reverseLinkedList_iterativeApproach(Node node) {

		Node next = null;
		Node prev_next = null;

		while (node.next_node != null) {

			prev_next = node.next_node; // 20, 30, 40
			node.next_node = next; // 10.next = null, 20.next = 10, 30.next =
									// 20,
			next = node; // 10, 20 30
			node = prev_next; // node = 20, 30 40

		}
		node.next_node = next;

		return node;

	}

}
