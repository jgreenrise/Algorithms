package Array.problems;

import java.util.HashMap;

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

        String[] quantities = {"", " Thousand", " Million", " Billion"};

        String number = String.valueOf(num);
        int counter = number.length();
        StringBuilder sbr = new StringBuilder();

        if (num < 20) {
            return numNames[num].trim();
        }

        int left = 0;
        int right = number.length();
        int k = 0;    // holds quantity

        while (right > 0) {

            if (right - 3 >= 0) {

                if(sbr.length() > 1){
                    sbr.insert(0, quantities[k]);
                }

                // We have 3 chars
                String nestedNumber = number.substring(right - 3, right);

                if (Integer.valueOf(number.substring(right - 2, right)) < 20) {
                    // Less than 20
                    sbr.insert(0, numNames[Integer.valueOf(number.substring(right - 2, right))]);
                } else if (Integer.valueOf(number.substring(right - 2, right)) % 10 == 0) {
                    // Multiplier of 10
                    sbr.insert(0, tensNames[(Integer.parseInt(number.substring(right - 2, right))) / 10]);
                } else {
                    sbr.insert(0, numNames[Integer.parseInt(number.substring(right - 1, right))]);
                    sbr.insert(0, tensNames[Integer.parseInt(number.substring(right - 2, right - 1))]);
                }



                if (Integer.parseInt(number.substring(right - 3, right - 2)) != 0){
                    // 000
                    sbr.insert(0, " Hundred");
                }

                sbr.insert(0, numNames[Integer.parseInt(number.substring(right - 3, right - 2))]);


                right = right - 3;
                k++;
            } else if (right - 2 >= 0) {

                sbr.insert(0, quantities[k]);

                if (Integer.valueOf(number.substring(right - 2, right)) < 20) {
                    // Less than 20
                    sbr.insert(0, numNames[Integer.parseInt(number.substring(right - 2, right))]);
                } else if (Integer.valueOf(number.substring(right - 2, right)) % 10 == 0) {
                    // Multiplier of 10
                    sbr.insert(0, tensNames[(Integer.parseInt(number.substring(right - 2, right))) / 10]);
                } else {
                    sbr.insert(0, numNames[Integer.parseInt(number.substring(right - 1, right))]);
                    sbr.insert(0, tensNames[Integer.parseInt(number.substring(right - 2, right - 1))]);
                }


                right = right - 2;
                k++;

            } else if (right - 1 >= 0) {

                sbr.insert(0, quantities[k]);
                sbr.insert(0, numNames[Integer.parseInt(number.substring(right - 1, right))]);


                right = right - 1;
                k++;

            }

        }

        return sbr.toString().trim();

    }
}
