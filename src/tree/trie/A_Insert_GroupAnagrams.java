package tree.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A_Insert_GroupAnagrams {

    private final Trie root;

    public A_Insert_GroupAnagrams() {
        root = new Trie();
    }

    public static void main(String args[]) {
        Trie root = new Trie();
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Arrays.sort(words);
        for (String word : words) {
            System.out.println(word);
        }
        for (String word : words) {
            //insertRecursiveWord(word, root);
        }
        System.out.println("alpha bets");
    }

    private static void insertRecursiveWord(String word, Trie root) {
        insertRecursiveWord(word, 0, root);
    }

    private static void insertRecursiveWord(String word, int index, Trie node) {
        if (index == word.length()) {
            node.isCompleted = true;
        } else {
            char ch = word.charAt(index);
            Trie curr = node.getMap().get(ch);
            if (curr == null) {
                curr = new Trie();
                node.getMap().put(ch, curr);
            }
            insertRecursiveWord(word, index + 1, curr);
        }
    }

    private static class Trie {
        public boolean isCompleted;
        public Map<Character, Trie> map;

        public Trie() {
            map = new HashMap<>();
        }

        public Map<Character, Trie> getMap() {
            return map;
        }

        public void setMap(Map<Character, Trie> map) {
            this.map = map;
        }
    }
}
