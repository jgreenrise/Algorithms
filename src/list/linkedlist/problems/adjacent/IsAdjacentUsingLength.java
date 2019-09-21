package list.linkedlist.problems.adjacent;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

public class IsAdjacentUsingLength {

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
        int lengthLeft = length(left);
        int lengthRight = length(right);

        if(lengthLeft > lengthRight){
            while(lengthLeft != lengthRight){
                left = left.next_node;
                lengthLeft = lengthLeft - 1;
            }
        }else if(lengthLeft < lengthRight){
            while(lengthRight != lengthLeft){
                right = right.next_node;
                lengthRight = lengthRight - 1;
            }
        }

        return does_LL_ofEqualLength_intersect(left, right);

    }

    public static boolean does_LL_ofEqualLength_intersect(Node left, Node right){

        int counter = 0;
        Node intersectingNode = null;

        while(left != null){

            if(left.value == right.value){
                if(counter == 0)
                    intersectingNode = left;
                counter = counter + 1;
            }else{
                counter = 0;
                intersectingNode = null;
            }

            left = left.next_node;
            right = right.next_node;
        }

        boolean isIntersecting = (intersectingNode != null && counter > 1) ? true : false;

        if(isIntersecting){
            System.out.println("Is adjacent at node : "+intersectingNode.value);
        }else{
            System.out.println("Not adjacent");
        }

        return isIntersecting;

    }

    public static int length(Node node){
        int length= 0;
        while(node != null){
            length ++;
            node = node.next_node;
        }
        return length;
    }

}
