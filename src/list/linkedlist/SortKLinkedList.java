package list.linkedlist;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import java.util.PriorityQueue;

public class SortKLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ListNode[] lists = new ListNode[3];
        /* SinglyLinkedList node1 = SinglyLinkedList.createLL(new int[]{1, 4, 5});
        SinglyLinkedList node2 = SinglyLinkedList.createLL(new int[]{1, 3, 4});
        SinglyLinkedList node3 = SinglyLinkedList.createLL(new int[]{2, 6});
        lists[0] = node1.start;
        lists[1] = node2.start;
        lists[2] = node3.start;


        lists = new ListNode[2];
        SinglyLinkedList node1 = SinglyLinkedList.createLL(new int[]{});
        SinglyLinkedList node2 = SinglyLinkedList.createLL(new int[]{1});
        lists[0] = node1.start;
        lists[1] = node2.start;*/


        lists = new ListNode[3];
        SinglyLinkedList node1 = SinglyLinkedList.createLL(new int[]{1, 4, 5});
        SinglyLinkedList node2 = SinglyLinkedList.createLL(new int[]{1, 3, 4});
        SinglyLinkedList node3 = SinglyLinkedList.createLL(new int[]{2, 6});
        lists[0] = node1.start;
        lists[1] = node2.start;
        lists[2] = node3.start;

        SortKLinkedList class1 = new SortKLinkedList();

        /**
         * Approach 1: Combine all list into single list and then do Merge sort
         */
        ListNode out = class1.mergeAllListNodes(lists);

        /**
         * Approach 2: Merge sort {0,1} > out, then ms{out,2}, ms{out,3} etc
         */
        out = class1.mergeOneListAtATime(lists);

        /**
         * 3: Using p1
         */
        out = class1.usingPriorityQueu(lists);

        System.out.println(out.val);


    }

	public ListNode usingPriorityQueu(ListNode[] lists) {

		PriorityQueue<Integer> minHeap = new PriorityQueue();

		for(ListNode listNode: lists){
			while(listNode != null){
				minHeap.add(listNode.val);
				listNode = listNode.next;
			}
		}

		ListNode out = new ListNode(minHeap.remove());
		ListNode orig = out;
		while(!minHeap.isEmpty()){
			out.next = new ListNode(minHeap.remove());
			out = out.next;
		}

		return orig;

	}

    /**
     * Approach 1: Combine all lists into a single list and then do merge Sort
     */
    public ListNode mergeAllListNodes(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        ListNode combined = null;
        ListNode orig = null;
        boolean matchFound = false;
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            } else {
                matchFound = true;
                if (combined == null) {
                    combined = node;
                    orig = combined;
                } else {
                    combined.next = node;
                }

                while (combined.next != null) {
                    combined = combined.next;
                }
            }
        }

        if (!matchFound) {
            return null;
        }

        if (orig.next == null) {
            return combined;
        }

        System.out.println(orig);
        return mergeSort(orig);


    }

    public static ListNode mergeSort(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ListNode middle = getMiddle(node);
        ListNode right = middle.next;

        // Do this to make sure that left list only travels till midpoint
        middle.next = null;

        return mergeLinkedList(mergeSort(node), mergeSort(right));
    }

    public static ListNode getMiddle(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode slow, fast = null;
        slow = fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode mergeLinkedList(ListNode left, ListNode right) {

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.val > right.val) {
            right.next = mergeLinkedList(left, right.next);
            return right;
        } else {
            left.next = mergeLinkedList(left.next, right);
            return left;
        }

    }

    public ListNode mergeOneListAtATime(ListNode[] lists) {

        ListNode out = lists[0];

        for(int j=1; j< lists.length; j++){
            out = merge(out, lists[j]);
        }

        return out;

    }

    public ListNode merge(ListNode left, ListNode right){

        if(left == null && right == null){
            return null;
        }else if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            int out = 0;
            ListNode node = null;

            if(left.val <= right.val){
                node = new ListNode(left.val);
                node.next = merge(left.next, right);
            }else{
                node = new ListNode(right.val);
                node.next = merge(left, right.next);
            }

            return node;

        }

    }

}
