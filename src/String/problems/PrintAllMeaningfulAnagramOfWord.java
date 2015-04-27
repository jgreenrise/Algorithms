package String.problems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class PrintAllMeaningfulAnagramOfWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<String, HashSet<String>> dictionary = buildDictionary();

	}

	/**
	 * Building a dcitionary
	 */
	private static Hashtable<String, HashSet<String>> buildDictionary() {

		Hashtable<String, HashSet<String>> dictionary = null;

		String[] str_arr_values = { "apple", "bannana", "mate", "meat", "meta",
				"tame", "team", "jatin" };
		
		String key = null;

		for (int i = 0; i < str_arr_values.length; i++) {
			key = sortInput(str_arr_values[i]);
			
			if(){
				
			}
			
			
		}

		return dictionary;
	}

	/**
	 * Sort string
	 */
	private static String sortInput(String string) {
		char [] chars = string.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
