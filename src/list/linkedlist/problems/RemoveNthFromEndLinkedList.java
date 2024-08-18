package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.ListNode.printLL;

public class RemoveNthFromEndLinkedList {

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
		ListNode node = null;
				//removeNodeFromCenterOfLinkedList(list, 30);
		System.out.println("Approach 1");
		//printLL(node);

		// Center node not given
		list = new SinglyLinkedList();
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		node = removeNthFromEnd(list.start, 2);
		printLL(node);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode curr = head;
		ListNode slow = curr;
		ListNode fast = traverseByN(head, n);

		while(fast.next!= null){
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return head;
	}

	public static ListNode traverseByN(ListNode node, int n){
		for(int j = 0; j < n ; j++){
			if(node.next != null){
				node = node.next;
			}else{
				return null;
			}
		}
		return node;
	}


}
