package recursive.fibonacci.a10_parens;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Building from scratch
 *
 * Time Complexity: O(2^n).
 * For every index there can be two options ‘{‘ or ‘}’. So it can be said that the upperbound of time complexity is O(2^n) or it has exponential time complexity.
 * Space Complexity: O(n).
 * The space complexity can be reduced to O(n) if global variable or static variable is used to store the output string.
 */
public class a_Parens_UsingCounter {

    public static void main(String[] args) {

        a_Parens_UsingCounter class1 = new a_Parens_UsingCounter();
        int [] nums = {1,2,3,4,10};
        //int [] nums = {3};

        for (int num : nums) {
            System.out.println("Recursive: "+class1.printAllCombinations(num));
        }

    }

    public Set<String> printAllCombinations(int num) {

        if(num == 1){
            return new HashSet<>(Arrays.asList("()"));
        }

        Set<String> set = new HashSet();
        method(num, num, set, "");
        //set.forEach(System.out::println);
        return set;
    }

    public void method(int open, int closed, Set<String> set, String currChar){

        if(closed > open && open > 0){
            method(open-1, closed, set, currChar+"(");
            method(open, closed-1, set, currChar+")");
        }

        if(open == 0 && closed > 0){
            StringBuilder sbr = new StringBuilder(currChar);
            while(closed > 0){
                sbr.append(")");
                closed--;
            }
            set.add(sbr.toString());
        }

        if(open > 0 && closed > 0 && open == closed){
            method(open-1, closed, set, currChar+"(");
        }


    }
}
