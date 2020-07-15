package Array.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {

    public static void main(String[] args) {

        LongestStringChain class1 = new LongestStringChain();
        //System.out.println(class1.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(class1.longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));

    }

    public int longestStrChain(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }

        // Sort by length
        Arrays.sort(words, (l1, l2) -> l1.length() - l2.length());

        Map<String, Integer> map = new HashMap<>();
        int maxLen = words[0].length();
        map.put(words[0], 1);
        boolean matchFound = false;

        for (int j = 1; j < words.length; j++) {

            String word = words[j];
            matchFound = false;

            if (word.length() == 1) {
                map.put(words[j], 1);
            } else {

                int currMax = 0;
                for (int i = 0; i < word.length(); i++) {
                    String currTrimWord = word.substring(0, i) + word.substring(i + 1, word.length());

                    if (map.containsKey(currTrimWord)) {
                        matchFound = true;

                        if (map.get(currTrimWord) + 1 > currMax) {
                            currMax = map.get(currTrimWord) + 1;
                            map.put(word, currMax);

                            if (maxLen < currMax) {
                                maxLen = currMax;
                            }
                        }
                    }
                }

                if (!matchFound) {
                    map.put(word, 1);
                }

            }

        }

        return maxLen;
    }

}