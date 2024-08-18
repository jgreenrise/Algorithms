package String.problems;

import java.util.*;

public class LetterCombinations_2020_06_04 {

    public static void main(String[] args) {
        LetterCombinations_2020_06_04 class1 = new LetterCombinations_2020_06_04();
        //System.out.println("$####" + class1.letterCombinations("23"));
        System.out.println("$####" + class1.letterCombinations("22"));

    }

    public List<String> letterCombinations(String digits) {

        Map<Character, List<String>> memo = new HashMap();
        List<String> out = new ArrayList();
        Map<Integer, List<String>> map = buildDictionary();
        if (digits.length() == 1) return map.get(Integer.valueOf(digits));
        else {
            return letterCombinationUsingMemo(out, memo, map, digits);
        }
    }

    // {}, {}, {map -> }, {23}
    public List<String> letterCombinationUsingMemo(List<String> out, Map<Character, List<String>> memo, Map<Integer, List<String>> map, String digits) {

        if (digits.isEmpty()) return null;

        System.out.println("$0: digits: " + digits);

        int totDigits = digits.length();                                                            // 2                        2           1
        List<String> list = new ArrayList();
        List<String> outlist = new ArrayList();
        int counter = 0;

        char firstDigit = digits.charAt(0);                                                         // 2                        3           4
        Integer key = Character.getNumericValue(firstDigit);
        System.out.println(String.valueOf(firstDigit));
        System.out.println(Arrays.asList(map));
        System.out.println(map.containsKey(key));
        List<String> combinations = map.get(key);                                                   // abc                      def         ghi
        System.out.println("$1: " + firstDigit);

        for (String str : combinations) {

            char ch = str.charAt(0);                                                                // a

            //if (memo.containsKey(ch))
            //    return memo.get(ch);

            if (1 == totDigits) {
                memo.put(ch, List.of(str));                                                         //                                      memo: {g: {g}, h: {h}, i: {i}}
                outlist.add(str);
            } else if (totDigits > 1) {                                                              // 1 < 3                    1 < 2
                if (list.isEmpty()) {
                    list = letterCombinationUsingMemo(out, memo, map, digits.substring(1));        // 1, {}, {}, {map}, {34}
                }
                System.out.println("$list: " + list);
                List<String> charList = new ArrayList();
                for (int k = 0; k < list.size(); k++) {
                    outlist.add(counter++, ch + list.get(k));
                    charList.add(k, ch + list.get(k));
                }
                System.out.println("$Out list: " + outlist);
                memo.put(ch, charList);
            }
        }
        return outlist;                                                                        //                                       {g, h, i}
    }

    public Map buildDictionary() {
        Map<Integer, List<String>> map = new HashMap();
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "n", "o"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));
        return map;
    }
}
