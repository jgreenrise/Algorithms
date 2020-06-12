package tree.trie;

import java.util.HashMap;

public class D_DeleteWord {

    private final TrieNode root;

    public D_DeleteWord() {
        root = new TrieNode();
    }

    public static void main(String args[]) {
        D_DeleteWord class1 = new D_DeleteWord();
        String[] words = {"abc", "abgl", "cdf", "abcd", "lmn"};
        for (String word : words) {
            class1.insertRecursiveWord(word);
        }

        String[] wordsExist = {"abc", "abgl", "abcd"};
        for (String word : wordsExist) {
            class1.deleteWord(word);
            System.out.println("Deleted exist > " + word);
        }

    }

    private void deleteWord(String word) {
        deleteWord(word, 0, root);
    }

    private boolean deleteWord(String word, int index, TrieNode node) {

        if (index == word.length()) {
            if (node.getMap().size() == 0) {
                return true;
            } else {
                node.isCompleted = false;
                return false;
            }
        }

        TrieNode newnode = node.getMap().get(word.charAt(index));
        if (newnode == null) {
            return false;
        }

        boolean shouldDeleteCurrNode = deleteWord(word, index + 1, newnode);

        if (shouldDeleteCurrNode) {
            node.getMap().remove(word.charAt(index));
            return node.getMap().size() == 0;
        }

        return shouldDeleteCurrNode;

    }

    // Recursive
    private void insertRecursiveWord(String word) {
        insertRecursiveWord(word, 0, root);
    }

    private void insertRecursiveWord(String word, int index, TrieNode node) {
        if (index == word.length()) {
            node.isCompleted = true;
        } else {

            char ch = word.charAt(index);
            TrieNode curr = node.getMap().get(ch);
            if (curr == null) {
                curr = new TrieNode();
                node.getMap().put(ch, curr);
            }

            insertRecursiveWord(word, index + 1, curr);
        }
    }


}
