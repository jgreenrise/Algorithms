package tree.trie;

public class C_CheckWordExists {

    private final CustomTrieNode root;

    public C_CheckWordExists() {
        root = new CustomTrieNode();
    }

    public static void main(String args[]) {
        C_CheckWordExists class1 = new C_CheckWordExists();
        String[] words = {"abc", "abgl", "cdf", "abcd", "lmn"};
        for (String word : words) {
            class1.insertRecursiveWord(word);
        }

        String[] wordsExist = {"lmn", "ab", "cdf", "ghi"};
        for (String word : wordsExist) {
            System.out.println("Does exist > "+word+": "+class1.doesExist(word));
        }

    }

    private boolean doesExist(String word) {
        CustomTrieNode curr = root;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            if(curr.getMap().containsKey(ch)){
                curr = curr.getMap().get(ch);
            }else{
                return false;
            }
        }

        if(curr.isCompleted){
            return true;
        }

        return false;

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
