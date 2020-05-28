package String.problems;

import java.util.HashSet;

public class LongestPalindromeString {

    public static void main(String[] args) {

        LongestPalindromeString class1 = new LongestPalindromeString();

        //String arr_str_input[] = {"babaddtattarrattatddetartrateedredividerb"};
        //String arr_str_input[] = {"babbbad"};
        String arr_str_input[] = {"aabbcbb"};
        //String arr_str_input[] = {"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"};
       // String arr_str_input[] = {"babad", "cbbd", "cdefaba", "aaabadd", "a", "abcda"};

        for (String input : arr_str_input) {
            //System.out.println("Bruteforce: " + class1.bruteforce(input));
            System.out.println("Longest palindrome: " + class1.longestPalindrome(input));
        }

    }

    public String longestPalindrome(String s) {

        if (s.isEmpty() || s.length() < 1) return "";

        int start = 0;
        int end = 0;
        int lengthOfCurrentPalindrome = 0;

        for (int j = 0; j < s.length(); j++) {
            /**
             * Expand from center (racecar)
             * len1: Length of palindrome
             */
            int len1 = expandAroundCenter(s, j, j);

            /**
             * Expand from center, center+1 (aabbaa)
             * len2: Length of palindrome
             */
            int len2 = expandAroundCenter(s, j, j + 1);

            // Length of current palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = j - (len - 1) / 2;
                end = j + len / 2;
            }


        }

        return s.substring(start, end + 1);

    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    /**
     * isPalindrome : O(n)
     * substring: 0(n)
     * Since we do substring till n-1 : TC : O(n2)
     * <p>
     * For n length string > doing substring n times on it: (O(n2))
     * Total Tc: (o(n2) * isPalindrom Check O(n) = O(n3)
     * <p>
     * SC: O(n2) > Save values in set
     */
    public String bruteforce(String s) {
        if (s.isEmpty()) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (isPalindrome(s)) {
                return s;
            }
            return String.valueOf(s.charAt(0));
        }

        HashSet<String> set = new HashSet();
        String output = foundLonggestPalindrome(s, set, null);
        return output == null ? String.valueOf(s.charAt(0)) : output;
    }

    public String foundLonggestPalindrome(String s, HashSet set, String out) {

        if (set.contains(s))
            return out;

        set.add(s);

        if (s.isEmpty() || s.length() < 2) {
            return out;
        }

        if (out != null && s.length() <= out.length()) {
            // Palindrome string is already found of length
            // If s.length > out, then look out for palindrome.
            return out;
        }

        if (isPalindrome(s)) {
            if (out == null) {
                return s;
            } else if (out.length() < s.length()) {
                return s;
            }
            return out;
        }

        out = foundLonggestPalindrome(s.substring(1), set, out);
        out = foundLonggestPalindrome(s.substring(0, s.length() - 1), set, out);

        return out;


    }

    public boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(rev);
    }
}
