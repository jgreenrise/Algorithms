package list.linkedlist.problems;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.Node;

import static list.linkedlist.single.Node.printLL;

public class DeleteNodeFromCenterOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();

		// Node to be deleted is given
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
		System.out.println("Input list");
		list.printList();
		Node node = removeNodeFromCenterOfLinkedList(list, 30);
		System.out.println("Approach 1");
		printLL(node);

		// Center node not given
		list = new SinglyLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
		node = removeNodeFromCenterUsingPonter(list.start);
		System.out.println("Approach 2");
		printLL(node);


	}

	private static Node removeNodeFromCenterUsingPonter(Node start) {

		Node slow = start;


		Node fast = slow;
		Node slowParent = slow;
		Node original = slow;

		while(slow.next_node != null && fast.next_node != null){
			slowParent = slow;
			slow = slow.next_node;
			fast = fast.next_node.next_node;
		}

		slowParent.next_node = slow.next_node;
		return original;

	}

	private static Node removeNodeFromCenterOfLinkedList(SinglyLinkedList list, int nodeToBeDeleted) {

		Node original = list.start;
		Node node = original;

		while (node.next_node != null) {
			if(node.next_node.value == nodeToBeDeleted){
				node.next_node = node.next_node.next_node;
				break;
			}
			node = node.next_node;
		}

		return original;

	}

}
