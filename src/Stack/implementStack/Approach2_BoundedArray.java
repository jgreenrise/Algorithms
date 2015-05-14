package Stack.implementStack;

import java.util.NoSuchElementException;

/**
 * An implementation of a stack using a fixed, non-expandable array whose
 * capacity is set in its constructor.
 */
public class Approach2_BoundedArray implements Stack {

	Object[] array;
	int size = 0;

	public Approach2_BoundedArray(int size) {
		super();
		array = new Object[size];
	}

	@Override
	public void push(Object item) {
		if (size == array.length) {
			throw new IllegalStateException("Cannot add to full stack");
		}
		array[size++] = item;

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

	public boolean isFull() {
		return size == array.length;
	}

}
