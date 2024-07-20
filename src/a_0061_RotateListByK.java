import list.linkedlist.single.ListNode;

// https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
public class a_0061_RotateListByK {

    public ListNode rotateRightv2(ListNode head, int k) {

        if(head == null || head.next == null)    return head;

        /**
         * Find total nodes
         */
        int totNodes = 0;
        ListNode node = head;
        while(node != null){
            totNodes++;
            node = node.next;
        }

        /**
         * Update k
         */
        //System.out.println("Total Nodes: "+totNodes);
        if(totNodes == k){
            return head;
        }else if(totNodes < k){
            k = k % totNodes;
            //System.out.println("Revised k: "+k);
        }

        if(k == 0)    return head;
        /**
         * Find index of new Tail node
         */
        int navigateToNode = totNodes - k;
        int counter = 0;

        /**
         * Navigate to new Tail Node and
         * NewHead > node.next;
         * NewTail.next = null
         * Loop through all new Head child
         * OrigTail.next = origHead
         */
        ListNode origHead = head;
        ListNode newHead = null;
        ListNode newTail = null;
        node = origHead;
        while(node != null){
            counter++;
            if(counter == navigateToNode){
                newHead = node.next;
                newTail = node.next;
                node.next = null;
                while(newTail.next != null){
                    newTail = newTail.next;
                }
                newTail.next = origHead;
                break;
            }
            node = node.next;
        }

        return newHead;

    }

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
        int totalNodes = 0;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            totalNodes = totalNodes + 2;
        }
        if (fast.next == null) {
            totalNodes = totalNodes + 1;
        } else {
            totalNodes = totalNodes + 2;
        }

        if (k == 0 || k == totalNodes) {
            //System.out.println("No rotations reqd");
            return head;
        }

        if (k > totalNodes) {
            k = k % totalNodes;
            //System.out.println("New K: " + k+", totalNodes: "+totalNodes);
        }

        if (k == 0 || k == totalNodes) {
            //System.out.println("No rotations reqd");
            return head;
        }

        /**
         * Move fast = fast + k
         */
        slow = origHead;
        fast = head;
        totalNodes = 0;
        while (totalNodes != k) {
            //System.out.println("102: " + totalNodes);
            fast = fast.next;
            totalNodes++;
        }

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
