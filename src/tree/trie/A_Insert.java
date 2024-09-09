package tree.trie;

import java.util.HashMap;
import java.util.Map;

public class A_Insert {

    private final CustomTrieNode root;

    public A_Insert() {
        root = new CustomTrieNode();
    }

    public static void main(String args[]) {
        A_Insert class1 = new A_Insert();
        String[] words = {"abc", "abgl", "cdf", "abcd", "lmn"};

        for (int k = 0; k < words.length; k++) {
            buildtrie(0, words[k], root, k);
        }
        System.out.println("alpha bets");
    }


    public static class Trie {
        public Map<Character, Trie> map;
        public boolean isEndOfWord;
        public int index;

        public Trie() {
            this.map = new HashMap<>();
        }
    }

    public static void buildtrie(int index, String word, Trie node, int wordindex) {
        if (index >= word.length()) {
            node.isEndOfWord = true;
            node.index = wordindex;
            return;
        }

        char ch = word.charAt(index);
        Trie curr = node.map.get(ch);

        if (curr == null) {
            curr = new Trie();
            node.map.put(ch, curr);
        }
        buildtrie(index + 1, word, curr, wordindex);
    }


}
