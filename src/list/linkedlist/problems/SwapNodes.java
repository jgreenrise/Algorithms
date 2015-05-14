package list.linkedlist.problems;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

/**
 * Given a linked list and two keys in it, swap nodes for two given keys. Nodes
 * should be swapped by changing links. Swapping data of nodes may be expensive
 * in many situations when data contains many fields.
 * 
 * It may be assumed that all keys in linked list are distinct.
 * 
 * Examples:
 * 
 * Input: 10->15->12->13->20->14, x = 12, y = 20 Output: 10->15->20->13->12->14
 * 
 * Input: 10->15->12->13->20->14, x = 10, y = 20 Output: 20->15->12->13->10->14
 * 
 * Input: 10->15->12->13->20->14, x = 12, y = 13 Output: 10->15->13->12->20->14
 * 
 * This may look a simple problem, but is interesting question as it has
 * following cases to be handled. 1) x and y may or may not be adjacent. 2)
 * Either x or y may be a head node. 3) Either x or y may be last node. 4) x
 * and/or y may not be present in linked list.
 * 
 * 
 */
public class SwapNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();

		// Add FIRST
		list.addFirst(10);
		list.printList();
		list.addFirst(24);
		list.printList();
		list.addFirst(62);
		list.printList();

		// add or add Last
		list.addLast(98);
		list.printList();
		list.addLast(26);
		list.printList();
		list.addLast(67);
		list.printList();

		// Add at position
		list.add(1, 100);
		list.printList();
		list.add(7, 200);
		list.printList();
		list.add(2, 250);
		list.printList();

		list.removeAtIndex(2);
		System.out.println("Remove from a index 2");
		list.printList();

		System.out.println("After swapping 62 and 10");
		swapNodes(list.start, 62, 10);

		System.out.println("before swapping 10 and 24");
		list.printList();
		System.out.println("After swapping 10 and 24");
		swapNodes(list.start, 10, 24);

		System.out.println("before swapping 100 and 200");
		list.printList();
		System.out.println("After swapping 100 and 67");
		swapNodes(list.start, 100, 67);

	}

	public static void swapNodes(Node node, int node1, int node2) {

		SinglyLinkedList list = new SinglyLinkedList();

		Node head = node;

		Node src_node_parent = null;
		Node src_node = new Node(node1, null);
		Node src_node_child = null;
		boolean is_src_node_found = false;

		Node destination_node_parent = null;
		Node dest_node = new Node(node2, null);
		boolean is_dest_node_found = false;

		while (node.next_node != null) {

			if (!is_src_node_found) {
				if (node1 == (node.value)) {

					src_node_child = node.next_node;
					is_src_node_found = true;

					// src node is not head
					if (src_node_parent != null) {
						src_node_parent.next_node = dest_node;
					} else {
						head = dest_node;
					}
					dest_node.next_node = src_node_child;

					destination_node_parent = dest_node;
					node = node.next_node;
				} else {
					src_node_parent = node;
				}
			}

			if (is_src_node_found && !is_dest_node_found) {
				if (node2 == (node.value)) {

					is_dest_node_found = true;

					destination_node_parent.next_node = src_node;
					src_node.next_node = node.next_node;

				} else {
					destination_node_parent = node;
				}
			}

			if (is_src_node_found && is_dest_node_found) {

				Node node_a = head;
				while (node_a != null) {
					System.out.print(node_a.value + ", ");
					node_a = node_a.next_node;
				}

				System.out.println("\n");

				break;
			} else {
				node = node.next_node;
			}

		}

	}
}
