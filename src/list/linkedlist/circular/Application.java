package list.linkedlist.circular;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CircularLinkedList list = new CircularLinkedList();
		
		// Add FIRST
		list.addFirst(10); list.printList();
		list.addFirst(60); list.printList();
		list.addFirst(90); list.printList();
		
		// add or add Last
		list.addLast(80); list.printList();
		list.addLast(40); list.printList();
 		
		// Add at position
		list.add(1, 100); list.printList();
		list.add(6, 200); list.printList();
		list.add(2, 70); list.printList();
		list.add(2, 75); list.printList();
		
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
