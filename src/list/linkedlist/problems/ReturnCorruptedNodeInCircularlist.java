package list.linkedlist.problems;

import java.util.HashSet;

import list.linkedlist.single.Node;

public class ReturnCorruptedNodeInCircularlist {

	public static void main(String[] args) {

	}

	/**
	 * Approach 1 Time complexity: O(n) Space complexity: O(n), since we are
	 * using hashset to store values
	 */
	private static Node returnCorruptedNode(Node node) {

		if (node == null)
			return null;

		if (node.next_node == null) {
			return node;
		}

		HashSet<Integer> nodes = new HashSet<>();

		while (node.next_node != null && !nodes.contains(node.value)) {
			nodes.add(node.value);
			node = node.next_node;
		}

		if (nodes.contains(node.value)) {
			return node;
		} else {
			System.out.println("No corrupted node detected.");
			return null;
		}

	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	private static Node returnCorruptedNode_usingcounter(Node node) {

		if (node == null)
			return null;

		if (node.next_node == null) {
			return node;
		}

		Node slow = node;
		Node fast = node;

		/**
		 * Slow by speed 1
		 * Fast by speed 2
		 */
		while (slow != fast && fast.next_node != null && fast.next_node.next_node != null) {
			slow = slow.next_node;
			fast = fast.next_node.next_node;
		}

		/**
		 * Move slow to start
		 */
		slow = node;

		/**
		 * Slow & fast by speed 1
		 */
		while (slow != fast) {
			slow = slow.next_node;
			fast = fast.next_node;
		}

		return slow;

	}

}
