package list.linkedlist.problems;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;

import static list.linkedlist.single.ListNode.printLL;

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
		ListNode node = removeNodeFromCenterOfLinkedList(list, 30);
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

	private static ListNode removeNodeFromCenterUsingPonter(ListNode start) {

		ListNode slow = start;


		ListNode fast = slow;
		ListNode slowParent = slow;
		ListNode original = slow;

		while(slow.next != null && fast.next != null){
			slowParent = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		slowParent.next = slow.next;
		return original;

	}

	private static ListNode removeNodeFromCenterOfLinkedList(SinglyLinkedList list, int nodeToBeDeleted) {

		ListNode original = list.start;
		ListNode node = original;

		while (node.next != null) {
			if(node.next.val == nodeToBeDeleted){
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}

		return original;

	}

}
