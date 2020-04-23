package list.linkedlist.problems.duplicate;

import java.util.Iterator;
import java.util.LinkedHashSet;

import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;

/**
Input
1, 7, 6, 6, 1, 1, 2, 0, Size: 8

Output
1 7 6 2 0 
 * 
 * Time complexity: 
 * O(n) (for adding elements into hashset)
 * O(n*m) (Linked hashset time complexity)
 * O(n) (for adding it back to Linked list)
 * 
 * Advantage
 * Maintains insertion order
 * 
 * Limitation
 * Additional storage
 */
public class RemoveDupsFromLinkedListUsingLinkedHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();

		// Add FIRST
		list.addFirst(0);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(1);
		list.addFirst(6);
		list.addFirst(6);
		list.addFirst(7);
		list.addFirst(1);

		System.out.println("Input");
		list.printList();
		
		ListNode node = list.start;
		
		while(node.next != null){
			linkedHashSet.add(node.val);
			node = node.next;
		}
		linkedHashSet.add(node.val);

		System.out.println("Output");
		Iterator<Integer> iterator = linkedHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}

}
