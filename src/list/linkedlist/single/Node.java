package list.linkedlist.single;

public class Node {

	public int value;
	public Node next_node;

	public Node() {
		value = 0;
		next_node = null;
	}

	public Node(int value, Node next_node) {
		this.value = value;
		this.next_node = next_node;
	}
}
