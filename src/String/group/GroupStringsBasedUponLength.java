package String.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Given a List of any words in an ArrayList of Strings, you have to organize the 3 letters words into one list, 4 letter words into another list, etc.
Public ArrayList<ArrayList<String>> getListOfWordsGrouped(ArrayList<String> originalList)
 *
 */
public class GroupStringsBasedUponLength {

	public static void main(String[] args) {
		System.out.println(getListOfWordsGrouped(new ArrayList<String>(Arrays
				.asList("i", "at", "toy", "cell", "m", "idli", "tea", "do",
																																		"bat", "ant", "mongo", "aloha", "tank", "atolo"))));
		System.out.println(getListOfWordsGrouped(new ArrayList<String>(Arrays
				.asList("i", "a", "et2", "l22"))));
		System.out.println(getListOfWordsGrouped(new ArrayList<String>(Arrays
				.asList("i", "a", "e", "l", "om"))));
	}

	public static HashMap<Integer, ArrayList<String>> getListOfWordsGrouped(
			ArrayList<String> originalList) {

		HashMap<Integer, ArrayList<String>> response = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> list = null;

		Iterator<String> words = originalList.iterator();
		while (words.hasNext()) {

			String word = words.next();

			if (response.containsKey(Integer.valueOf(word.length()))) {
				list = response.get(Integer.valueOf(word.length()));
			} else {
				list = new ArrayList<String>();
			}

			list.add(word);
			response.put(Integer.valueOf(word.length()), list);
		}

		return response;
	}
}
