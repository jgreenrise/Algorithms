package Array.problems.calculator;

import java.util.Stack;

public class B_BasicCalculator2_II_UsingStack {

    public static void main(String[] args) {

        B_BasicCalculator2_II_UsingStack class1 = new B_BasicCalculator2_II_UsingStack();
        String[] words = {"3+2*2", "1+1+1", "1+2*5/3+6/4*2 ", "1-1+1", " 3/2 ", "12-3/4", " 3+5 / 2 ", "42", "  30", "0-2147483647", "1*2-3/4+5*6-7*8+9/10", "10000-1*10-100*1000", "12-3/4"};


        for (String word : words) {
            System.out.println(word + " : output: " + class1.usingStack(word.toString()));
        }
    }

    public int usingStack(String s) {

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ')
                continue;

            if (Character.isDigit(ch)) {
                int start = i;
                while (Character.isDigit(ch)) {
                    i++;
                    if (i >= s.length()) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                int number = Integer.parseInt(s.substring(start, i));
                i--;

                switch (sign) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        if(number != 0)
                            stack.push(stack.pop() / number);
                        break;
                }
                number = 0;
            } else {
                sign = ch;
            }
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;

    }

}