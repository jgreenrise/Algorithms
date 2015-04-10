package list.linkedlist.circular;

import list.linkedlist.single.SinglyLinkedList.Node;

public class CircularLinkedList {

	Node start;
	Node end;
	int size;

	public CircularLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	/**********************************************************
	 * ADD
	 ***********************************************************/

	public void addFirst(int val) {
		Node newNode = new Node(val, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			newNode.next = start;
			start = newNode;
		}
		end.next = start;
	}

	public void addLast(int val) {
		Node newNode = new Node(val, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			end.next = newNode;
			end = newNode;
		}
		end.next = start;
	}

	public void add(int index, int val) {
		// TODO Auto-generated method stub

		Node newNode = new Node(val, null);
		Node pointer = start;

		if (index == 1) {
			addFirst(val);
			return;
		} else if (index == size) {
			addLast(val);
			return;
		}

		for (int i = 1; i < size; i++) {
			if (i == index) {
				Node tmp = pointer.next;
				pointer.next = newNode;
				newNode.next = tmp;
				size++;
				break;
			}

			pointer = pointer.next;
		}

	}

	/**********************************************************
	 * REMOVE
	 ***********************************************************/

	public void removeFirst() {
		if (start != null) {
			Node tmp = start.next;
			start = null;
			start = tmp;
			end.next = start;
			size--;
		}
	}

	public void removeLast() {
		Node pointer = start;
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				pointer.next = null;
				pointer.next = start;
				size--;
				break;
			}
			pointer = pointer.next;
		}
	}
	
	public void removeAtIndex(int index) {Node pointer = start;

	for (int i = 1; i < (size + 1); i++) {

		if (index == 1) {
			removeFirst();
			break;
		} else if (index == size) {
			removeLast();
			break;
		} else {

			if (index == i) {
				pointer.next= (pointer.next).next;
				size--;
				break;
			}

			pointer = pointer.next;

		}
	}}

	public void printList() {
		Node pointer = start;

		System.out.print("Size: " + size + ", List: ");
		for (int i = 0; i < size; i++) {
			System.out.print(pointer.value + ", ");
			pointer = pointer.next;
		}
		System.out.println("");
	}

	public class Node {

		public int value;
		public Node next;

		public Node() {
			super();
		}

		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
	}

}
