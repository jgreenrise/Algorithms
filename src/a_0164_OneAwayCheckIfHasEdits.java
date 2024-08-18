public class a_0164_OneAwayCheckIfHasEdits {

    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t))    return false; // They are exactly the same, not one edit away

        int m = s.length();
        int n = t.length();

        // Ensure s is always the shorter or equal length string
        if (m > n) {
            return isOneEditDistance(t, s); // Swap to ensure s is shorter or equal
        }

        // Now we know m <= n
        if (n - m > 1)
            return false; // More than one character difference, not one edit away

        int i = 0;
        int j = 0;
        boolean foundDifference = false;

        while (i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                if (foundDifference) {
                    return false; // Already found one difference, not one edit away
                }
                foundDifference = true;

                if (m == n) {
                    i++; // Move pointer in case of substitution
                }
            } else {
                i++; // Move both pointers if characters are the same
            }
            j++;
        }

        return foundDifference || n - m == 1;
    }


}
