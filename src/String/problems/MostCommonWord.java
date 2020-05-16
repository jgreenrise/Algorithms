package String.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.sort;

/**
 * https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {

    public static void main(String[] args) {

        String str_input = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        str_input = "a, a, a, a, b,b,b,c, c";
        banned = new String[]{"a"};

        System.out.println(mostCommonWord(str_input, banned));

        str_input = "a.";
        banned = new String[]{""};

        System.out.println(mostCommonWord(str_input, banned));

        // Using HashMap not coded

        // Using XOR

    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        String[] words = paragraph.split("\\W");
        Map<String, Integer> map = new HashMap();
        Set<String> set = new HashSet();
        int count = 0;
        int maxCount = 0;
        String frequentWord = null;
        boolean matchFound = false;

        for (int j = 0; j < words.length; j++) {
            words[j] = removeSymbols(words[j]);
        }

        for (int j = 0; j < banned.length; j++) {
            set.add(banned[j]);
        }

        for (int j = 0; j < words.length; j++) {

            if (words[j].length() == 0) {
                continue;
            }

            if (map.containsKey(words[j])) {
                count = map.get(words[j]);
                map.put(words[j], count + 1);
            } else {
                map.put(words[j], 1);
            }


        }

        for (Map.Entry<String, Integer> record : map.entrySet()) {

            if (banned.length > 0) {
                if (!set.isEmpty() && !set.contains(record.getKey())) {
                    if (maxCount < record.getValue()) {
                        maxCount = record.getValue();
                        frequentWord = record.getKey();
                    }
                }
            } else {
                if (maxCount < record.getValue()) {
                    maxCount = record.getValue();
                    frequentWord = record.getKey();
                }
            }

        }

        return frequentWord;

    }

    public static String removeSymbols(String s) {

        if (s.length() == 0) {
            return s;
        }

        if (!Character.isLetter(s.charAt(0))) {
            s = s.replace(String.valueOf(s.charAt(0)), "");
        }

        if (s.length() > 1 && !Character.isLetter(s.charAt(s.length() - 1))) {
            s = s.replace(String.valueOf(s.charAt(s.length() - 1)), "");
        }

        return s.toLowerCase();
    }

}

