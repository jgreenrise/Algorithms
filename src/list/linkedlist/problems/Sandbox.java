package list.linkedlist.problems;

import list.linkedlist.single.ListNode;
import list.linkedlist.single.SinglyLinkedList;

import java.util.Arrays;

import static list.linkedlist.single.ListNode.printLL;

public class Sandbox {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //String str1 = "hit";
        String str1 = "dot";
        String str2 = "hot";

        int xor1 = 0;
        for (char c : str1.toCharArray()) {
            xor1 = c ^ xor1;
        }

        int xor2 = 0;
        for (char c : str2.toCharArray()) {
            xor2 = c ^ xor2;
        }

        System.out.println(str1);

    }


}
