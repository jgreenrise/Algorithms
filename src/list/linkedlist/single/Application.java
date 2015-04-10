package list.linkedlist.single;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		// Add FIRST
		list.addFirst(10); list.printList();
		list.addFirst(24); list.printList();
		list.addFirst(62); list.printList();
		
		// add or add Last
		list.addLast(98); list.printList();
		list.addLast(26); list.printList();
		list.addLast(67); list.printList();
		
		// Add at position
		list.add(1, 100); list.printList();
		list.add(7, 200); list.printList();
		list.add(2, 250); list.printList();
		
		// Remove first
		list.removeFirst(); list.printList();
		list.removeFirst(); list.printList();
		
		// Remove last
		list.removeLast(); list.printList();
		list.removeLast(); list.printList();
		
		// Remove at index
		list.removeAtIndex(1);
		System.out.println("Remove 1st");
		list.printList();
		
		list.removeAtIndex(2); 
		System.out.println("Remove from a index 2");
		list.printList();
		
		

	}

}
