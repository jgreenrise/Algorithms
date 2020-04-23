package list.linkedlist.problems.duplicate;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import java.util.LinkedHashSet;

public class RemoveDupsRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();

		// Add FIRST
		list.addFirst(300);
		list.addFirst(200);
		list.addFirst(100);
		list.addFirst(200);
		list.addFirst(400);
		list.addFirst(300);
		list.addFirst(200);
		list.addFirst(100);

		System.out.println("Input");
		list.printList();

		ListNode node = removeDupsUsingRecursion(list.start);
		printLL(node);

	}

	private static ListNode removeDupsUsingRecursion(ListNode start) {

		// 1. Assign a parent Node
		ListNode parent = start;
		while(parent.next != null){

			// 2. Remove dups from child nodes using recursion
			parent.next = removeDupsFromRemainingNodes(parent.val, parent.next);

			// 3. Assign next node as parent Node.
			parent = parent.next;
		}
		return start;

	}

	private static ListNode removeDupsFromRemainingNodes(int value, ListNode node) {

		if(node == null)
			return null;

		if(node.val == value)
			return removeDupsFromRemainingNodes(value, node.next);

		node.next = removeDupsFromRemainingNodes(value, node.next);
		return node;
	}

	public static void printLL(ListNode node){
		while(node.next != null){
			System.out.print(node.val + " > ");
			node = node.next;
		}
		System.out.println(node.val);
	}

}
