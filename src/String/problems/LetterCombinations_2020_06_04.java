package String.problems;

import java.util.*;

public class LetterCombinations_2020_06_04 {

    public static void main(String[] args) {
        LetterCombinations_2020_06_04 class1 = new LetterCombinations_2020_06_04();
        System.out.println(class1.letterCombinations("23"));

    }

    public List<String> letterCombinations(String digits) {

        HashMap<Integer, List<String>> map = new HashMap();
        map.put(2, new LinkedList<String>(Arrays.asList("a", "b", "c")));
        map.put(3, new LinkedList<String>(Arrays.asList("d","e","f")));
        map.put(4, new LinkedList<String>(Arrays.asList("g","h","i")));
        map.put(5, new LinkedList<String>(Arrays.asList("j","k","l")));
        map.put(6, new LinkedList<String>(Arrays.asList("m","n","o")));
        map.put(7, new LinkedList<String>(Arrays.asList("p","q","r","s")));
        map.put(8, new LinkedList<String>(Arrays.asList("t","u","v")));
        map.put(9, new LinkedList<String>(Arrays.asList("w","x","y","z")));

        List<String> out = new ArrayList();

        for(char digit: digits.toCharArray()){
            List<String> tmp = new ArrayList();

            List<String> currAlphabets = map.get((int)(digit - '0'));

            if(out.size() == 0){
                out = currAlphabets;
                continue;
            }else{
                for(int j=0; j< currAlphabets.size(); j++){
                    for(String prevChars: out){
                        tmp.add(prevChars+String.valueOf(currAlphabets.get(j)));
                    }
                }
            }

            out = tmp;

        }

        return out;

    }
}
