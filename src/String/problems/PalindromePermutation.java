package String.problems;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.sort;

public class PalindromePermutation {

    public static void main(String[] args) {

        String str_input = "Tact Coa";

        System.out.println(usingHashSet(str_input));
        System.out.println(usingASCIIIntArray(str_input));
        System.out.println(usingSort(str_input));
        System.out.println(usingXOR(str_input));

        // Using HashMap not coded

        // Using XOR

    }

    private static boolean usingXOR(String str_input){

        str_input  = str_input.toUpperCase();
        char[] chars = str_input.toCharArray();

        int ascii = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ')
                continue;
            ascii = (int) chars[i] ^ ascii;
        }

        return ascii > 64 && ascii < 91;
    }

    private static boolean usingSort(String str_input) {

        str_input  = str_input.toUpperCase();
        char[] chars = str_input.toCharArray();
        sort(chars);
        int counter = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ')
                continue;

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

        str_input  = str_input.toLowerCase();
        int[] ints = new int[26];
        char[] chars = str_input.toCharArray();
        for (char c : chars) {

            if(c == ' ')
                continue;

            if (ints[c - 'a'] == 0) {
                ints[c - 'a']++;
            } else {
                ints[c- 'a']--;
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
        str_input  = str_input.toUpperCase();
        char[] chars = str_input.toCharArray();
        for (char c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                if(c != ' ')
                    set.add(c);
            }
        }
        return set.size() < 2;
    }

}
