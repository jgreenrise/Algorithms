package recursive.fibonacci.a9_StringIntPermutations;

import java.util.*;

public class c_IntegerPermutationsWithDups {

    public static void main(String[] args) {

        c_IntegerPermutationsWithDups class1 = new c_IntegerPermutationsWithDups();
        int [][] subsets = {{1, 2, 3}};

        for (int [] str : subsets) {
            Map<Integer, Integer> map = class1.buildFreqTable(str);
            ArrayList<String> result = new ArrayList<>();
            List<List<Integer>> out = new ArrayList<>();
            class1.helper(map, "", getTotalChars(str), result, out);
            System.out.println("Permutations: ");
            out.forEach(System.out::println);
        }

    }

    private static int getTotalChars(int[] str) {
        int counter =0;
        for (int c : str) {
            counter++;
        }
        return counter;
    }

    public Map<Integer, Integer> buildFreqTable(int [] s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c: s) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private List<Integer> helper(Map<Integer, Integer> map, String prefix, int remaining, List<String> res, List<List<Integer>> out) {
        if (remaining == 0) {
            res.add(prefix);
            List<Integer> al = new ArrayList<>();
            for (char c: prefix.toCharArray()) {
                al.add(Integer.valueOf(String.valueOf(c)));
            }
            out.add(al);
            return al;
        }

        for (Integer c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                helper(map, prefix + c, remaining - 1, res, out);
                map.put(c, count);
            }
        }
        return null;
    }


}
