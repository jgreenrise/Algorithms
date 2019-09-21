package list.linkedlist.problems.palindrome;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

public class IsPalindromeByReverse {

    public static void main(String[] args) {

        //  100 > 200 > 300 > 400
        SinglyLinkedList node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 2, 1});
        System.out.println("Is palindrome: "+isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 4, 2, 1});
        System.out.println("Is palindrome: "+isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 4, 3, 2, 1});
        System.out.println("Is palindrome: "+isPalindrome(node.start));
    }

    // 1 > 2 > 3 > 4 > 3 > 2 > 1
    public static boolean isPalindrome(Node node){

        // Reverse LL AND find length of LL
        Node original = node;
        Node rvNode = null;

        int counter= 0;
        while(node != null){
            Node newNode = new Node(node.value);
            if(rvNode == null){
                rvNode = newNode;
            }else{
                newNode.next_node = rvNode;
                rvNode = newNode;
            }
            counter++;
            node = node.next_node;
        }

        return compareReverseAndOriginalLL(counter, rvNode, original);
    }

    private static boolean compareReverseAndOriginalLL(int counter, Node rvNode, Node original) {

        // Compare reverse and original LL till midway
        boolean isPalindrome = true;
        for(int i= 0; i < counter/2; i++){
            if(original.value == rvNode.value){
                original = original.next_node;
                rvNode = rvNode.next_node;
            }else{
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
