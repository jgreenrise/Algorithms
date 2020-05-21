package recursive.fibonacci.a9_StringIntPermutations;

import java.util.*;

public class b_StringPermutationsWithDups {

    public static void main(String[] args) {

        b_StringPermutationsWithDups class1 = new b_StringPermutationsWithDups();
        String[] subsets = {"ABCC", "1233", "DDEEEEFFF", "aaaaaaaaaaaaaaa"};

        for (String str : subsets) {
            Map<Character, Integer> map = class1.buildFreqTable(str);
            ArrayList<String> result = new ArrayList<>();
            class1.helper(map, "", str.length(), result);
            System.out.println("Permutations: ");
            result.forEach(System.out::println);
        }

    }

    public Map<Character, Integer> buildFreqTable(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private void helper(Map<Character, Integer> map, String prefix, int remaining, List<String> res) {
        if (remaining == 0) {
            res.add(prefix);
            return;
        }
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                helper(map, prefix + c, remaining - 1, res);
                map.put(c, count);
            }
        }
    }


}
