package Array.problems.lruCache;

import java.util.LinkedHashMap;

public class LRUCacheLinkedHashMap {

    public static LinkedHashMap<Integer, Integer> linkedHm;

    public static void main(String[] args) {

        int capacity = 2;
        LRUCacheLinkedHashMap cache = new LRUCacheLinkedHashMap(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    public LRUCacheLinkedHashMap(int capacity) {
        linkedHm = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        return linkedHm.get(key);
    }

    public void put(int key, int value) {
        linkedHm.put(key, value);
    }
}
