package list.linkedlist.problems.palindrome;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

public class QuestionIsLLPalindrome {
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

    private static String isPalindrome(ListNode start) {
        return null;
    }
}
