package list.linkedlist.clone.randomPointer;

/**
 * http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 * 
 * You are given a Double Link List with one pointer of each node pointing to
 * the next node just like in a single link list. The second pointer however CAN
 * point to any node in the list and not just the previous node. Now write a
 * program in O(n) time to duplicate this list. That is, write a program which
 * will create a copy of this list.
 * 
 * Refrence image
 * http://geeksforgeeks.org/wp-content/uploads/2009/08/ArbitLinked-List12.gif
 * 
 */
public class Application {

	// Main method.
	public static void main(String[] args) {
		// Pushing data in the linked list.
		LinkedList list = new LinkedList(new Node(5));
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		// Setting up random references.
		list.head.random = list.head.next.next;
		list.head.next.random = list.head.next.next.next;
		list.head.next.next.random = list.head.next.next.next.next;
		list.head.next.next.next.random = list.head.next.next.next.next.next;
		list.head.next.next.next.next.random = list.head.next;

		// Print the original and cloned linked list.
		System.out.println("Original linked list");
		list.print();

		// Making a clone of the original linked list.
		LinkedList clone = list.clone();

		System.out.println("\nCloned linked list");
		clone.print();
	}

}
