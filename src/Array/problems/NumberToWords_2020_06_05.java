package Array.problems;

import java.util.HashMap;
import java.util.Stack;

public class NumberToWords_2020_06_05 {

    public static void main(String[] args) {
        NumberToWords_2020_06_05 romanToInteger = new NumberToWords_2020_06_05();
        //System.out.println(romanToInteger.numberToWords(20));
        //System.out.println(romanToInteger.numberToWords(100));
        //System.out.println(romanToInteger.numberToWords(1000000));
        System.out.println(romanToInteger.numberToWords(100000));
/*        System.out.println(romanToInteger.numberToWords(123));
        System.out.println(romanToInteger.numberToWords(4123));
        System.out.println(romanToInteger.numberToWords(34123));
        System.out.println(romanToInteger.numberToWords(412123));
        System.out.println(romanToInteger.numberToWords(7412123));
        System.out.println(romanToInteger.numberToWords(49412123));
        System.out.println(romanToInteger.numberToWords(849412123));
        System.out.println(romanToInteger.numberToWords(1849412123));*/
    }

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        final String[] tensNames = {
                "",
                " Ten",
                " Twenty",
                " Thirty",
                " Forty",
                " Fifty",
                " Sixty",
                " Seventy",
                " Eighty",
                " Ninety"
        };

        final String[] numNames = {
                "",
                " One",
                " Two",
                " Three",
                " Four",
                " Five",
                " Six",
                " Seven",
                " Eight",
                " Nine",
                " Ten",
                " Eleven",
                " Twelve",
                " Thirteen",
                " Fourteen",
                " Fifteen",
                " Sixteen",
                " Seventeen",
                " Eighteen",
                " Nineteen"
        };

        String[] quantities = {"", " Thousand", " Million", " Billion", "Trillion"};

        Stack<Integer> stack = new Stack();
        buildStack(num, stack);

        return recursiveBuildString(stack, quantities, numNames, tensNames);

    }

    private String recursiveBuildString(Stack<Integer> stack, String[] quantities, String[] numNames, String[] tensNames) {

        if(stack.isEmpty())
            return "";

        int size = stack.size();
        String currQuantity = quantities[size-1]; // Billion

        Integer currVal = stack.pop();
        String currStackStringVAL = getCurrentStringVal(currVal, numNames, tensNames);

        return currVal == 0 ? " " : currStackStringVAL + " " + currQuantity + " " + recursiveBuildString(stack, quantities, numNames, tensNames);

    }

    private String getCurrentStringVal(Integer currVal, String[] numNames, String[] tensNames) {

        if(currVal < 20){
            return numNames[currVal];
        }else if(currVal > 99){
            int rem = currVal / 100;
            return numNames[rem] + " Hundred " + getCurrentStringVal(currVal % 100, numNames, tensNames);
        }else{
            int rem = currVal / 10;
            return tensNames[rem] + " " +getCurrentStringVal(currVal % 10, numNames, tensNames);
        }

    }

    private void buildStack(int num, Stack<Integer> stack) {

        if(num > 999){
            int val = num % 1000;
            int rem = num / 1000;
            stack.add(val);
            buildStack(rem, stack);
        }else{
            stack.add(num);
        }
    }
}
