package Array.problems;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
        //System.out.println(romanToInteger.romanToInt("IV"));
        //System.out.println(romanToInteger.romanToInt("MCMXCIV"));
        //System.out.println(romanToInteger.romanToInt("MDCCCLXXXIV"));
        //System.out.println(romanToInteger.romanToInt("MCDLXXVI"));
    }

    public int romanToInt(String s) {

        HashMap<String, Integer> map = createRomanToIntMap();

        if(s.isEmpty())
            return 0;

        if(s.length() == 1)
            return map.get(s);

        return romanToIntRecursion(s, map);

    }

    public int romanToIntRecursion(String s, HashMap<String, Integer> map) {

        if(s.isEmpty())
            return 0;

        if(s.length() == 1)
            return map.get(s);

        if(map.containsKey(s.substring(0, 2))){
            // Subtraction Principle exists
            return map.get(s.substring(0, 2)) + romanToIntRecursion(s.substring(2), map);
        }else{
            return map.get(s.substring(0, 1)) + romanToIntRecursion(s.substring(1), map);
        }

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
