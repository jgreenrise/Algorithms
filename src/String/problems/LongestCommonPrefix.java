package String.problems;

//https://leetcode.com/problems/longest-common-prefix/
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		//System.out.println(longestCommonPrefix.longestCommonPrefix(new String []{"flower","flow","flight"}));
		//System.out.println(longestCommonPrefix.longestCommonPrefix(new String []{"", "b"}));
		//System.out.println(longestCommonPrefix.longestCommonPrefix(new String []{"aa", "a"}));
		System.out.println(longestCommonPrefix.longestCommonPrefix(new String []{"aaa", "aa", "aaa"}));

	}

	/**
	 * Sort and then only compare first and last value
	 */
	public String longestCommonPrefix(String[] strs) {

		if(strs.length == 0)
			return "";

		// Sort
		Arrays.sort(strs);
		return commonPrefix(strs[0], strs[strs.length-1]);
	}

	public String commonPrefix(String left, String right)
	{
		if(right.isEmpty() || left.isEmpty()){
			return "";
		}

		StringBuilder sbr = new StringBuilder();
		for(int j=0; j< right.length(); j++){
			if(j < right.length() && j < left.length() && left.charAt(j) == right.charAt(j)){
				sbr.append(left.charAt(j));
			}else{
				break;
			}
		}
		return sbr.toString();
	}


	/**
	 * Sort string array, Str with max lenght is at index o
	 * Loop through all strings
	 */
	public String longestCommonPrefix2(String[] strs) {

		if(strs.length == 0)
			return "";

		// Sort
		Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());

		int minLength = strs[0].length();
		String currChar = null;
		boolean noMatchFound = false;
		StringBuilder sbr = new StringBuilder();

		for(int j=0; j< minLength; j++){
			for(int k=0; k<strs.length; k++){

				if(k == 0){
					currChar = String.valueOf((strs[k]).charAt(j));
				}else{

					if(strs[k].isEmpty()){	// "", "b"
						noMatchFound = true;
						break;
					}

					// {"aa", "a"}
					if(j < strs[k].length() && currChar.equals(String.valueOf((strs[k]).charAt(j)))){
						continue;
					}else{
						noMatchFound = true;
						break;
					}

				}
			}

			if(noMatchFound){
				break;
			}else{
				sbr.append(currChar);
			}
		}
		return sbr.toString();

	}

	/**
	 * Find length of min string, Loop through all string and compare
	 */
	public String longestCommonPrefix1(String[] strs) {

		int minLength = getMinLength(strs);
		String [] out = new String[minLength];
		String currChar = null;
		boolean noMatchFound = false;
		StringBuilder sbr = new StringBuilder();

		for(int j=0; j< minLength; j++){
			for(int k=0; k<strs.length; k++){

				if(k == 0){
					currChar = String.valueOf((strs[k]).charAt(j));
				}else{

					if(currChar.equals(String.valueOf((strs[k]).charAt(j)))){
						continue;
					}else{
						noMatchFound = true;
						break;
					}

				}
			}

			if(noMatchFound){
				break;
			}else{
				sbr.append(currChar);
			}
		}
		return sbr.toString();
	}

	public int getMinLength(String [] strs){
		int minLen = Integer.MAX_VALUE;
		for(int j = 0; j< strs.length; j++){
			if((strs[j]).length() < minLen){
				minLen = (strs[j]).length();
			}
		}
		return minLen;
	}


}
