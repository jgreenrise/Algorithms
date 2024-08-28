package Array.problems;

import java.util.HashMap;
import java.util.Map;

public class a_0013_RomanToInteger {

    public static void main(String[] args) {
        a_0013_RomanToInteger romanToInteger = new a_0013_RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
    }

    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }

    public int romanToInt(String s) {

        int n = s.length();
        int l = 0;
        int ans = values.get(s.charAt(n - 1));

        for (int j = n - 2; j >= 0; j--) {
            int right = values.get(s.charAt(j + 1));
            int left = values.get(s.charAt(j));
            if (left < right) {
                ans -= values.get(s.charAt(j));
            } else {
                ans += values.get(s.charAt(j));
            }

        }

        return ans;
    }
}
