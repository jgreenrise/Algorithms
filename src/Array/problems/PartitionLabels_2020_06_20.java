package Array.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels_2020_06_20 {

    public static void main(String[] args) {
        PartitionLabels_2020_06_20 class1 = new PartitionLabels_2020_06_20();

        String[] strs = {"ababcbacadefegdehijhklij", "caedbdedda"};
        for (String str : strs) {
            class1.partitionLabels(str).stream().forEach(System.out::println);
        }
    }

    public List<Integer> partitionLabels(String s) {

        int[] ascii = getAsciiValues(s);
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int lastIndex = 0;
        char ch = ' ';
        int k = 0;
        List<Integer> out = new ArrayList();

        for (int j = 0; j < chars.length; j++) {
            startIndex = j;
            ch = chars[j];
            lastIndex = ascii[(ch - 'a')];

            if (startIndex == lastIndex) {
                out.add(1);
                continue;
            }

            k = j + 1;
            while (k < chars.length && k < lastIndex) {
                if (ascii[(chars[k] - 'a')] <= lastIndex) {
                    System.out.println("Moving to next char");
                } else {
                    lastIndex = ascii[(chars[k] - 'a')];
                }
                k++;
            }
            out.add(lastIndex - startIndex + 1);
            j = k;
        }

        return out;

    }

    public int[] getAsciiValues(String s) {

        int[] out = new int[26];
        char ch = ' ';
        for (int j = 0; j < s.length(); j++) {
            ch = s.charAt(j);
            out[(ch - 'a')] = j;
        }
        return out;
    }


}
