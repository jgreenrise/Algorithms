package list.linkedlist.problems.duplicate;


import list.linkedlist.single.SinglyLinkedList;
import list.linkedlist.single.ListNode;

import java.util.HashMap;
import java.util.Map;

public class EmptyRemoveDupsFromLinkedList {

    public static void main(String[] args) {


        EmptyRemoveDupsFromLinkedList obj = new EmptyRemoveDupsFromLinkedList();
        //SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{10,10,10,20,20});
        //SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{3,2,2,1});
        SinglyLinkedList node = SinglyLinkedList.createLL(new int[]{2,1,1,2});
        obj.deleteDuplicates(node.start);
        node.printList();

    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        // ROOT node
        ListNode node = head;

        Map<Integer, Integer> map = new HashMap();
        map.put(node.val, 1);

        while (node.next != null) {
            if (map.containsKey(node.next.val)) {
                int value = map.get(node.next.val);
                map.put(node.next.val, value + 1);
            } else {
                map.put(node.next.val, 1);
            }
            node = node.next;
        }

        // ROOT node
        node = head;

        // Find 1st node which does not have dups
        while(node != null){
            if(map.get(node.val) > 1){
                node = node.next;
            }else{
                break;
            }
        }

        if(node == null)
            return null;

        // map 1:1, 2:2, 3:1
        // 1, 2, 2, 3
        while(node != null && node.next != null){
            if(map.get(node.next.val) > 1){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }

        return head;


    }


}
