package Array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class NthMostFrequentNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] i_arr_input = { 3, 5, 4, 1, 4, 5, 5, 6, 7 };
		int[] i_arr_input = { 3, 5, 4, 1, 4, 5, 5, 6, 7, -1, -1};

		System.out.println("Before sorting: " + Arrays.toString(i_arr_input));
		Arrays.sort(i_arr_input);
		System.out.println("After sorting: " + Arrays.toString(i_arr_input));

		// 1st Most famous
		System.out.println();
		retrieveNthMostFrequentNumber(i_arr_input, 1);

		// 2nd Most famous
		System.out.println();
		retrieveNthMostFrequentNumber(i_arr_input, 2);
		
		// 3rd Most famous
		System.out.println();
		retrieveNthMostFrequentNumber(i_arr_input, 3);

	}

	/**
	 * Approach 1: Using tree map
	 * O(n): Insert into hashmap
	 * O(lgn): Insert into treeMap
	 * O(lgn): Search from tree map
	 */
	private static void retrieveNthMostFrequentNumber(int[] i_arr_input, int frequency) {

		HashMap<Integer, Integer> map = new HashMap<>();
		TreeMap<Integer, LinkedList<Integer>> pairs = null;
		LinkedList<Integer> pair = null;

		for (int i : i_arr_input) {
			Integer count = map.get(i);
			map.put(i, count != null ? count + 1 : 1);
		} 

		// Add values to tree map
		pairs = new TreeMap<>();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry map_pair = (Map.Entry) it.next();
			
			if(pairs.containsKey(map_pair.getValue())){
				pair = pairs.get(map_pair.getValue());
			}else{
				pair = new LinkedList<Integer>();
			}

			pair.add(Integer.parseInt(map_pair.getKey().toString()));
			pairs.put(Integer.parseInt(map_pair.getValue().toString()), pair);
		}
		
		System.out.println("Most famous number: "+pairs.get(pairs.size()));
		System.out.println(frequency+" famous numbers: "+pairs.get(pairs.size()-(frequency-1)));
		
	}

}
