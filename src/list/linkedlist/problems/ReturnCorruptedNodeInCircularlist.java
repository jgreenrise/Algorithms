package list.linkedlist.problems;

import java.util.HashSet;

import list.linkedlist.single.ListNode;

public class ReturnCorruptedNodeInCircularlist {

	public static void main(String[] args) {

	}

	/**
	 * Approach 1 Time complexity: O(n) Space complexity: O(n), since we are
	 * using hashset to store values
	 */
	private static ListNode returnCorruptedNode(ListNode node) {

		if (node == null)
			return null;

		if (node.next == null) {
			return node;
		}

		HashSet<Integer> nodes = new HashSet<>();

		while (node.next != null && !nodes.contains(node.val)) {
			nodes.add(node.val);
			node = node.next;
		}

		if (nodes.contains(node.val)) {
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
	private static ListNode returnCorruptedNode_usingcounter(ListNode node) {

		if (node == null)
			return null;

		if (node.next == null) {
			return node;
		}

		ListNode slow = node;
		ListNode fast = node;

		/**
		 * Slow by speed 1
		 * Fast by speed 2
		 */
		while (slow != fast && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		/**
		 * Move slow to start
		 */
		slow = node;

		/**
		 * Slow & fast by speed 1
		 */
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;

	}

}
