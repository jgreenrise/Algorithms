package list.linkedlist.problems.palindrome;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

public class IsPalindromeRecursionAndLength {

    public static void main(String[] args) {

        //  100 > 200 > 300 > 400
        SinglyLinkedList node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 2, 1});
        System.out.println("Is palindrome: "+isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 4, 2, 1});
        System.out.println("Is palindrome: "+isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 4, 3, 2, 1});
        System.out.println("Is palindrome: "+isPalindrome(node.start));
    }

    public static boolean isPalindrome(Node node){

        // Reverse LL AND find length of LL
        Node original = node;

        int length= 0;
        while(node != null){
            length ++;
            node = node.next_node;
        }

        Node head = findSiblingNode(original, length, 0);
        return head == null ? false: true;
    }

    private static Node findSiblingNode(Node head, int length, int counter) {

        if(counter != length / 2){
            Node sibling = findSiblingNode(head.next_node, length, counter+1);

            if(sibling == null)
                return null;

            if(sibling.value == head.value){
                if(counter == 0){
                    return head;
                }
                return sibling.next_node;
            }else{
                return null;
            }
        }else{
            return head.next_node;
        }

    }
}
