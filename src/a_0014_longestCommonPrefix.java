// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

// Effeicnt solution using sorting
public class a_0014_longestCommonPrefix {

    public String longestCommonPrefixUsingSorting(String[] strs) {

        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        int i = 0;
        int j = strs.length - 1;

        while (i != j) {
            int minPrefixLen = 0;
            if ((strs[i]).length() > 0 && strs[i].charAt(0) == strs[j].charAt(0)) {
                minPrefixLen = 1;
                char[] leftChars = (strs[i]).toCharArray();
                char[] rightChars = (strs[j]).toCharArray();
                int k = 1;
                while (k < leftChars.length && leftChars[k] == rightChars[k]) {
                    minPrefixLen++;
                    k++;
                }
                String originalString = new String(leftChars);
                return originalString.substring(0, minPrefixLen);
            } else {
                return "";
            }
        }

        return "";

    }

    public String longestCommonPrefix(String[] strs) {

        int minPrefixLen = 0;
        int maxLen = 0;
        for (String str : strs)
            maxLen = Math.max(maxLen, str.length());
        char[] chars = new char[maxLen];

        for (int j = 0; j < strs.length; j++) {
            char[] currCharArr = strs[j].toCharArray();
            if (j == 0) {
                int counter = 0;
                for (char ch : currCharArr)
                    chars[counter++] = ch;
                minPrefixLen = currCharArr.length;
            } else {
                int currLen = 0;
                for (int k = 0; k < currCharArr.length; k++) {
                    if (currCharArr[k] == chars[k]) {
                        currLen++;
                    } else {
                        break;
                    }
                }
                minPrefixLen = Math.min(minPrefixLen, currLen);
            }
        }

        StringBuilder sbr = new StringBuilder();
        for (int j = 0; j < minPrefixLen; j++)
            sbr.append(chars[j]);

        //String originalString = new String(chars);
        //return originalString.substring(0, maxPrefixLen);

        return sbr.toString();

    }

}
