package String.problems;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.sort;

public class PalindromePermutation {

    public static void main(String[] args) {

        String str_input = "RACECAR";

        System.out.println(usingHashSet(str_input));
        System.out.println(usingASCIIIntArray(str_input));
        System.out.println(usingSort(str_input));

        // Using HashMap not coded

        // Using XOR

    }

    private static boolean usingSort(String str_input) {

        char[] chars = str_input.toCharArray();
        sort(chars);
        int counter = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
                continue;
            } else {
                counter++;
            }
        }
        return counter > 1 ? false : true;
    }

    private static boolean usingASCIIIntArray(String str_input) {

        int[] ints = new int[128];
        char[] chars = str_input.toCharArray();
        for (char c : chars) {

            if (ints[c] == 0) {
                ints[c]++;
            } else {
                ints[c]--;
            }

        }

        int counter = 0;
        for (int i = 0; i < ints.length; i++) {

            if (ints[i] > 0) {
                counter++;
            }
        }

        return counter > 1 ? false : true;
    }

    private static boolean usingHashSet(String str_input) {
        Set set = new HashSet();
        char[] chars = str_input.toCharArray();
        for (char c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() < 2;
    }

}
