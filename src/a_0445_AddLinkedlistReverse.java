import list.linkedlist.single.ListNode;

public class a_0445_AddLinkedlistReverse {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Step 1: Get Total Nodes
        int len1 = getTotalNode(l1);
        int len2 = getTotalNode(l2);
        ListNode node = null;
        ListNode out = null;

        // Call recursive method
        if (len1 >= len2) {
            node = addTwoNumbers(l1, l2, len1 - len2);
        } else {
            node = addTwoNumbers(l2, l1, len2 - len1);
        }

        if (node.next != null && node.next.val > 9) {
            out = new ListNode(node.next.val / 10);
            node.val = node.val % 10;
            out.next = node;
            return out;
        } else {
            if (node.val > 9) {
                out = new ListNode(node.val / 10);
                node.val = node.val % 10;
                out.next = node;
                return out;
            } else {
                return node;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int counter) {
        if (l1 == null && l2 == null) return null;
        if (counter == 0) {
            ListNode out = new ListNode(l1.val + l2.val);
            out.next = addTwoNumbers(l1.next, l2.next, counter);

            if (out.next != null && out.next.val > 9) {
                out.val = out.val + out.next.val / 10;
                out.next.val = out.next.val % 10;
            }
            return out;
        } else {
            ListNode out = new ListNode(l1.val);
            out.next = addTwoNumbers(l1.next, l2, counter - 1);
            if (out.next != null && out.next.val > 9) {
                out.val = out.val + out.next.val / 10;
                out.next.val = out.next.val % 10;
            }
            return out;
        }
    }

    public int getTotalNode(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;
        int counter = 0;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            counter++;
        }

        if (fast.next == null) {
            return counter * 2 - 1;
        } else {
            return counter * 2;
        }

    }


}
