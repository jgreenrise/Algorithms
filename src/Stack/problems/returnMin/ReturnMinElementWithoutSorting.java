package Stack.problems.returnMin;

import Stack.implementStack.Stack;

public class ReturnMinElementWithoutSorting implements Stack {

	public static void main(String args[]) {
		ReturnMinElementWithoutSorting numbers = new ReturnMinElementWithoutSorting();
		numbers.push(10);
		numbers.push(7);
		
		System.out.println(numbers.retrieveMin());
		numbers.push(30);
		numbers.push(5);
		System.out.println(numbers.retrieveMin());
		numbers.push(50);
		numbers.push(4);
		System.out.println(numbers.retrieveMin());
		numbers.push(40);
		numbers.push(2);
		System.out.println(numbers.retrieveMin());
		numbers.pop();
		numbers.pop();
		numbers.pop();
		numbers.pop();
		numbers.pop();
		System.out.println(numbers.retrieveMin());
		

	}

	private Node top;
	private int size;

	// Each Node object stores a single element of data in the linked list and
	// a link to another (possibly null) Node for the next piece of data.
	private class Node {
		private int min;
		private Object data;
		private Node next;

		// Constructs a new node to store the given data value.
		public Node(Object data) {
			this.data = data;
		}
	}

	public int min(){
		if(top == null){
			return Integer.MAX_VALUE; // Error value
		}else{
			return retrieveMin();
		}
	}

	@Override
	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.min = Math.min(Integer.parseInt(item.toString()), min());
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
	
	public int retrieveMin() {
		// TODO Auto-generated method stub
		return top.min;
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
