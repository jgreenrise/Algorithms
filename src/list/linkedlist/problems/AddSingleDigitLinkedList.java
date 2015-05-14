package list.linkedlist.problems;

import list.linkedlist.single.Node;
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

	public static void printList(Node start) {

		Node node = start;

		while (node != null) {
			System.out.print(node.value + ", ");
			node = node.next_node;
		}

		System.out.println("\n");

	}

	public static Node addLinkedList(Node left, Node right) {

		int carry = 0;
		Node response = null;
		Node node = null;
		int sum = 0;
		Node top = null;

		while (left != null || right != null || carry != 0) {

			sum = 0;

			if (left != null && right != null) {
				sum = left.value + right.value;
				left = left.next_node;
				right = right.next_node;
			} else if (left == null && right != null) {
				sum = right.value;
				right = right.next_node;
			} else if (left != null && right == null) {
				sum = left.value;
				left = left.next_node;
			}else{
				
			}

			node = new Node((sum + carry) % 10, null);

			if (sum + carry / 10 > 0)
				carry = sum / 10;
			else
				carry = 0;

			if (response == null) {
				response = node;
				top = node;
			} else {
				response.next_node = node;
				response = response.next_node;
			}

		}
		
		return top;

	}

}
