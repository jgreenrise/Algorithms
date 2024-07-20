package tree.trie;

import java.util.HashMap;

public class CustomTrieNode {

    HashMap<Character, CustomTrieNode> map;
    boolean isCompleted;

    public CustomTrieNode(HashMap<Character, CustomTrieNode> map) {
        this.map = map;
    }

    public CustomTrieNode() {
        this.map = new HashMap<>();
        this.isCompleted = false;
    }

    public CustomTrieNode(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setMap(HashMap<Character, CustomTrieNode> map) {
        this.map = map;
    }

    public HashMap<Character, CustomTrieNode> getMap() {
        return map;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
