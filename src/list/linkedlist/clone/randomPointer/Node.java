package list.linkedlist.clone.randomPointer;

//Java program to clone a linked list with random pointers
import java.util.HashMap;
import java.util.Map;

//Linked List Node class
class Node {
	
	int data;// Node data
	Node next, random;// Next and random reference

	// Node constructor
	public Node(int data) {
		this.data = data;
		this.next = this.random = null;
	}
}
