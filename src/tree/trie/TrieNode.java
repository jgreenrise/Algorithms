package tree.trie;

import java.util.HashMap;

public class TrieNode {

    HashMap<Character, TrieNode> map;
    boolean isCompleted;

    public TrieNode(HashMap<Character, TrieNode> map) {
        this.map = map;
    }

    public TrieNode() {
        this.map = new HashMap<>();
        this.isCompleted = false;
    }

    public TrieNode(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setMap(HashMap<Character, TrieNode> map) {
        this.map = map;
    }

    public HashMap<Character, TrieNode> getMap() {
        return map;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
