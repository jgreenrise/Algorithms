import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class a_92_ReverseLinkedList2 {
    public static void main(String[] args) {

        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{5, 4, 3, 2, 1});
        System.out.println("Input Value - Odd elems: " + node.printLL() + "\tIs palindrome: " + reverseBetween(node.start, 2, 4));
        System.out.println(node.printLL());

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode orig = head;
        ListNode prevHead = head;

        while (head != null && head.val != left) {
            System.out.println("Curr Head Node: " + head.val);
            prevHead = head;
            head = head.next;
        }

        System.out.println("Head Node: " + head.val);
        reverseBetween2(prevHead, new ListNode(left), head.next, right);
        return head;
    }

    public static ListNode reverseBetween2(ListNode prevHead, ListNode reversed, ListNode nextNode, int right) {

        System.out.println("Next Node: " + nextNode.val);

        ListNode newnode = null;
        while (nextNode.val != right) {
            System.out.println("Inside while loop: reversing nodes");
            newnode = new ListNode(nextNode.val);
            newnode.next = reversed;
            nextNode = nextNode.next;
            reversed = newnode;
        }

        newnode = new ListNode(nextNode.val);
        newnode.next = reversed;
        reversed = newnode;

        ListNode newReversedNode = newnode;
        while (newReversedNode.next != null) {
            newReversedNode = newReversedNode.next;
        }
        newReversedNode.next = nextNode.next;   // Realign right .next node
        prevHead.next = newnode;            // Realign the node before start node to <reversed heade node>
        return prevHead;

    }
}
