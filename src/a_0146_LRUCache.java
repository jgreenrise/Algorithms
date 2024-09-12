import java.util.HashMap;
import java.util.Map;

class a_0146_LRUCache {

    int capacity = 0;
    CustomNode head = null, tail = null;
    Map<Integer, CustomNode> map = null;

    public class CustomNode {
        public int key;
        public int val;
        public CustomNode next;
        public CustomNode prev;

        public CustomNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public a_0146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new CustomNode(-1, -1);
        tail = new CustomNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void deleteNode(CustomNode node) {
        CustomNode prev = node.prev;
        CustomNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addNode(CustomNode node) {
        CustomNode temp = head.next;
        head.next = node;

        node.next = temp;
        node.prev = head;

        temp.prev = node;

    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        CustomNode node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        CustomNode newnode = new CustomNode(key, value);

        if (map.containsKey(key)) {
            deleteNode(map.get(key));
            addNode(newnode);
            map.put(key, newnode);
        } else {
            if (map.size() == capacity) {
                int leastUsedKey = tail.prev.key;
                deleteNode(tail.prev);
                map.remove(leastUsedKey);
            }

            addNode(newnode);
            map.put(key, newnode);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */