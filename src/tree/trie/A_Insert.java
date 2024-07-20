package tree.trie;

public class A_Insert {

    private final CustomTrieNode root;

    public A_Insert() {
        root = new CustomTrieNode();
    }

    public static void main(String args[]) {
        A_Insert class1 = new A_Insert();
        String[] words = {"abc", "abgl", "cdf", "abcd", "lmn"};
        for (String word : words) {
            class1.insertRecursiveWord(word);
        }
        System.out.println("alpha bets");
    }

    // Iterative
    private void insertWord(String word) {
        CustomTrieNode curr = root;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            CustomTrieNode node = curr.getMap().get(ch);
            if (node == null) {
                node = new CustomTrieNode();
                curr.getMap().put(ch, node);
            }
            curr = node;
        }
        curr.isCompleted = false;
    }

    // Recursive
    private void insertRecursiveWord(String word) {
        insertRecursiveWord(word, 0, root);
    }

    private void insertRecursiveWord(String word, int index, CustomTrieNode node) {
        if (index == word.length()) {
            node.isCompleted = true;
        } else {

            char ch = word.charAt(index);
            CustomTrieNode curr = node.getMap().get(ch);
            if (curr == null) {
                curr = new CustomTrieNode();
                node.getMap().put(ch, curr);
            }

            insertRecursiveWord(word, index+1, curr);
        }
    }


}
