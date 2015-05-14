package Stack.problems.stackOfStacks;

import java.util.Vector;

import Stack.implementStack.Approach2_BoundedArray;

public class Client {

	public static void main(String[] args) {

		Vector<Approach2_BoundedArray> setOfStacks = new Vector<Approach2_BoundedArray>();

		push("10", setOfStacks);
		push("40", setOfStacks);
		push("60", setOfStacks);
		push("80", setOfStacks);
		push("70", setOfStacks);
		push("5", setOfStacks);
		push("9", setOfStacks);
		push("3", setOfStacks);
		push("15", setOfStacks);
		push("31", setOfStacks);
		push("27", setOfStacks);
		push("56", setOfStacks);
		push("15", setOfStacks);
		push("31", setOfStacks);
		push("27", setOfStacks);
		push("146", setOfStacks);

		//System.out.println(setOfStacks);
		
		System.out.println("Pop: "+pop(setOfStacks));
		
		System.out.println("Pop at index 1: "+pop(setOfStacks, 1));
		System.out.println("Pop at index 2: "+pop(setOfStacks, 2));

	}

	private static String pop(Vector<Approach2_BoundedArray> stacks) {
		return ((Approach2_BoundedArray)(stacks.get(stacks.size()-1))).pop().toString();
	}
	
	private static String pop(Vector<Approach2_BoundedArray> stacks, int index) {
		return ((Approach2_BoundedArray)(stacks.get(index))).pop().toString();
	}

	public static void push(Object item, Vector<Approach2_BoundedArray> stacks) {

		Approach2_BoundedArray stack = null;
		int index = 0;
		boolean wasNewItemAdded = false;

		if (stacks.size() == 0) {
			stack = new Approach2_BoundedArray(4);
			index = 0;
			stack.push(item);
			stacks.add(index, stack);
		} else {

			for (Approach2_BoundedArray childStack : stacks) {
				if (!childStack.isFull()) {
					wasNewItemAdded = true;
					childStack.push(item);
					break;
				} else{
					index++;
				}	
			}

			if (stack == null && !wasNewItemAdded) {
				stack = new Approach2_BoundedArray(4);
				stack.push(item);
				stacks.add(index, stack);
			}
		}

	}

}
