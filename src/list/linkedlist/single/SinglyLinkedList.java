package list.linkedlist.single;

public class SinglyLinkedList {

	public Node start;
	Node end;
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

		Node newNode = new Node(val, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			newNode.next_node = start;
			start = newNode;
		}

	}

	public void addLast(int val) {

		Node newNode = new Node(val, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			end.next_node = newNode;
			end = newNode;
		}

	}

	public void add(int index, int val) {

		Node newNode = new Node(val, null);
		Node pointer = start;

		for (int i = 1; i < (size + 1); i++) {

			if (index == 1) {
				addFirst(val);
				break;
			} else if (index == size) {
				addLast(val);
				break;
			} else {
				System.out.println("Index: " + i + ", pointer value: "
						+ pointer.value);

				if (i == index) {
					Node tmp = pointer.next_node;
					pointer.next_node = newNode;
					newNode.next_node = tmp;
					size++;
					break;
				}

				pointer = pointer.next_node;

			}
		}
	}

	/**********************************************************
	 * REMOVE
	 ***********************************************************/

	public void removeFirst() {

		if (start != null) {

			Node tmp = start.next_node;
			start = null;
			start = tmp;
			size--;

		}

	}

	public void removeLast() {

		Node pointer = start;
		for (int i = 1; i < size; i++) {

			if (i == size - 1) {
				pointer.next_node = null;
				size--;
				break;
			}
			pointer = pointer.next_node;
		}
	}

	public void removeAtIndex(int index) {

		Node pointer = start;

		for (int i = 1; i < (size + 1); i++) {

			if (index == 1) {
				removeFirst();
				break;
			} else if (index == size) {
				removeLast();
				break;
			} else {

				if (index == i) {
					System.out.println("***" + pointer.value);
					pointer.next_node = (pointer.next_node).next_node;
					size--;
					break;
				}

				pointer = pointer.next_node;

			}
		}

	}

	/**********************************************************
	 * PRINT
	 ***********************************************************/

	public void printList() {

		Node node = start;

		// System.out.println("list: ");

		while (node != null) {
			System.out.print(node.value + ", ");
			node = node.next_node;
		}
		System.out.println("Size: " + size);

		System.out.println("\n");

	}

	/**********************************************************
	 * IS EMPTY
	 ***********************************************************/

	public boolean isEmpty() {
		return start == null;
	}

}
