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
        System.out.println(romanToInteger.romanToIntRightToLeft("MMCDXXV"));
    }

    public int romanToInt(String s) {

        String[] nums = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        int ans = 0;
        for(int i = 0, j = 0, n = s.length(); j < n;){
            if (s.startsWith(nums[i],j)){
                ans += val[i];
                j += nums[i].length();
            } else {
                ++i;
            }
        }
        return ans;
    }

    public int romanToIntRightToLeft(String s) {

        HashMap<String, Integer> map = createRomanToIntMap();
        int intVal = 0;
        String subStr = null;
        int currVal = 0;
        boolean invalidMatchFound = false;

        if(s.length() == 1){
            return map.get(s);
        }

        for(int j = 0; j < s.length(); j++){

            if(j+1 < s.length()){
                subStr = s.substring(j, j+2);

                if(map.containsKey(subStr)){
                    currVal = map.get(subStr);

                    if(j != 0 && currVal > intVal){
                        invalidMatchFound = true;
                        break;
                    }else{
                        intVal += currVal;
                        j++;
                    }
                }else{
                    intVal += map.get(String.valueOf(s.charAt(j)));
                }
            }else{
                intVal += map.get(String.valueOf(s.charAt(j)));
            }

        }

        if(invalidMatchFound){
            return -1;
        }
        return intVal;

    }

    public boolean doesCorrectOrderExist(int left, int right, String s, HashMap map){

        if((int)(map.get(String.valueOf(s.charAt(left)))) >= (int)(map.get(String.valueOf(s.charAt(right))))){
            return true;
        }

        return false;

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
