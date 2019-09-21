package list.linkedlist.problems.adjacent;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

public class IsAdjacentUsingRecursion {

    public static void main(String[] args) {

        SinglyLinkedList node1 = SinglyLinkedList.createLL(new int[] {6, 4, 3, 5});
        SinglyLinkedList node2 = SinglyLinkedList.createLL(new int[] {6, 4, 3, 2, 1});
        System.out.println("Is adjacent: "+does_LL_intersect(node1.start, node2.start)+"\n");

        node1 = SinglyLinkedList.createLL(new int[] {1,2,7,9, 5,1,3});
        node2 = SinglyLinkedList.createLL(new int[] {1,2,7,6,4});
        System.out.println("Is adjacent: "+does_LL_intersect(node1.start, node2.start)+"\n");

        node1 = SinglyLinkedList.createLL(new int[] {3,2,7,9, 5,1,3});
        node2 = SinglyLinkedList.createLL(new int[] {1,2,7,6,4});
        System.out.println("Is adjacent: "+does_LL_intersect(node1.start, node2.start));

    }

    public static boolean does_LL_intersect(Node left, Node right){

        return true;
    }





}
