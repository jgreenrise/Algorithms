package Array.problems;

import java.util.HashMap;

public class RomanToIntegerEmpty {

    public static void main(String[] args) {
        RomanToIntegerEmpty romanToInteger = new RomanToIntegerEmpty();
        //System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("IV"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
        System.out.println(romanToInteger.romanToInt("MDCCCLXXXIV"));
        System.out.println(romanToInteger.romanToInt("MCDLXXVI"));
    }

    public int romanToInt(String s) {
        return 0;
    }

    public HashMap<String, Integer> createRomanToIntMap(){

        HashMap<String, Integer> map = new HashMap();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        return map;

    }
}
