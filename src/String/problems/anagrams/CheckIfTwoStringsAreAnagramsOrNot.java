package String.problems.anagrams;

import java.util.Arrays;

public class CheckIfTwoStringsAreAnagramsOrNot {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String input = "at";
		String input2 = "ta";
		System.out.println(isAnagram_CompareAndSort(input, input2));

		input = "ab   cc   ";
		input2 = "cbac";
		System.out.println(isAnagram_CompareAndSort(input, input2));

		input = "apple";
		input2 = "APPLE";
		System.out.println(isAnagramAscii(input, input2));
	}

	public static boolean isAnagramAscii(String s, String t) {

		int [] ascii = new int [26];

		char [] chars_s = s.toCharArray();
		char [] chars_t = t.toCharArray();

		for(char ch: chars_s){
			ascii[ch - 'a'] ++;
		}

		for(char ch: chars_t){
			ascii[ch - 'a'] --;
		}

		for(int j=0; j < ascii.length; j++){
			if(ascii[j] != 0){
				return false;
			}
		}

		return true;

	}

	public static boolean isAnagram_CompareAndSort(String s, String t) {

		char [] chars = s.toCharArray();
		Arrays.sort(chars);
		System.out.println(String.valueOf(chars));

		char [] chars2 = t.toCharArray();
		Arrays.sort(chars2);
		System.out.println(String.valueOf(chars2));

		return (String.valueOf(chars)).equals(String.valueOf(chars2));

	}





}
