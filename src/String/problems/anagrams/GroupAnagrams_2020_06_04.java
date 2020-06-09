package String.problems.anagrams;

import java.util.*;

public class GroupAnagrams_2020_06_04 {

    public static void main(String[] args) {

		GroupAnagrams_2020_06_04 class1 = new GroupAnagrams_2020_06_04();

        String[][] strs = {{"eat", "tea", "tan", "ate", "nat", "bat"}};

        for (String [] str : strs) {
            System.out.println(class1.groupAnagramsUsingHashMap(str));

        }

    }

    public List<List<String>> groupAnagramsUsingHashMap(String[] strs) {

        Map<String, List<String>> map = new HashMap();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (map.containsKey(sortedWord)) {
                List<String> list = map.get(sortedWord);
                list.add(word);
                map.put(sortedWord, list);
            } else {
                List<String> list = new ArrayList();
                list.add(word);
                map.put(sortedWord, list);
            }
        }

        List<List<String>> out = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            out.add(entry.getValue());
        }

        return out;

    }

}
