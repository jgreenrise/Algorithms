package recursive.fibonacci.a9_StringIntPermutations;

import java.util.ArrayList;
import java.util.List;

public class a_StringPermutations {

    public static void main(String[] args) {

        a_StringPermutations class1 = new a_StringPermutations();
        String[] subsets = {"ABC", "123", "AABBBBC"};

        for (String str : subsets) {
            System.out.println("Permutations: "+class1.permute(str));
        }

    }

    public List<String> permute(String str) {
        return permuteCombinations(str);
    }

    public List<String> permuteCombinations(String inputStr){

        List<String> output = new ArrayList<>();
        for(int j=0; j < inputStr.length(); j++){
            output = mergeList(String.valueOf(inputStr.charAt(j)), output);
        }

        return output;

    }

    public List<String> mergeList(String currChar, List<String> currList){

        List<String> list = new ArrayList();

        if(currList.isEmpty()){
            list.add(currChar);
            return list;
        }

        for(String item: currList){
            list.addAll(mergeString(item, currChar));
        }

        return list;

    }

    public List<String> mergeString(String item, String currChar){

        List<String> list = new ArrayList();
        StringBuilder sbr = new StringBuilder(item);

        for(int j=0; j< item.length(); j++){
            sbr = new StringBuilder(item);
            sbr.insert(j, currChar);
            list.add(sbr.toString());
        }

        sbr = new StringBuilder(item);
        sbr.insert(item.length(), currChar);
        list.add(sbr.toString());

        return list;

    }



}
