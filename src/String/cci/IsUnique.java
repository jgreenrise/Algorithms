package String.cci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static void main(String[] args) {

        String[] strs = {"", "aeppl", "apl", "abcdefghijklmnopqrstuvwxyza"};

        for(String str: strs){
            // Check if len > 26, return false
            System.out.println("1. Input Str: "+str+", Output: "+isUnique_Set(str)+", "+isUnique_sortAndCompare(str)+", "+isUnique_ascii(str));
        }

    }

    private static boolean isUnique_Set(String str) {

        if(str == null || str.isEmpty() || str.length() < 2)
            return true;

        Set<Character> set = new HashSet();
        char[] chars = str.toCharArray();

        for(char ch: chars){
            if(!set.isEmpty() && set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;

    }

    private static boolean isUnique_sortAndCompare(String str) {

        if(str == null || str.isEmpty() || str.length() < 2)
            return true;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        for(int j=1; j < chars.length; j++){
            if(chars[j] == chars[j-1]){
                return false;
            }
        }

        return true;

    }

    private static boolean isUnique_ascii(String str) {

        if(str == null || str.isEmpty() || str.length() < 2)
            return true;

        int [] ascii = new int [26];

        for(int j=0; j < str.length(); j++){
            if(ascii[str.charAt(j) - 'a'] > 0){
                return false;
            }
            ascii[str.charAt(j) - 'a']++;

        }

        return true;

    }

}
