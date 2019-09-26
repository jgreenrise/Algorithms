package Stack.problems.stackOfStacks.usingArrayList;

import Stack.implementStack.Stack;

public class LinkedStack implements Stack {

	private Node top;
	private int size;
	private int capacity = 0;

	public LinkedStack(int capacity) {
		this.capacity = capacity;
	}

	private class Node {
		private Object data;
		private Node next;
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
		return top.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull(){
		return size == capacity;
	}

}
