package tree.trie;

public class B_CheckWordWithPrefixExists {

    private final TrieNode root;

    public B_CheckWordWithPrefixExists() {
        root = new TrieNode();
    }

    public static void main(String args[]) {
        B_CheckWordWithPrefixExists class1 = new B_CheckWordWithPrefixExists();
        String[] words = {"abc", "abgl", "cdf", "abcd", "lmn"};
        for (String word : words) {
            class1.insertRecursiveWord(word);
        }

        String[] wordsExist = {"ab", "lo", "lm", "abc"};
        for (String word : wordsExist) {
            System.out.println("Does exist > "+word+": "+class1.doesExist(word));
        }

    }

    private boolean doesExist(String word) {
        TrieNode curr = root;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            if(curr.getMap().containsKey(ch)){
                curr = curr.getMap().get(ch);
            }else{
                return false;
            }
        }

        if(!curr.isCompleted){
            return true;
        }

        return false;

    }

    // Iterative
    private void insertWord(String word) {
        TrieNode curr = root;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            TrieNode node = curr.getMap().get(ch);
            if (node == null) {
                node = new TrieNode();
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

            insertRecursiveWord(word, index+1, curr);
        }
    }


}
