package tree.trie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 */
public class H_AnalyzeWebsitesByUser {

    public static void main(String args[]) {

        H_AnalyzeWebsitesByUser class1 = new H_AnalyzeWebsitesByUser();
        String[] usernames = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamps = {1,2,3,4,5,6,7,8,9,10};
        String[] websites = {"home","about","career","home","cart","maps","home","home","about","career"};
        System.out.println(class1.mostVisitedPattern(usernames, timestamps, websites));
    }

    public class TrieNode{
        Map<String, TrieNode> map;
        boolean isEndOfWord;

        public TrieNode(){
            map = new HashMap();
        }
    }

    public TrieNode root;

    public H_AnalyzeWebsitesByUser(){
        root = new TrieNode();
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Set<String> users = Arrays.stream(username).collect(Collectors.toSet());
        H_AnalyzeWebsitesByUser class1 = new H_AnalyzeWebsitesByUser();
        TrieNode curr = class1.root;
        List<String> out = new ArrayList();

        for(String user: users){
            List<String> websites = getWebsitesByUser(user, username, timestamp, website);
            // "home","cart","maps","home"

            if(websites.size() == 3){
                class1.insert(new String []{websites.get(0),websites.get(1), websites.get(2)} , curr, out);
            }else{
                for(int i = 0 ; i < websites.size(); i++){
                    for(int j = i+1 ; j < websites.size() && j+1 < websites.size(); j++){
                        class1.insert(new String[]{websites.get(i), websites.get(j), websites.get(j+1)}, curr, out);
                    }
                }
            }

        }

        return out;

    }

    public void insert(String [] words, TrieNode node, List<String> out){

        TrieNode curr = node;
        for(int j=0 ; j< words.length; j++){
            String word = words[j];
            TrieNode newNode = new TrieNode();
            curr.map.putIfAbsent(word, newNode);
            curr = curr.map.get(word);
        }

        if(curr.isEndOfWord){
            out.add(words[0]);
            out.add(words[1]);
            out.add(words[2]);
        }

        curr.isEndOfWord = true;

    }



    public List<String> getWebsitesByUser(String user, String[] username, int[] timestamp, String[] website){

        List<String> out = new ArrayList();

        for(int j=0; j< username.length; j++){
            if(username[j].equals(user)){
                out.add(website[j]);
            }
        }

        return out;

    }

}
