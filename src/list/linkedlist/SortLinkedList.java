package list;

import list.SinglyLinkedList.Node;

public class SortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();

		// Add FIRST
		list.addFirst(0);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(1);
		list.addFirst(6);
		list.addFirst(7);
		list.addFirst(5);
		list.addFirst(4);

		list.printList();

		Node output = sortLinkedList(list);
		
		System.out.println("Output");
		while (output != null) {
			System.out.print(output.value + ", ");
			output = output.next_node;
		}

	}

	/**********************************************************
	 * SORT A LINKED LIST
	 ***********************************************************/

	public static Node sortLinkedList(SinglyLinkedList node) {

		if (node.size > 1) {

			int length_of_list = 1;

			Node tmp = node.start;

			while (tmp.next_node != null) {
				length_of_list++;
				tmp = tmp.next_node;
			}

			SinglyLinkedList left = left(node, length_of_list);
			SinglyLinkedList right = right(node, length_of_list);

			sortLinkedList(left);
			sortLinkedList(right);
			
			return mergeLinkedList(left.start, right.start);
			
		}
		return null;

	}

	private static SinglyLinkedList left(SinglyLinkedList list,
			int length_of_list) {

		int counter = 0;
		SinglyLinkedList response = new SinglyLinkedList();
		Node node = list.start;

		while (counter < length_of_list / 2) {

			response.addFirst(node.value);
			node = node.next_node;
			counter++;
		}

		//System.out.println(response.start.value);
		return response;

	}

	private static SinglyLinkedList right(SinglyLinkedList list,
			int length_of_list) {

		int start_index = length_of_list / 2;
		int end_index = length_of_list;
		int counter = 0;
		SinglyLinkedList response = new SinglyLinkedList();
		Node node = list.start;

		while (counter < end_index) {

			if (counter >= start_index) {
				response.addFirst(node.value);
			}

			node = node.next_node;
			counter++;

		}

		//System.out.println(response.start.value);
		return response;

	}

	private static Node mergeLinkedList(Node left, Node right) {

		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		if (left.value > right.value) {
			right.next_node = mergeLinkedList(left, right.next_node);
			return right;
		} else {
			left.next_node = mergeLinkedList(left.next_node, right);
			return left;
		}

	}

}
