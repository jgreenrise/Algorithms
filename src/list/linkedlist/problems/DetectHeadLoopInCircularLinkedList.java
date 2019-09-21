package list.linkedlist.problems;

import list.linkedlist.single.SinglyLinkedList;

public class DetectHeadLoopInCircularLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 5, 3});
        
        detectNodeInCircularLinkedList(node);

        detectNodeInCircularLinkedListUsingHashSet(node);

    }

    // Hash set
    private static void detectNodeInCircularLinkedListUsingHashSet(SinglyLinkedList node) {
    }

    // Slow and fast pointer
    private static void detectNodeInCircularLinkedList(SinglyLinkedList node) {
    }


}
