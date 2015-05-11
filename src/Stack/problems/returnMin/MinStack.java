package Stack.problems.returnMin;

import Stack.implementStack.Stack;

/***
 * Approach 1: Modify push operation, to that stack is sorted
 * Time complexity of push operation : O(n)
 * 
Pop: 1
Pop: 5
Pop: 7
Pop: 10
Pop: 20
Pop: 30
Pop: 40
Pop: 50
 */
public class MinStack implements Stack {

	public static void main(String args[]) {
		MinStack numbers = new MinStack();
		numbers.push(10);
		numbers.push(5);
		numbers.push(30);
		numbers.push(1);
		numbers.push(50);
		numbers.push(7);
		numbers.push(40);
		numbers.push(20);

		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
		System.out.println("Pop: " + numbers.pop());
	}

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
		Node tmp = null;

		if (top != null && item != null && Integer.parseInt(newNode.data.toString()) > Integer.parseInt((top.data.toString()))) {

			Node node = top;

			while (node.next != null && Integer.parseInt((node.next).data.toString()) < Integer.parseInt(newNode.data.toString())) {
				node = node.next;
			}

			if (node.next == null) {
				// Add it to tail
				node.next = newNode;
			} else {
				// Add it in center
				tmp = node.next;
				newNode.next = tmp;
				node.next = newNode;

			}

		} else {
			
			// Add new node to top
			newNode.next = top;
			top = newNode;
		}

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
