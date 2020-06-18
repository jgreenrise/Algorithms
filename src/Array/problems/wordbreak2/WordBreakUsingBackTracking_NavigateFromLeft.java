package Array.problems.wordbreak2;

import java.util.*;

// Memoization not developed
/**
 * https://leetcode.com/problems/word-break-ii/submissions/
 */
public class WordBreakUsingBackTracking_NavigateFromLeft {

    public static void main(String args[]) {
        String str = "catsanddog";
        List<String> words = Arrays.asList("cat", "cats", "and", "sand", "dog", "");

        //str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //words = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        str = "catsanddogo";
        words = Arrays.asList("cat", "cats", "and", "sand", "dog", "do", "go");

        /*str = "catsanddogo";
        words = Arrays.asList("cat", "cats", "and", "sand", "dog", "do", "go");
*/
        WordBreakUsingBackTracking_NavigateFromLeft class1 = new WordBreakUsingBackTracking_NavigateFromLeft();
        System.out.println(class1.wordBreak(str, words));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        if (wordDict.size() == 0) {
            return wordDict;
        }

        wordDict.sort(Comparator.comparingInt(String::length));
        int maxLen = wordDict.stream().reduce((f, se) -> se).get().length();
        Set<String> set = new HashSet(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        List<String> out = new ArrayList<>();
        getRemWords(set, maxLen, 0, new StringBuilder(), s, out, "", memo);
        return out;

    }

    public void getRemWords(Set<String> set, int maxL, int index, StringBuilder sbr, String s, List<String> list, String currWord, Map<String, List<String>> memo) {

        if (index >= s.length()) {
            if (sbr.length() == 0 && currWord.length() > 0) {
                list.add(currWord);
            }
        }

        if(index >= s.length()){
            return;
        }
        sbr.append(s.charAt(index));

        if (set.contains(sbr.toString())) {

            String currString = currWord + " " + sbr.toString();
            getRemWords(set, maxL, index + 1, new StringBuilder(), s, list, currString.trim(), memo);

            if (sbr.toString().length() < maxL) {
                getRemWords(set, maxL, index + 1, sbr, s, list, currWord, memo);
            }
        } else {
            getRemWords(set, maxL, index + 1, sbr, s, list, currWord, memo);
        }

    }

}
