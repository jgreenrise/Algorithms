package list.linkedlist.single;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
		val = 0;
		next = null;
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static void printLL(ListNode node){
		while(node.next != null){
			System.out.print(node.val + " > ");
			node = node.next;
		}
		System.out.println(node.val);
	}
}
