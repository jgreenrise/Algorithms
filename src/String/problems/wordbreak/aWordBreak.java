package String.problems.wordbreak;

// //https://leetcode.com/problems/longest-common-prefix/

import java.util.*;

/**
 * BRUTEFORCE
 */
public class aWordBreak {

    public static void main(String[] args) {
        aWordBreak longestCommonPrefix = new aWordBreak();
        System.out.println(longestCommonPrefix.wordBreak("leetcode", Arrays.asList("leet", "code")));
       /* System.out.println(longestCommonPrefix.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
        System.out.println(longestCommonPrefix.wordBreak("ab", Arrays.asList("a", "b")));
        System.out.println(longestCommonPrefix.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa")));*/
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRec(s, new HashSet(wordDict), 0);
    }

	private boolean wordBreakRec(String s, Set<String> hashSet, int start) {

    	// All records have been matched
    	if(start == s.length())
    		return true;

    	for(int end = start+1; end <= s.length(); end++){

    		// 0,0 > 0,1 > 0,2 etc
    		String substr = s.substring(start,end);
    		// l, le, lee, leet && wordBreakRec(s, hashset, 4)

			// Check if substr exist in Set, if exist check if remaining key exists
    		if(hashSet.contains(substr) && wordBreakRec(s, hashSet, end)){
    			return true;
			}
		}

    	return false;

	}


}

