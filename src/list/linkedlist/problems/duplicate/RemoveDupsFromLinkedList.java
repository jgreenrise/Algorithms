package list.linkedlist.problems.duplicate;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDupsFromLinkedList {

	public static void main(String[] args) {


		RemoveDupsFromLinkedList obj = new RemoveDupsFromLinkedList();
		SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{10,10,10,20,20});
		obj.deleteDuplicates(node.start);
		node.printList();

	}


	/**
	 Approach 2: Using while looop
	 **/
	public ListNode deleteDuplicates(ListNode head) {

		ListNode orig = head;
		head = deleteDuplicateUsingWhileLoop(head);
		return orig;
	}

	/*
    10  10  10  20  20  30
    10  10
    10      10
    10          20
                20  20
                20      30
    */
	public ListNode deleteDuplicateUsingWhileLoop(ListNode head){

		if(head == null){
			return head;
		}

		// Loop until you have dups
		while(head.next != null && head.next.val == head.val){
			if(head.next.next  != null){
				head.next = head.next.next;
			}else{
				head.next = null;
				return head;
			}
		}

		// Distinct element, Make recursive call
		head.next = deleteDuplicateUsingWhileLoop(head.next);
		return head;

	}

	/**
	 Approach 1: Using SET
	 **/
	public ListNode deleteDuplicatesUsingSet(ListNode head) {

		if(head == null){
			return head;
		}

		Set<Integer> set = new HashSet();
		set.add(head.val);
		head.next = method1(head.next, set);
		return head;
	}

	public ListNode method1(ListNode head, Set<Integer> set){

		if(head == null)
			return null;

		if(set.contains(head.val)){
			return method1(head.next, set);
		}else{
			set.add(head.val);
			head.next = method1(head.next, set);
			return head;
		}

	}

}
