import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150
public class a_0150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int secondNumber = stack.pop();
                    int firstNumber = stack.pop();
                    stack.push(firstNumber - secondNumber);
                    break;
                case "/":
                    secondNumber = stack.pop();
                    firstNumber = stack.pop();
                    stack.push(firstNumber / secondNumber);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    //System.out.println("Pushed value to stack: "+token);
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }


        return Integer.valueOf(stack.pop());

    }

}
