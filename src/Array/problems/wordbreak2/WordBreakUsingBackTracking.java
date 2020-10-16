package Array.problems.wordbreak2;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/submissions/
 */
public class WordBreakUsingBackTracking {

    public static void main(String args[]) {
        String str = "catsanddog";
        List<String> words = Arrays.asList("cat", "cats", "and", "sand", "dog", "");

        //str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //words = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        str = "catsanddog";
        words = Arrays.asList("cat", "cats", "and", "sand", "dog");

        str = "catsanddogo";
        words = Arrays.asList("cat", "cats", "and", "sand", "dog", "do", "go");

        WordBreakUsingBackTracking class1 = new WordBreakUsingBackTracking();
        System.out.println(class1.wordBreak(str, words));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        if(wordDict.size() == 0){
            return wordDict;
        }

        // Sort by length
        wordDict.sort(Comparator.comparingInt(String::length));

        // Max length
        int maxLen = wordDict.stream().reduce((f,se) -> se).get().length();

        // Set
        Set<String> set = new HashSet(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        List<String> out = new ArrayList<>();
        getRemWords(set, maxLen, s.length()-1, new StringBuilder(), s, out, "", memo);
        return out;

    }

    public void getRemWords(Set<String> set, int maxL, int index, StringBuilder sbr, String s, List<String> list, String currWord, Map<String, List<String>> memo){

        System.out.println("Word: "+currWord);
        if(memo.containsKey(currWord)){
            list.addAll(memo.get(currWord));
            return;
        }

        if(index < 0){
            if(sbr.length() == 0 && currWord.length() > 0){
                list.add(currWord);
                memo.putIfAbsent(currWord, list);
            }
            return;
        }

        sbr.insert(0, s.charAt(index));

        if(set.contains(sbr.toString())){

            String currString = sbr.toString()+" "+currWord;
            getRemWords(set, maxL, index-1, new StringBuilder(), s, list, currString.trim(), memo);
            if(index > 0 && sbr.toString().length() < maxL){
                getRemWords(set, maxL, index-1, sbr, s, list, currWord, memo);
            }
        }else{
            getRemWords(set, maxL, index-1, sbr, s, list, currWord, memo);
        }

    }

}
