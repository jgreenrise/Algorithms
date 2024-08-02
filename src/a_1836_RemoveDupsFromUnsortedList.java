import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class a_1836_RemoveDupsFromUnsortedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SinglyLinkedList list = new SinglyLinkedList();

        // Add FIRST
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(3);

        System.out.println("Input");
        list.printList();

        ListNode output = deleteDuplicatesUnsorted(list.start);

        System.out.println("Output");
        while (output != null) {
            System.out.print(output.val + ", ");
            output = output.next;
        }

    }

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {

        // step 1: Assign dummy header
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        int[] arr = new int[1000001];

        // step 2: Find dups
        while (curr.next != null) {
            arr[curr.next.val]++;
            curr = curr.next;
        }

        // step 3: Remove dups, prev.next = c.next.next
        ListNode prev = dummy;
        curr = dummy.next;
        while (curr != null) {
            if (arr[curr.val] > 1) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        //printList(dummy.next);
        // step 4: Return dummy.next
        return dummy.next;
    }

    public void printList(ListNode node) {

        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }

        System.out.println("\n");

    }

}
