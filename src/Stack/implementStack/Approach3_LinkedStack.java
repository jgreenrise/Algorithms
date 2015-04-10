package Stack.implementStack;

public class Approach3_LinkedStack implements Stack {

	private Node top;
	private int size;

	// Each Node object stores a single element of data in the linked list and
	// a link to another (possibly null) Node for the next piece of data.
	private class Node {
		private Object data;
		private Node next;

		// Constructs a new node to store the given data value.
		public Node(Object data) {
			this.data = data;
		}
	}

	@Override
	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.next = top;
		top = newNode;
		size++;
	}

	@Override
	public Object pop() {
		Object nodeToBePoppedOut = top.data; // Get node value
		top = top.next;
		size--;
		return nodeToBePoppedOut;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return top.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

}
