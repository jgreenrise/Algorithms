package list.linkedlist.problems.duplicate;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

import java.util.Iterator;
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

		Node node = removeDupsUsingRecursion(list.start);
		printLL(node);

	}

	private static Node removeDupsUsingRecursion(Node start) {

		// 1. Assign a parent Node
		Node parent = start;
		while(parent.next_node != null){

			// 2. Remove dups from child nodes using recursion
			parent.next_node = removeDupsFromRemainingNodes(parent.value, parent.next_node);

			// 3. Assign next node as parent Node.
			parent = parent.next_node;
		}
		return start;

	}

	private static Node removeDupsFromRemainingNodes(int value, Node node) {

		if(node == null)
			return null;

		if(node.value == value)
			return removeDupsFromRemainingNodes(value, node.next_node);

		node.next_node = removeDupsFromRemainingNodes(value, node.next_node);
		return node;
	}

	public static void printLL(Node node){
		while(node.next_node != null){
			System.out.print(node.value + " > ");
			node = node.next_node;
		}
		System.out.println(node.value);
	}

}
