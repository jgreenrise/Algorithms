import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/?envType=study-plan-v2&envId=top-interview-150
public class a_0022_GenerateParanthesis {

    public List<String> generateParenthesis(int n) {

        List<String> out = new ArrayList<>();
        add("", 0, 0, out, n);
        return out;
    }

    /**
     * add("(", true, 1, 0, out, isVisited, n);
     */

    public void add(String currStr, int left, int right, List<String> out, int n) {

        // System.out.println("Curr str: " + currStr + ", TOTALlEFT: " + totalLeft + ",
        // RIGHT: " + totalRight + ", OUT: " +out.size());

        if (left > n || right > n)
            return;

        if (currStr.length() == 2 * n) {
            if (left == right) {
                out.add(currStr);
            }
            return;
        }

        // Add an opening parenthesis if it doesn't exceed the limit
        if (left < n)
            add(currStr + "(", left + 1, right, out, n);

        if (right < left)
            add(currStr + ")", left, right + 1, out, n);

        // ())(( - should we add )


    }


}
