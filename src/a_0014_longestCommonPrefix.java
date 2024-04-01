// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
public class a_0014_longestCommonPrefix {

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
            currCharArr = null;
        }

        StringBuilder sbr = new StringBuilder();
        for (int j = 0; j < minPrefixLen; j++)
            sbr.append(String.valueOf(chars[j]));

        //String originalString = new String(chars);
        //return originalString.substring(0, maxPrefixLen);

        return sbr.toString();

    }

}
