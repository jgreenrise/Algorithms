package list.linkedlist.problems;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.SinglyLinkedList.Node;

public class DeleteNodeFromCenterOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);

		System.out.println("Input list");
		list.printList();

		removeNodeFromCenterOfLinkedList(list, 30);

	}

	private static void removeNodeFromCenterOfLinkedList(SinglyLinkedList list,
			int node_to_be_removed) {

		Node node = list.start;

		while (node.next_node != null && node.value != node_to_be_removed) {
			node = node.next_node;
		}

		while (node.next_node != null) {
			node.value = (node.next_node).value;
			node.next_node = (node.next_node).next_node;
			break;

		}

		list.printList();

	}

}
