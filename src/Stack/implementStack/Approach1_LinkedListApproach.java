package Stack.implementStack;

import java.util.LinkedList;

public class Approach1_LinkedListApproach implements Stack {
	
	LinkedList<Object> linkedList = new LinkedList<Object>();

	@Override
	public void push(Object item) {
		// TODO Auto-generated method stub
		linkedList.addFirst(item);
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		return linkedList.removeFirst();
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return linkedList.peekFirst();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return linkedList.isEmpty();
	}

}
