package list.linkedlist.problems.sumList;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

import static list.linkedlist.single.Node.printLL;

public class SumListsReverse {

    public static void main(String[] args) {
        // 6 > 1 > 7
        SinglyLinkedList list1 = SinglyLinkedList.createLL(new int[] {7,1,6});
        // 2 > 9 > 5
        SinglyLinkedList list2 = SinglyLinkedList.createLL(new int[] {5,9,2});

        // O/P = 9 > 1 > 2

        Node node = null;
        node = sumLL(list1.start, list2.start);
        System.out.println("Recursion");
        printLL(node);

    }

    private static Node sumLL(Node leftNode, Node rightNode) {

        if(leftNode == null || rightNode == null)
            return null;

        int carryOver = 0;
        Node newNode = new Node();
        newNode.next_node = sumLL(leftNode.next_node, rightNode.next_node);

        if(newNode.next_node == null){
            carryOver = 0;
        }else{
            int totalOfNextNode = newNode.next_node.value;
            if (totalOfNextNode > 9){

                newNode.next_node.value = totalOfNextNode % 10;
                carryOver = 1;
            }
        }

        newNode.value = leftNode.value + rightNode.value + carryOver;
        return newNode;
    }


}
