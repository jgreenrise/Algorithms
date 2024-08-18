import list.linkedlist.single.ListNode;

/**
 * Time complexity: O(n2)
 */
public class a_0160_listIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 1. Get Length
        int lenA = length(headA), lenB = length(headB);

        // 2. move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        // 3. find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

}
