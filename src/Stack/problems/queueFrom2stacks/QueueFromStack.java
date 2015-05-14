package Stack.problems.queueFrom2stacks;

import Stack.implementStack.Approach2_BoundedArray;
import Stack.queue.iQueue;

public class QueueFromStack implements iQueue {

	Approach2_BoundedArray stack = null;
	Approach2_BoundedArray buffer = null;
	
	int size = 0;
	int capacity = 0;

	public QueueFromStack(int capacity) {
		stack = new Approach2_BoundedArray(capacity);
		size = 0;
		this.capacity = capacity;
	}

	@Override
	public void push(Object item) {
		if (size == capacity) {
			throw new IllegalStateException("Cannot add value to full stack");
		}
		size++;
		stack.push(item);
	}

	@Override
	public Object poll() {

		buffer = new Approach2_BoundedArray(capacity);

		if (size == 0) {
			throw new IllegalStateException("Cannot poll from empty stack");
		}

		while (!stack.isEmpty()) {
			buffer.push(stack.pop());
		}

		Object response = buffer.peek();

		while (!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}

		return response;
	}

	@Override
	public Object peek() {

		buffer = new Approach2_BoundedArray(capacity);

		if (size == 0) {
			throw new IllegalStateException("Cannot peek from empty stack");
		}

		while (!stack.isEmpty()) {
			buffer.push(stack.pop());
		}

		Object response = buffer.pop();
		--size;

		while (!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}

		return response;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
