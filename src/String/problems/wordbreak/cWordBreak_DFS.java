package String.problems.wordbreak;

// //https://leetcode.com/problems/longest-common-prefix/

import java.util.*;

/**
 * BRUTEFORCE with memoization
 */
public class cWordBreak_DFS {

    public static void main(String[] args) {
        cWordBreak_DFS longestCommonPrefix = new cWordBreak_DFS();
        System.out.println(longestCommonPrefix.wordBreak("leetcode", Arrays.asList("leet", "code")));
       /* System.out.println(longestCommonPrefix.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
        System.out.println(longestCommonPrefix.wordBreak("ab", Arrays.asList("a", "b")));
        System.out.println(longestCommonPrefix.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa")));*/
    }

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet=new HashSet(wordDict);
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[s.length()];
		queue.add(0);
		while (!queue.isEmpty()) {
			int start = queue.remove();
			if (visited[start] == 0) {
				for (int end = start + 1; end <= s.length(); end++) {
					if (wordDictSet.contains(s.substring(start, end))) {
						queue.add(end);
						if (end == s.length()) {
							return true;
						}
					}
				}
				visited[start] = 1;
			}
		}
		return false;
	}




}

