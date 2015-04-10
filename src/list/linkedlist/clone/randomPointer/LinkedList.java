package list.linkedlist.clone.randomPointer;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {

	Node head;// Linked list head reference

	// Linked list constructor
	public LinkedList(Node head) {
		this.head = head;
	}

	// push method to put data always at the head
	// in the linked list.
	public void push(int data) {
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
	}

	// Method to print the list.
	void print() {
		Node temp = head;
		while (temp != null) {
			Node random = temp.random;
			int randomData = (random != null) ? random.data : -1;
			System.out.println("Data = " + temp.data + ", Random data = "
					+ randomData);
			temp = temp.next;
		}
	}
	
	 // Actual clone method which returns head
    // reference of cloned linked list.
    public LinkedList clone()
    {
        // Initialize two references, one with original
        // list's head.
        Node origCurr = this.head, cloneCurr = null;
 
        // Hash map which contains node to node mapping of
        // original and clone linked list.
        Map<Node, Node> map = new HashMap<Node, Node>();
 
        // Traverse the original list and make a copy of that
        // in the clone linked list.
        while (origCurr != null)
        {
            cloneCurr = new Node(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }
 
        // Adjusting the original list reference again.
        origCurr = this.head;
 
        // Traversal of original list again to adjust the next
        // and random references of clone list using hash map.
        while (origCurr != null)
        {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }
 
        //return the head reference of the clone list.
        return new LinkedList(map.get(this.head));
    }

}
