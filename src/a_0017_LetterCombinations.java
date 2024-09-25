import java.util.ArrayList;
import java.util.List;

public class a_0017_LetterCombinations {

    // Using For Loop
    public List<String> letterCombinations(String digits) {

        char[] charDigitis = digits.toCharArray();
        int n = digits.length();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> out = new ArrayList<>();
        if (n == 0) return List.of();

        int[] intDigits = new int[digits.length()];
        int counter = 0;
        for (char ch : charDigitis) {
            intDigits[counter++] = (int) (ch - '0');
        }
        combineForloop(0, intDigits, out, mapping, new StringBuilder());
        return out;
    }

    /**
     * 2 3 4
     * Abc def ghi
     * 0, 234, {}, mapping, ""
     * 1, 234, {}, mapping, "a"
     * 2, 234, {}, mapping, "ad"
     * 2, 234, {}, mapping, "ae"
     * 2, 234, {}, mapping, "af"
     */
    public void combineForloop(int index, int[] digits, List<String> out, String[] mapping, StringBuilder sbr) {
        if (index == digits.length) {
            out.add(sbr.toString()); // adg, adh adi, aeg..., aei
        } else {
            String mappedChars = mapping[digits[index]]; // abc def ghi
            for (char ch : mappedChars.toCharArray()) {
                sbr.insert(index, ch); // ad ae af
                combineForloop(index + 1, digits, out, mapping, sbr);
                sbr.deleteCharAt(index); // a, a
            }
        }

    }

    /**
     * Using Combine Method
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinationsUsingCombinemethod(String digits) {

        char[] charDigitis = digits.toCharArray();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> out = new ArrayList<>();

        for (char digit : charDigitis) {
            out = combine(digit, out, mapping);
        }

        return out;
    }

    // 46 - ghi, mno
    public List<String> combine(char digit, List<String> list, String[] mapping) {
        String mappedChars = mapping[(int) (digit - '0')];
        if (list.isEmpty()) {
            for (char ch : mappedChars.toCharArray()) {
                list.add(String.valueOf(ch)); // [g, h, i]
            }
            return list;
        } else {
            // mappedChars = mapping[digit]; - [mno]
            // List: [g, h, i]
            List<String> out = new ArrayList<>();
            for (char ch : mappedChars.toCharArray()) { // m n o
                for (String str : list) { // g
                    out.add(str + ch); // mg, mh, mi ng, nh, ni
                }
            }
            return out;
        }
    }

}
