package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;


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

		SinglyLinkedList list = null;
		list = SinglyLinkedList.createLL(new int[] {50, 40, 30, 20, 10});
		System.out.println("------------ APPROACH 1: using separate linked list ---------------");
		System.out.println("Input list: ");
		list.printList();
		list = reverseLinkedList_usingExtraLInkedList(list);
		System.out.println("Output list ");
		list.printList();

		System.out.println("------------ APPROACH 2: using recurcsion ---------------");
		list = SinglyLinkedList.createLL(new int[] {50, 40, 30, 20, 10});
		System.out.println("Input list: ");
		list.printList();
		ListNode response = reverseNode_usingRecursion(list.start);
		printLL(response);

		System.out.println("------------ APPROACH 3: using iteration ---------------");
		System.out.println("Input list: ");
		list = SinglyLinkedList.createLL(new int[] {50, 40, 30, 20, 10});
		list.printList();
		ListNode response2 = reverseLinkedList_iterativeApproach(list.start);
		System.out.println("Output list");
		printLL(response2);

		System.out.println("------------ APPROACH 4: using recursion ---------------");
		System.out.println("Input list: ");
		list = SinglyLinkedList.createLL(new int[] {50, 40, 30, 20, 10});
		list.printList();
		response = reverseRecursion(list.start, null);
		System.out.println("Output list");
		printLL(response);

	}

	/**
	 * CREATE A SEPERATE LINKED LIST AND KEEP ON ADDING ITEMS AT THE FIRST OF
	 * NEWLY CREATED LINKEDLIST
	 * 
	 * Time complexity: O(n) Space complexity: O(n)
	 */
	private static SinglyLinkedList reverseLinkedList_usingExtraLInkedList(
			SinglyLinkedList list) {

		ListNode node = list.start;
		SinglyLinkedList reverse = new SinglyLinkedList();

		while (node.next != null) {
			reverse.addFirst(node.val);
			node = node.next;
		}

		reverse.addFirst(node.val);

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
	private static ListNode reverseNode_usingRecursion(ListNode node) {

		if (node != null && node.next != null) {

			ListNode tmp = reverseNode_usingRecursion(node.next);

			// Remove previous references if any
			tmp.next = null;
			node.next = null;

			tmp.next = node;
			System.out.println(tmp.val + " -> " + tmp.next.val);
			return tmp.next;


		} else {
			return node;
		}
	}

	/**
	 * RECURSION SOLUTION
	 *
	 * Recursion using two nodes.. Head and reversed node.
	 *
	 * Time complexity: O(n) Space complexity: O(n)
	 *
	 * ** Limitation **
	 * Need 2 nodes
	 */
	public static ListNode reverseRecursion(ListNode node, ListNode rvNode){

		if(node == null)
			return rvNode;

		ListNode newNode = new ListNode(node.val);

		if(rvNode == null){
			return reverseRecursion(node.next, newNode);
		}else{
			newNode.next = rvNode;
			return reverseRecursion(node.next, newNode);
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
	private static ListNode reverseLinkedList_iterativeApproach(ListNode node) {

		ListNode next = null;
		ListNode prev_next = null;

		while (node.next != null) {

			prev_next = node.next; // 20, 30, 40
			node.next = next; // 10.next = null, 20.next = 10, 30.next =
									// 20,
			next = node; // 10, 20 30
			node = prev_next; // node = 20, 30 40

			System.out.println(prev_next.val +" > "+node.val +" > "+next.val +" > "+prev_next.val);

		}
		node.next = next;

		return node;

	}

}
