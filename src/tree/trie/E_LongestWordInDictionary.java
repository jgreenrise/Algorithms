package tree.trie;

import java.util.*;

//https://leetcode.com/problems/longest-word-in-dictionary/


public class E_LongestWordInDictionary {

    private final TriIntNode root;

    public E_LongestWordInDictionary() {
        root = new TriIntNode('0');
    }

    public static void main(String args[]) {
        E_LongestWordInDictionary class1 = new E_LongestWordInDictionary();
        String[] words = {"a", "app", "banana", "appl", "ap", "apply", "apple"};
        int index = 1;
        for (String word : words) {
            class1.insert(word, index++);
        }

        System.out.println(class1.dfs(words));

    }

    private String dfs(String[] words) {
        TriIntNode curr = root;
        Stack<TriIntNode> stack = new Stack<>();
        stack.push(root);

        int length = 0;
        String ans = "";

        while (!stack.isEmpty()) {

            TriIntNode pop = stack.pop();

            // if end node or Root node
            if (pop.end > 0 || pop == root) {

                if (pop != root) {
                    String word = words[pop.end-1];

                    if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                        ans = word;
                    }
                }

                for (TriIntNode node : pop.children.values()) {
                    stack.add(node);
                }
            }

        }

        return ans;

    }

    public void insert(String word, int index) {
        TriIntNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TriIntNode(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }

    class TriIntNode {
        char c;
        HashMap<Character, TriIntNode> children = new HashMap();
        int end;

        public TriIntNode(char c) {
            this.c = c;
        }
    }

}
