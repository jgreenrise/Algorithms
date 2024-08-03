import list.linkedlist.single.ListNode;

// https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
public class a_0061_RotateListByK {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;
        if (head.next == null) return head;
        if (k == 0) return head;

        /**
         * Check if K is greater than total elements in List.
         * If yes, upgdate k
         */
        ListNode origHead = head;
        ListNode slow = head;
        ListNode fast = head;
        int currCounter = 0;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            currCounter = currCounter + 2;
        }
        if (fast.next == null) {
            currCounter = currCounter + 1;
        } else {
            currCounter = currCounter + 2;
        }

        if (k == 0 || k == currCounter) {
            //System.out.println("No rotations reqd");
            return head;
        }

        if (k > currCounter) {
            k = k % currCounter;
            //System.out.println("New K: " + k+", currCounter: "+currCounter);
        }

        if (k == 0 || k == currCounter) {
            //System.out.println("No rotations reqd");
            return head;
        }

        /**
         * Move fast = fast + k
         */
        slow = origHead;
        ListNode buffer = head;
        currCounter = 0;
        while (currCounter != k) {
            //System.out.println("102: " + currCounter);
            buffer = buffer.next;
            currCounter++;
        }
        fast = buffer;

        //System.out.println("103: " + (fast == null));
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        /**
         * Slow.next is the new head;
         * Fast.next = origHead;
         */
        ListNode out = slow.next;
        slow.next = null;
        fast.next = origHead;

        return out;

    }
}
