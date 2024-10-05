import list.linkedlist.single.ListNode;

public class a_0023_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeKListsByRange(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsByRange(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        } else if (right == left + 1) {
            return merge(lists[left], lists[right]);
        } else {
            int mid = left + (right - left) / 2;
            return merge(mergeKListsByRange(lists, left, mid), mergeKListsByRange(lists, mid + 1, right));
        }
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            if (left.val <= right.val) {
                left.next = merge(left.next, right);
                return left;
            } else {
                right.next = merge(left, right.next);
                return right;
            }
        }
    }
}
