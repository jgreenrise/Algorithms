package string.problems;

/**
 * Given a word, print out all the meaningful anagrams of that word. 
For e.g. given aemt, the output would be mate, meat, meta, tame, team.
 * **/

/**
 * Output
 * Dictionary: {aemt=[tame, meat, team, mate, meta], aijnt=[jatin], aelpp=[apple], aaabnnn=[bannana]}
Does word meat exists: true
All possible combinations of word meat: [tame, meat, team, mate, meta]

 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class CheckIfStringExistsInDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<String, HashSet<String>> dictionary = buildDictionary();
		
		System.out.println("Dictionary: "+dictionary);
		
		// Check if word meat exists in dictionary
		System.out.println("Does word meat exists in dictionary: "+dictionary.containsKey(sortInput("meat")));
		
		// Print all words stored in dictionary
		System.out.println("All possible anagrams of word meat: "+dictionary.get(sortInput("meat")));

	}

	/**
	 * Building a dcitionary
	 */
	private static Hashtable<String, HashSet<String>> buildDictionary() {

		Hashtable<String, HashSet<String>> dictionary = new Hashtable<>();

		String[] str_arr_values = { "apple", "bannana", "mate", "meat", "meta",
				"tame", "team", "jatin" };
		
		String key = null;
		HashSet<String> values = null;

		for (int i = 0; i < str_arr_values.length; i++) {
			
			key = sortInput(str_arr_values[i]);
			
			if(dictionary.containsKey(key)){
				values = dictionary.get(key);
			}else{
				values = new HashSet<>();
			}
			
			values.add(str_arr_values[i]);
			
			dictionary.put(key, values);
		}

		return dictionary;
	}

	/**
	 * Sort string
	 */
	private static String sortInput(String string) {
		char[] chars = string.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
