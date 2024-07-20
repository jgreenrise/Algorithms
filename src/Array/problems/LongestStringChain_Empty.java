package Array.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain_Empty {

    public static void main(String[] args) {
        LongestStringChain_Empty class1 = new LongestStringChain_Empty();
        String [] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(class1.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {

        List<String> list = Arrays.asList(words);
        list.sort((a,b) -> a.length() - b.length());
        return 0;


    }

}