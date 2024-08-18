package tree.trie;

import java.util.*;

public class G_ConcatenatedWords_20200613 {

    public static void main(String[] args) {

        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        G_ConcatenatedWords_20200613 class1 = new G_ConcatenatedWords_20200613();
        //String[] words = {"cat", "dog", "catdog", "cats", "dogcat", "catsdog"};
        //String[] words = {"cat", "dog", "cats", "catsdog"};
        System.out.println(class1.findAllConcatenatedWordsInADict(words));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        CustomNode rootNode = new CustomNode();
        for(String word:words){
            buildTrie(word, 0, rootNode);
        }

        Set<String> cache = new HashSet<>();
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (isConcatenated(rootNode, word, 0, 0, cache))
                result.add(word);
        }
        return result;
    }


    boolean isConcatenated(CustomNode rootNode, String word, int index, int totalWordsAdded, Set<String> cache) {

        // Is concatenated, if formed using 2 or more words (totalWordsAdded)
        if(index >= word.length() && totalWordsAdded >= 2)
            return true;

        System.out.println("Check  if word exist: "+word.substring(index));

        CustomNode ptr = rootNode;
        for (int i = index; i < word.length(); i++) {
            if (ptr == null || ptr.map.isEmpty() || !ptr.map.containsKey(word.charAt(i)))
                return false;

            ptr = ptr.map.get(word.charAt(i));

            if (ptr.isLastCustomNode)

                if(cache.contains(word.substring(i + 1)) && totalWordsAdded + 1 >= 2){
                    return true;
                }

                if (isConcatenated(rootNode, word, i + 1, totalWordsAdded + 1, cache)){
                    cache.add(word.substring(i + 1));
                    return true;
                }

        }

        return false;
    }

    public CustomNode buildTrie(String str, int index, CustomNode node){

        if(index >= str.length()){
            node.isLastCustomNode = true;
            return node;
        }

        if(node.map.containsKey(str.charAt(index))){
            return buildTrie(str, index+1, node.map.get(str.charAt(index)));
        }else{
            CustomNode childCustomNode = buildTrie(str, index+1, new CustomNode());
            node.map.put(str.charAt(index), childCustomNode);
            return node;
        }

    }
}


class CustomNode{

    public Map<Character, CustomNode> map;
    public boolean isLastCustomNode;

    public CustomNode(){
        map = new HashMap();
        isLastCustomNode = false;
    }

}
