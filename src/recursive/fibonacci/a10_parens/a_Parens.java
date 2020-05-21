package recursive.fibonacci.a10_parens;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * Limitation
 * We waste a lot of time coming up with the duplicate strings.
 *
 * Look option 2
 */
public class a_Parens {

    public static void main(String[] args) {

        a_Parens class1 = new a_Parens();
        //int [] nums = {1,2,3,4,10};
        int [] nums = {4};

        for (int num : nums) {
            System.out.println("Recursive: "+class1.printAllCombinations(num));
        }

    }



    public Set<String> printAllCombinations(int num) {

        if(num == 1){
            return new HashSet<>(Arrays.asList("()"));
        }

        Set<String> set = new HashSet();
        method(set, "()", num);
        //set.forEach(System.out::println);
        return set;
    }

    public void method(Set<String> set, String s, int depth){

        if(depth == 1){
            if(set.contains(s)){
                System.out.println("Addmig dup");
            }
            set.add(s);
            return;
        }

        StringBuilder sbr = null;
        for(int j = 0; j< s.length(); j++){
            sbr = new StringBuilder(s);
            sbr.insert(j, "()");

            if(depth-1 == 1 && set.contains(sbr.toString())){
                continue;
            }

            method(set, sbr.toString(), depth-1);
        }

    }
}
