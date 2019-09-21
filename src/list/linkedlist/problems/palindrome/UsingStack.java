package list.linkedlist.problems.palindrome;

import list.linkedlist.single.Node;
import list.linkedlist.single.SinglyLinkedList;

import java.util.Stack;

public class UsingStack {

    public static void main(String[] args) {

        //  100 > 200 > 300 > 400
        SinglyLinkedList node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 2, 1});
        System.out.println("Is palindrome: "+ isPalindromeUsingStack(node.start));

        node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 4, 2, 1});
        System.out.println("Is palindrome: "+ isPalindromeUsingStack(node.start));

        node = SinglyLinkedList.createLL(new int[] {1, 2, 3, 4, 3, 2, 1});
        System.out.println("Is palindrome: "+ isPalindromeUsingStack(node.start));
    }

    public static boolean isPalindromeUsingStack(Node node){

        Node slow = node;
        Node fast = node;
        Stack<Node> stack = new Stack<>();

        while(slow.next_node != null && fast.next_node.next_node != null){
            stack.push(slow);
            slow = slow.next_node;
            fast = fast.next_node.next_node;
        }

        if(fast.next_node != null){
            stack.add(slow.next_node);
        }else{
            slow = slow.next_node;
        }

        return compareStackWithSlowElements(slow, stack);
    }

    private static boolean compareStackWithSlowElements(Node slow, Stack stack) {

        boolean isPalindrome = false;

        while (slow != null){
            if(slow.value == ((Node) stack.pop()).value){
                isPalindrome = true;
            }else{
                isPalindrome = false;
                break;
            }

            slow = slow.next_node;
        }

        return isPalindrome;
    }
}
