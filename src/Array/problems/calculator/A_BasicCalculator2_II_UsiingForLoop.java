package Array.problems.calculator;

// Throws Timeout exception

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Runs for all the input, except extremly lareg input
 */
public class A_BasicCalculator2_II_UsiingForLoop {

    public static void main(String[] args) {

        A_BasicCalculator2_II_UsiingForLoop class1 = new A_BasicCalculator2_II_UsiingForLoop();
        //String[] words = {"3+2*2", "1+1+1", "1+2*5/3+6/4*2 ", "1-1+1", " 3/2 ", "12-3/4", " 3+5 / 2 ", "42", "  30", "0-2147483647", "1*2-3/4+5*6-7*8+9/10", "10000-1*10-100*1000", "12-3/4"};

        String out = null;
        try {
            File myObj = new File("/Users/JatinPatel/Documents/code/Algorithms/src/Array/problems/calculator/filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                out = myReader.nextLine();
                //System.out.println(out);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] words = {out};

        for (String word : words) {
            System.out.println(word + " : output: " + class1.calculate(word));
        }
    }

    public int calculate(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        s = getStringWithoutSpace(s)+ " ";

        char prevOp = '+';
        int num = 0;
        int sum = 0;
        int prev = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                //123
                num = num*10 + ch - '0';
            }else{
                switch (prevOp){
                    case '+':
                        sum = sum + prev;
                        prev = num;
                        break;
                    case '-':
                        sum = sum + prev;
                        prev = -num;
                        break;
                    case '*':
                        prev = prev * num;
                        break;
                    case '/':
                        prev = prev / num;
                        break;
                }
                num = 0;
                prevOp = ch;
            }
        }
        return prev + sum;
    }

    public String getStringWithoutSpace(String s) {

        StringBuilder sbr = new StringBuilder();
        for (int j = 0; j < s.toCharArray().length; j++) {
            if (s.charAt(j) == ' ') {
                continue;
            }
            sbr.append(s.charAt(j));
        }

        return sbr.toString();

    }

}
