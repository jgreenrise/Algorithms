package tree.trie;

import java.util.*;

public class G_ConcatenatedWords_20200613 {

    public static void main(String args[]) {

        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        G_ConcatenatedWords_20200613 class1 = new G_ConcatenatedWords_20200613();
        //String[] words = {"cat", "dog", "catdog", "cats", "dogcat", "catsdog"};
        //String[] words = {"cat", "dog", "cats", "catsdog"};
        System.out.println(class1.findAllConcatenatedWordsInADict(words));
    }

    public TrieNode root;

    public G_ConcatenatedWords_20200613() {
        root = new TrieNode();
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        G_ConcatenatedWords_20200613 class1 = new G_ConcatenatedWords_20200613();
        TrieNode curr = class1.root;
        List<String> out = new ArrayList();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int index = 0;
        for (int j = 0; j < words.length; j++) {
            insertWord(words[j], curr, index++, words, out);
        }

        return out;

    }

    public void insertWord(String word, TrieNode node, int index, String[] words, List<String> out) {

        TrieNode curr = node;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            TrieNode newNode = new TrieNode();

            if (curr.isEndOfWord) {
                boolean matchFound = searchInSet(curr.index,words, word.substring(words[curr.index].length()), node);
                if (matchFound) {
                    out.add(word);
                    return;
                }
            }

            if (curr.map.containsKey(ch)) {
                newNode = curr.map.get(ch);
            } else {
                curr.map.put(ch, newNode);
            }
            curr = newNode;
        }
        curr.isEndOfWord = true;
        curr.index = index;

    }

    public boolean searchInSet(int index, String[] words, String word, TrieNode node) {

        TrieNode curr = node;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            TrieNode newNode = new TrieNode();

            if (curr.map.containsKey(ch)) {
                newNode = curr.map.get(ch);
            } else {

                if (curr.isEndOfWord) {
                    return searchInSet(curr.index, words, word.substring(words[curr.index].length()), node);
                }
                return false;
            }
            curr = newNode;
        }
        return true;

    }

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfWord;
        int index;

        public TrieNode() {
            map = new HashMap();
        }

    }

}
