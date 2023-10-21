package list.linkedlist.problems.palindrome;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class IsPalindromeByReverse {

    public static void main(String[] args) {

        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 2, 1});
        System.out.println("Input Value - Odd elems: "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1});
        System.out.println("Input Value - Odd elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 3, 2, 1});
        System.out.println("Input Value - Odd elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 3, 4, 2, 1});
        System.out.println("Input Value - Odd elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 2, 1});
        System.out.println("Input Value - Even elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 1});
        System.out.println("Input Value - Even elems "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));

        node = SinglyLinkedList.createLL(new int[]{1, 2, 1, 1, 2, 3});
        System.out.println("Input Value - Even elems - Negative Test case "+node.printLL()+"\tIs palindrome: " + isPalindrome(node.start));
    }

    public static boolean isPalindrome(ListNode node){

        // Reverse LL AND find length of LL
        ListNode original = node;
        ListNode rvNode = null;
        int counter= 0;
        while(node != null){
            ListNode newNode = new ListNode(node.val);
            if(rvNode == null){
                rvNode = newNode;
            }else{
                newNode.next = rvNode;
                rvNode = newNode;
            }
            counter++;
            node = node.next;
        }

        return compareReverseAndOriginalLL(counter, rvNode, original);
    }

    private static boolean compareReverseAndOriginalLL(int counter, ListNode rvNode, ListNode original) {

        // Compare reverse and original LL till midway
        boolean isPalindrome = true;
        for(int i= 0; i < counter/2; i++){
            if(original.val == rvNode.val){
                original = original.next;
                rvNode = rvNode.next;
            }else{
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
