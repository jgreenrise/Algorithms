package String.problems;

import java.util.Arrays;

// https://leetcode.com/problems/verifying-an-alien-dictionary/
public class AlienDictionary {

    public static void main(String[] args) {
        String input = "aaabbaaa";

        String [] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println("\n alien dictionary : Sorted order is " + isAlienSorted(words, order));

        words = new String[]{"word", "world", "row"};
        order = "worldabcefghijkmnpqstuvxyz";

        System.out.println("\n alien dictionary : Sorted order is " + isAlienSorted(words, order));

        words = new String[]{"apple","app"};
        order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("\n alien dictionary : Sorted order is " + isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {

        if(words.length == 1){
            return true;
        }

        int [] dictionary = new int[26];
        char [] orders = order.toCharArray();

        for(int j = 0; j< orders.length; j++){
            dictionary[(int)(orders[j]) - 97] =  j;
        }

        // Compare 2nd and 1st word
        // Compare 3rd and 2nd word ...
        for(int j = 1; j< words.length; j++){
            if(!isSorted(words[j-1], words[j-1].length(), words[j], words[j].length(), dictionary))
                return false;
        }

        return true;

    }

    public static boolean isSorted(String left, int m, String right, int n, int [] dictionary){

        int asciiLeft = ((int)(left.charAt(0))) - 97;
        int asciiRight = ((int)(right.charAt(0))) - 97;

        if(dictionary[asciiRight] > dictionary[asciiLeft]){
            // e.g hello, late
            return true;
        }else if(dictionary[asciiRight] < dictionary[asciiLeft]){
            // e.g ban, app
            return false;
        }else{
            // hello, hell
            // Both chars are Equal
            if(m == 1 && n > 1){
                // left: Has no chars, Right: has chars. for.e.g: h, he
                return true;
            }
            else if(n == 1 && m > 1){
                // left: Has chars, Right: Has no chars. for e.g: he, h
                return false;
            }
            return isSorted(left.substring(1), m-1, right.substring(1), n-1, dictionary);
        }

    }
}
