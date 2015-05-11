package Stack.problems;

import java.util.NoSuchElementException;

import Stack.implementStack.Approach1_LinkedListApproach;
import Stack.implementStack.Stack;

/*-
 * We store additional info in 
 * 1. index array, which stores info about the index(k) of each stack.
 * 2. We create array of custom Object Node. This node stores its data, as well as its priority(K)
 * 3. We store final stack in array of Nodes.
 */
public class SingleArrayForKStacks implements Stack {

	static SingleArrayForKStacks stack = new SingleArrayForKStacks(6, 3);
	Stack buffer = new Approach1_LinkedListApproach();
	Node[] array;
	int size = 0;
	int[] index_end = null;

	public static void main(String args[]) {
		stack.push(10, 3);
		stack.push(60, 1);
		stack.push(50, 2);
		stack.push(40, 1);
		stack.push(70, 3);
		stack.push(30, 2);

		System.out.println("Peek from stack 3 " + ((Node) stack.peek(3)).data);
		System.out.println("Peek from stack 2 " + ((Node) stack.peek(2)).data);
		System.out.println("Peek from stack 1 " + ((Node) stack.peek(1)).data);

		System.out.println("Pop from stack 2 "+ ((Node) stack.pop(2)).data);
		System.out.println("Pop from stack 2 "+ ((Node) stack.pop(2)).data);
		
		System.out.println("Pop from stack 3 "+ ((Node) stack.pop(3)).data);
		System.out.println("Pop from stack 1 "+ ((Node) stack.pop(1)).data);
	}

	private class Node {
		private int data;
		private int priority;

		// Constructs a new node to store the given data value.
		public Node(int data) {
			this.data = data;
		}
	}

	public SingleArrayForKStacks(int size, int i_number_of_stacks) {
		super();
		array = new Node[size];
		index_end = new int[i_number_of_stacks];
	}

	@Override
	public void push(Object item) {
		if (size == array.length) {
			throw new IllegalStateException("Cannot add to full stack");
		}
		array[size++] = (Node) item;
	}

	private void push(int value, int priority) {

		if (size == array.length) {
			throw new IllegalStateException("Cannot add to full stack");
		}

		priority = priority - 1;
		Node newNode = new Node(value);
		newNode.priority = priority;
		Node nodePopped = null;

		if (size == 0) {
			index_end[priority] = size + 1;
			push(newNode);
		} else {

			// Remove low priority values from stack
			while (!(stack.isEmpty())
					&& ((Node) (stack.peek())).priority > priority) {
				nodePopped = (Node) stack.pop();
				index_end[nodePopped.priority] = 0;
				buffer.push(nodePopped);
			}

			// Add new node to stack.
			index_end[priority] = size + 1;
			stack.push(newNode);

			// Add values back to stack from buffer
			while (!(buffer.isEmpty())) {
				nodePopped = (Node) buffer.pop();
				index_end[nodePopped.priority] = size + 1;
				stack.push(nodePopped);
			}
		}
	}

	private Node pop(int priority) {
		Node node_to_be_removed = null;
		if (size == 1) {
			node_to_be_removed = (Node) pop();
		} else {

			if (index_end[priority-1] > 0) {

				node_to_be_removed = array[index_end[priority - 1] - 1];

				int i = 0;
				for (i = index_end[priority - 1]-1; i+1 < size; i++) {
					array[i] = array[i + 1];
				}
				size = size - 1;
				
				if(i+1 < array.length){
					array[i+1] = null;
				}

				for (i = priority - 1; i < index_end.length; i++) {
					index_end[i] = index_end[i] - 1;
				}

			}else{
				System.out.println("Cannot remove from empty stack");
			}
		}
		
		return node_to_be_removed;
	}

	@Override
	public Object pop() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		Object result = array[size - 1];
		array[--size] = null;
		return result;
	}

	public Object peek(int priority) {
		if (size == 0) {
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		return array[index_end[priority - 1] - 1];
	}

	@Override
	public Object peek() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		return array[size - 1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

}
