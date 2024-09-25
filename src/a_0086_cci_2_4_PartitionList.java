import list.linkedlist.single.ListNode;

public class a_0086_cci_2_4_PartitionList {

    public ListNode partition(ListNode node, int x) {

        if (node == null || node.next == null) return node;

        ListNode headHead = null, headTail = null, tailHead = null, tailTail = null;

        while (node != null) {
            ListNode newnode = new ListNode(node.val);

            if (node.val < x) {
                if (headHead == null) {
                    headHead = newnode;
                    headTail = newnode;
                } else {
                    headTail.next = newnode;
                    headTail = headTail.next;
                }
            } else {
                if (tailHead == null) {
                    tailHead = newnode;
                    tailTail = newnode;
                } else {
                    tailTail.next = newnode;
                    tailTail = tailTail.next;
                }
            }
            node = node.next;
        }

        if (headHead != null) {
            headTail.next = tailHead;
            return headHead;
        } else {
            return tailHead;
        }

    }

}
