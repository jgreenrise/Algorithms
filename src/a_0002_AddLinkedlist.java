import list.linkedlist.single.ListNode;

public class a_0002_AddLinkedlist {

    public static ListNode sumListUsingRecursion(ListNode left, ListNode right, int carryOver) {
        if (left == null && right == null) {
            return carryOver == 0 ? null : new ListNode(carryOver);
        }

        int leftVal = left != null ? left.val : 0;
        int rightVal = right != null ? right.val : 0;

        int total = leftVal + rightVal + carryOver;
        ListNode newNode = new ListNode(total % 10);
        carryOver = total >= 10 ? 1 : 0;

        ListNode nextLeft = left != null ? left.next : null;
        ListNode nextRight = right != null ? right.next : null;

        newNode.next = sumListUsingRecursion(nextLeft, nextRight, carryOver);
        return newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumListUsingRecursion(l1, l2, 0);
    }


}
