package list.linkedlist.clone.randomPointer;

//Java program to clone a linked list with random pointers

//Linked List Node class
class ListNode {
	
	int data;// Node data
	ListNode next, random;// Next and random reference

	// Node constructor
	public ListNode(int data) {
		this.data = data;
		this.next = this.random = null;
	}
}
