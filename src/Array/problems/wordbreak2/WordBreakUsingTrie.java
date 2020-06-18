package Array.problems.wordbreak2;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/submissions/
 */
public class WordBreakUsingTrie {

    public static void main(String args[]) {
        String str = "catsanddog";
        List<String> words = Arrays.asList("cat", "cats", "and", "sand", "dog");
        WordBreakUsingTrie class1 = new WordBreakUsingTrie();
        System.out.println(class1.wordBreak(str, words));
    }

    public TrieNode root;

    public WordBreakUsingTrie() {
        root = new TrieNode();
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        WordBreakUsingTrie class1 = new WordBreakUsingTrie();
        TrieNode curr = class1.root;
        int index = 0;
        List<String> out = new ArrayList<>();

        // INSERT IN TRIE
        for (int j = 0; j < wordDict.size(); j++) {
            insertWord(wordDict.get(j), curr, index++);
        }

        // SEARCH IN TRIE
        searchWordsInTrie(s, wordDict, curr, out, "", 0, s.length());

        return out;

    }

    private String searchWordsInTrie(String word, List<String> list, TrieNode node, List<String> out, String currOutputStr, int start, int end) {

        TrieNode curr = node;
        for (int j = start; j < end; j++) {

            if(curr.isEndOfWord){
                String wordAtNode = list.get(curr.index);
                String currWord = currOutputStr.isEmpty() ? wordAtNode : currOutputStr + " "+ wordAtNode;
                searchWordsInTrie(word, list, node, out, currWord, j, end);
            }

            char ch = word.charAt(j);
            TrieNode newNode = new TrieNode();
            if (curr.map.containsKey(ch)) {
                newNode = curr.map.get(ch);
            } else {
                return "";
            }
            curr = newNode;
        }

        if(curr.isEndOfWord){
            String wordAtNode = list.get(curr.index);
            String currWord = currOutputStr.isEmpty() ? wordAtNode : currOutputStr + " "+ wordAtNode;
            out.add(currWord);
        }

        return "";

    }

    public void insertWord(String word, TrieNode node, int index) {

        TrieNode curr = node;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            TrieNode newNode = new TrieNode();
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
