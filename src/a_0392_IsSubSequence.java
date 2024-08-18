import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a_0392_IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        return isSubsequence(s, t, 0, 0);
    }

    public boolean isSubsequence(String s, String t, int lIdx, int rIdx) {

        if (lIdx >= s.length()) return true;
        if (rIdx >= t.length()) return false;

        if (s.charAt(lIdx) == t.charAt(rIdx)) {
            return isSubsequence(s, t, lIdx + 1, rIdx + 1);
        } else {
            return isSubsequence(s, t, lIdx, rIdx + 1);
        }
    }

    public boolean isSubsequencev2(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }

    public boolean isSubsequencev3(String s, String t) {

        // precomputation, build the hashmap out of the target string
        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            if (letterIndicesTable.containsKey(t.charAt(i)))
                letterIndicesTable.get(t.charAt(i)).add(i);
            else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i), indices);
            }
        }

        Integer currMatchIndex = -1;
        for (char letter : s.toCharArray()) {
            if (!letterIndicesTable.containsKey(letter))
                return false; // no match, early exit

            boolean isMatched = false;
            // greedy match with linear search
            for (Integer matchIndex : letterIndicesTable.get(letter)) {
                if (currMatchIndex < matchIndex) {
                    currMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched)
                return false;
        }

        // consume all characters in the source string
        return true;
    }
}
