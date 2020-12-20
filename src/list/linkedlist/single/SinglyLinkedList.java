package list.linkedlist.single;

public class SinglyLinkedList {

	public ListNode start;
	ListNode end;
	public int size = 0;

	public SinglyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public static SinglyLinkedList createLL(int[] items) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.start = null;
		list.end = null;
		list.size = items.length;

		for (int item: items) {
			list.addFirst(item);
		}
		return list;
	}

	/**********************************************************
	 * ADD
	 ***********************************************************/

	public void addFirst(int val) {

		ListNode newNode = new ListNode(val, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			newNode.next = start;
			start = newNode;
		}

	}

	public void addLast(int val) {

		ListNode newNode = new ListNode(val, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			end.next = newNode;
			end = newNode;
		}

	}

	public void add(int index, int val) {

		ListNode newNode = new ListNode(val, null);
		ListNode pointer = start;

		for (int i = 1; i < (size + 1); i++) {

			if (index == 1) {
				addFirst(val);
				break;
			} else if (index == size) {
				addLast(val);
				break;
			} else {
				System.out.println("Index: " + i + ", pointer value: "
						+ pointer.val);

				if (i == index) {
					ListNode tmp = pointer.next;
					pointer.next = newNode;
					newNode.next = tmp;
					size++;
					break;
				}

				pointer = pointer.next;

			}
		}
	}

	/**********************************************************
	 * REMOVE
	 ***********************************************************/

	public void removeFirst() {

		if (start != null) {

			ListNode tmp = start.next;
			start = null;
			start = tmp;
			size--;

		}

	}

	public void removeLast() {

		ListNode pointer = start;
		for (int i = 1; i < size; i++) {

			if (i == size - 1) {
				pointer.next = null;
				size--;
				break;
			}
			pointer = pointer.next;
		}
	}

	public void removeAtIndex(int index) {

		ListNode pointer = start;

		for (int i = 1; i < (size + 1); i++) {

			if (index == 1) {
				removeFirst();
				break;
			} else if (index == size) {
				removeLast();
				break;
			} else {

				if (index == i) {
					System.out.println("***" + pointer.val);
					pointer.next = (pointer.next).next;
					size--;
					break;
				}

				pointer = pointer.next;

			}
		}

	}

	/**********************************************************
	 * PRINT
	 ***********************************************************/

	public void printList() {

		ListNode node = start;

		// System.out.println("list: ");

		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}

		System.out.println("\n");

	}

	public String printLL() {

		ListNode node = start;
		StringBuilder sbr = new StringBuilder();

		while (node != null) {
			sbr.append(node.val +" ");
			node = node.next;
		}

		return sbr.reverse().toString();
	}

	/**********************************************************
	 * IS EMPTY
	 ***********************************************************/

	public boolean isEmpty() {
		return start == null;
	}

}
