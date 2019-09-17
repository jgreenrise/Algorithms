package list.linkedlist.problems;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.Node.printLL;

public class PartitionLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Node to be deleted is given
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(3);

        System.out.println("Input list");
        list.printList();
        Node node = partitionLinkedListUsingHeadAndTailPointers(list.start, 5);
        System.out.println("Approach 1: Head and Tail approach");
        printLL(node);

        list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(3);
        node = partitionLinkedListUsingWhileAndIfLoop(list.start, 5);
        System.out.println("Approach 2: Create LowLL and HighLL and combine");
        printLL(node);
    }

    private static Node partitionLinkedListUsingWhileAndIfLoop(Node node, int partition) {

        Node lowNode = null;
        Node highNode = null;

        while (node != null) {
            Node nodeToBeAdded = new Node();
            nodeToBeAdded.value = node.value;

            if (node.value < partition) {
                if (lowNode == null) {
                    lowNode = nodeToBeAdded;
                } else {
                    nodeToBeAdded.next_node = lowNode;
                    lowNode = nodeToBeAdded;
                }
            } else {
                if (highNode == null) {
                    highNode = nodeToBeAdded;
                } else {
                    nodeToBeAdded.next_node = highNode;
                    highNode = nodeToBeAdded;
                }
            }
            node = node.next_node;
        }

        Node original = lowNode;

        while (lowNode.next_node != null) {
            lowNode = lowNode.next_node;
        }
        lowNode.next_node = highNode;

        return original;
    }

    private static Node partitionLinkedListUsingHeadAndTailPointers(Node node, int partition) {

        Node lowNode = null;
        Node highNode = null;
        Node startLowNode = null;

        while (node != null) {

            Node newNode = new Node();
            newNode.value = node.value;

            if (node.value < partition) {
                if (lowNode == null) {
                    lowNode = newNode;
                    startLowNode = lowNode;
                } else {
                    lowNode.next_node = newNode;
                    lowNode = newNode;
                }
            } else {
                if (highNode == null) {
                    highNode = newNode;
                } else {
                    newNode.next_node = highNode;
                    highNode = newNode;
                }
            }
            node = node.next_node;
        }

        lowNode.next_node = highNode;
        return startLowNode;

    }

}
