package list.linkedlist.doubly;

public class DoublyLinkedList {

	Node start;
	Node end;
	int size = 0;

	public DoublyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	/**********************************************************
	 * ADD
	 ***********************************************************/

	public void addFirst(int val) {
		Node newNode = new Node(val, null, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			start.prev_node = newNode;
			newNode.next_node = start;
			start = newNode;
		}

	}

	public void addLast(int val) {

		Node newNode = new Node(val, null, null);
		size++;

		if (start == null) {
			start = newNode;
			end = newNode;
		} else {
			end.next_node = newNode;
			newNode.prev_node = end;
			end = newNode;
		}

	}

	public void add(int index, int val) {

		Node newNode = new Node(val, null, null);
		Node pointer = start;

		if (index == 1) {
			addFirst(val);
			return;
		} else if (index == size) {
			addLast(val);
			return;
		}

		for (int i = 0; i < size; i++) {

			if (i == index) {
				
				Node tmp = pointer.prev_node;
				
				tmp.next_node = newNode;
				newNode.prev_node = tmp;
				newNode.next_node = pointer;
				pointer.prev_node = newNode;

				size++;
				break;

			}

			pointer = pointer.next_node;
		}

	}

	/**********************************************************
	 * REMOVE
	 ***********************************************************/

	public void removeFirst() {
		
		if(size == 1){
			start = null;
			end = null;
			size = 0;
			return;
		}
		
		start = start.next_node;
		size--;
	}

	public void removeLast() {
		
		if(size == 1){
			start = null;
			end = null;
			size = 0;
			return;
		}
		
		end = end.prev_node;
		end.next_node = null;
		size--;
	}

	public void removeAtIndex(int index) {
		
		if(index == 1){
			removeFirst();
			return;
		}else if(index == size){
			removeLast();
			return;
		}else{

			Node pointer = start;
			for(int i = 1; i<size; i++ ){
				
				if(i == index){
					(pointer.prev_node).next_node = pointer.next_node;
					(pointer.next_node).prev_node = pointer.prev_node;
					pointer = null;
					size --;
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

	}

	/**********************************************************
	 * IS EMPTY
	 ***********************************************************/

	public boolean isEmpty() {
		return start == null;
	}

	public class Node {
		int value;
		Node next_node, prev_node;

		public Node() {
			value = 0;
			next_node = null;
			prev_node = null;
		}

		public Node(int value, Node next_node, Node prev_node) {
			this.value = value;
			this.next_node = next_node;
			this.prev_node = prev_node;
		}
	}

}
