package sandbox;

public class BoundedArray implements iStack {

	public Object[] array;
	public int size;

	public BoundedArray(int capacity) {
		array = new Object[capacity];
		size = 0;
	}

	@Override
	public void push(Object item) {
		if (size == array.length) {
			throw new UnsupportedOperationException(
					"Unable to add to stack which is already full");
		}
		array[size++] = item;
	}

	@Override
	public Object peek() {
		if (size == 0) {
			throw new UnsupportedOperationException(
					"Unable to retrieve from empty stack");
		}
		return array[size-1];
	}

	@Override
	public Object pop() {
		if (size == 0) {
			throw new UnsupportedOperationException(
					"Unable to retrieve from empty stack");
		}

		Object tmp = array[size-1];
		array[--size] = null;
		return tmp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		return size == array.length;
	}

}
