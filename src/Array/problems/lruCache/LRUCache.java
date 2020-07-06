package Array.problems.lruCache;

import java.util.HashMap;

public class LRUCache {

    public HashMap<Integer, DoublyLinkedList> map = null;
    public int capacity = 0;
    public int counter = 0;
    DoublyLinkedList head = null;
    DoublyLinkedList tail = null;

    public LRUCache(int capacity) {
        map = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyLinkedList node = map.get(key);

        if (node == null) {
            return -1;
        } else {
            int response = node.value;
            remove(node);
            put(key, response);
            return response;
        }
    }

    public void remove(DoublyLinkedList node) {

        // Remove node from Map
        map.remove(node.key);

        // Remove node
        DoublyLinkedList prev = node.prev;
        DoublyLinkedList next = node.next;
        if (prev != null)
            prev.next = next;

        if (next != null)
            next.prev = prev;

        // Reassign Tail
        if (node.value == tail.value && node.key == tail.key) {
            tail = prev;
        }

        // Reassign Head
        if(node.value == head.value && node.key == head.key){
            head = next;
        }

    }

    public void put(int key, int value) {
        DoublyLinkedList newNode = new DoublyLinkedList(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            if (map.containsKey(key)) {

                // Handle duplicate key
                remove(map.get(key));
                put(key, value);
            }

            if (!map.containsKey(key) && map.size() == capacity) {
                // Remove node, when capacity is full
                remove(tail);
                put(key, value);
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

            if (tail == null) {
                tail = head;
            }
        }
        map.put(key, newNode);
    }

    public static void main(String args[]) {

        LRUCache cache = new LRUCache(2);
        /*cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4*/

        cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2);       // returns 1
        cache.put(3, 2);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns -1 (not found)

/*        cache = new LRUCache(2);
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);    // evicts key 2
        cache.put(1, 2);    // evicts key 2
        cache.get(1);       // returns -1 (not found)
        cache.get(2);       // returns -1 (not found)*/

/*        cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);*/

        cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        cache.get(3);
        cache.get(2);
        cache.put(4, 3);
        cache.get(2);
        cache.get(3);
        cache.get(4);
    }

    class DoublyLinkedList {
        int key;
        int value;
        DoublyLinkedList prev;
        DoublyLinkedList next;

        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}