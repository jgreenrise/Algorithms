import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a_0648_ReplaceWords {

    public class Trie {
        public Map<Character, Trie> map;
        public boolean isEndOfWord;
        public int index;

        public Trie() {
            this.map = new HashMap<>();
        }
    }

    public void buildtrie(int index, String word, Trie node, int wordindex) {
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

    public String replaceWords(List<String> dictionary, String sentence) {

        Trie root = new Trie();
        for (int k = 0; k < dictionary.size(); k++) {
            buildtrie(0, dictionary.get(k), root, k);
        }

        String[] words = sentence.split(" ");
        String[] out = new String[words.length];
        int outCounter = 0;

        for (String word : words) {
            if (root.map.containsKey(word.charAt(0))) {
                String resp = replaceWordFromTrie(root.map.get(word.charAt(0)), word, 1, dictionary);
                out[outCounter++] = resp == null ? word : resp;
            } else {
                out[outCounter++] = word;
            }
        }

        System.out.println(Arrays.toString(out));
        return String.join(" ", out);
    }

    public String replaceWordFromTrie(Trie node, String word, int index, List<String> dictionary) {

        if (node.isEndOfWord) {
            return dictionary.get(node.index);
        }

        // a
        char ch = word.charAt(index);
        if (node.map.containsKey(ch)) {
            return replaceWordFromTrie(node.map.get(ch), word, index + 1, dictionary);
        } else {
            return null;
        }
    }

}