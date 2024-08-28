import java.util.ArrayList;
import java.util.List;

public class a_0017_LetterCombinations {

    // This method generates all possible letter combinations for the given digit string
    public List<String> letterCombinations(String digits) {

        // If the input is empty or contains only whitespace, return an empty list
        if ((digits.trim()).length() == 0) {
            return List.of();
        }

        // Mapping of digits to corresponding letters on a phone keypad
        String digitletter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> out = new ArrayList<>();
        StringBuilder sbr = new StringBuilder();

        // Start generating combinations from index 0
        generateCombinations(0, digits, digitletter, out, sbr);
        return out;
    }

    // Recursive helper method to generate letter combinations
    public void generateCombinations(int idx, String digits, String[] digitletter, List<String> list, StringBuilder sbr) {

        // If we've reached the end of the input digits, add the current combination to the list
        if (idx == digits.length()) {
            list.add(sbr.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String alphabets = digitletter[digits.charAt(idx) - '0'];

        // Loop through each letter and recursively generate combinations for the next digit
        for (int k = 0; k < alphabets.length(); k++) {
            sbr.append(alphabets.charAt(k)); // Add letter to the current combination
            generateCombinations(idx + 1, digits, digitletter, list, sbr); // Recur for the next digit
            sbr.deleteCharAt(sbr.length() - 1); // Remove last letter to backtrack
        }
    }

    // This method generates all possible letter combinations for the given digit string without recursion
    public List<String> letterCombinationsNoRecursive(String digits) {

        // If the input is empty or contains only whitespace, return an empty list
        if ((digits.trim()).length() == 0) {
            return List.of();
        }

        // Mapping of digits to corresponding letters on a phone keypad
        String digitletter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> out = new ArrayList<>();

        // Iterate through each digit and combine with current results
        for (int j = 0; j < digits.length(); j++)
            out = combine(digitletter[digits.charAt(j) - '0'], out);

        return out;
    }

    // Helper method to combine existing results with new letters
    public List<String> combine(String alphabets, List<String> out) {

        List<String> result = new ArrayList<>();

        // If out is empty, initialize result with single-letter combinations
        if (out.isEmpty()) {
            for (int k = 0; k < alphabets.length(); k++)
                result.add(String.valueOf(alphabets.charAt(k)));
            return result;
        }

        // Combine each letter with each existing result
        for (int k = 0; k < alphabets.length(); k++) {
            for (String x : out) {
                result.add(x + alphabets.charAt(k));
            }
        }

        return result;
    }

}
