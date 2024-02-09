import java.util.HashMap;
import java.util.Map;

public class a_0211_designAddAndSearchWord {

    TrieNode trie;

    public a_0211_designAddAndSearchWord() {
        trie = new TrieNode();
    }

    public void addWord(String word, int index) {
        TrieNode node = trie;

        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
        node.index = index;
    }

    /**
     * Returns if the word is in the node.
     */
    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.isEndOfWord;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchInNode(word, trie);
    }

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
        int index;
    }


}
