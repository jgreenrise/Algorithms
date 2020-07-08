package String.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubStringWithoutRepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestSubStringWithoutRepeatingChars longestCommonPrefix = new LongestSubStringWithoutRepeatingChars();
		//System.out.println(longestCommonPrefix.lengthOfLongestSubstring("abcadeb"));
		/*System.out.println(longestCommonPrefix.lengthOfLongestSubstring("pwwkew"));
		System.out.println(longestCommonPrefix.lengthOfLongestSubstring("   "));*/
		System.out.println(longestCommonPrefix.lengthOfLongestSubstring("jbpnbwwd"));

	}

	public int lengthOfLongestSubstring(String s) {

		if(s.isEmpty()){
			return 0;
		}

		if(s.length() == 1){
			return 1;
		}

		if(s.trim().length() == 0){
			return 1;
		}

		char []  chars = s.toCharArray();
		Set<Character> set = new HashSet();

		// Refer ASCII Limitation: Key note hints
		int [] ascii = new int[127];

		set.add(chars[0]);
		int maxLen = 1;
		ascii[chars[0]] = 0;

		int left =0;


		for(int j=1; j<chars.length; j++){
			char ch = chars[j];

			if(set.contains(ch)){
				maxLen = Math.max(maxLen, set.size());

				for (int k=left; k <= ascii[ch]; k++){
					set.remove(chars[k]);
				}

				left = ascii[ch] + 1;
			}
			set.add(ch);
			ascii[ch] = j;
		}

		return Math.max(maxLen, set.size());
	}


}
