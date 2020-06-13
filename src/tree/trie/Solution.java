package tree.trie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class Solution {

    public static void main(String args[]) {

        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String [] words = {"oath","pea","eat","rain"};

        // eg 2
        board = new char[][]{{'a'}};
        words = new String[]{"a"};
/*

        // eg 3
        board = new char[][]{{'a'}};
        words = new String[]{"ab"};

        // eg 4
        board = new char[][]{{'a'}};
        words = new String[]{"b"};

        // eg 5
        board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        words = new String[]{"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
*/

        Solution class1 = new Solution();
        System.out.println(class1.findWords(board, words));

    }

    public final TrieNode root;

    public Solution(){
        root = new TrieNode();
    }

    public List<String> findWords(char[][] board, String[] words) {

        Solution class1 = new Solution();
        int index = 0;
        for(String word: words){
            class1.insert(word, index++);
        }

        int rows = board.length;
        int cols = board[0].length;

        return findWordsInMat(board, words, rows, cols, class1.root);

    }

    public List<String> findWordsInMat(char[][] board, String[] words, int rows, int cols, TrieNode root){

        Set<String> out = new HashSet<>();
        TrieNode curr = root;
        Set<String> set = new HashSet<>();

        for(int row =0; row< rows; row++){
            for(int col=0; col < cols; col++){
                findWordsAtCell(row, col, board, words, rows, cols, curr, set);
            }
        }
        return set.stream().collect(Collectors.toList());

    }

    public void findWordsAtCell(int currR, int currC, char[][] board, String[] words, int rows, int cols, TrieNode node, Set<String> set){

        String currOut = "";
        // Check if currR and currC within range
        if(currR < 0 || currR >= rows || currC < 0 || currC >= cols){
            return;
        }

        if(rows == 1 && cols == 1){
            if(node.map.containsKey(board[currR][currC]) && words[0].length() == 1) {
                set.add(words[0]);
            }
        }

        if(node.isEndOfWord){
            set.add(words[node.index]);
        }

        // If current cell exists in Parent TRI node
        char ch = board[currR][currC];
        if(node.map.containsKey(ch)){

            int [] dr = {-1, 0, 0, 1};
            int [] dc = {0, -1, 1, 0};

            for(int direction = 0; direction<4; direction ++){

                char tmp = board[currR][currC];
                board[currR][currC] = '0';
                findWordsAtCell(currR+dr[direction], currC+dc[direction], board, words, rows, cols, node.map.get(ch), set);
                board[currR][currC] = tmp;

            }

        }

    }

    public void insert(String word, int index){

        TrieNode curr = root;
        for(int j=0; j<word.length(); j++){
            char ch = word.charAt(j);
            TrieNode node = curr.map.get(ch);
            if(node == null){
                node = new TrieNode();
                curr.map.putIfAbsent(ch, node);
            }

            curr = curr.map.get(ch);
        }
        curr.isEndOfWord=true;
        curr.index = index;

    }

    public static class TrieNode{
        Map<Character, TrieNode> map;
        boolean isEndOfWord;
        int index;

        public TrieNode(){
            map = new HashMap();
        }

    }


}
