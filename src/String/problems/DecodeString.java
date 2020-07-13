package String.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {

    public static void main(String[] args) {

        DecodeString class1 = new DecodeString();
        //System.out.println(class1.decodeString("2[abc]3[cd]ef"));
        System.out.println(class1.decodeString("1[a3[b2[c]]e]f"));
        System.out.println(class1.decodeString("3[a]2[bc]"));
        System.out.println(class1.decodeString("3[a2[c]]"));
        System.out.println(class1.decodeString("100[leetcode]"));

    }

    public String decodeString(String s) {

        Stack<Integer> nums = new Stack();
        Stack<String> chars = new Stack();
        StringBuilder resp = new StringBuilder();
        StringBuilder nestedString = new StringBuilder();

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            if (Character.isDigit(ch)) {
                nums.push(ch - '0');
            } else if (ch == ']') {

                StringBuilder tmpString = new StringBuilder();
                while (chars.peek() != "[") {
                    tmpString.append(chars.pop());
                }
                chars.pop();
                tmpString = tmpString.reverse();

                if (nestedString.length() > 0)
                    tmpString = tmpString.append(nestedString);

                nestedString = new StringBuilder();
                int counter = nums.pop();
                for (int k = 0; k < counter; k++) {
                    if (nestedString.length() == 0) {
                        nestedString.append(tmpString);
                    } else {
                        nestedString.insert(0, tmpString);
                    }
                }

                chars.push(nestedString.toString());

                if (chars.isEmpty()) {
                    resp.append(nestedString);
                }

            } else {
                chars.push(String.valueOf(ch));
            }
        }

        if (!chars.isEmpty()) {
            StringBuilder tmpString = new StringBuilder();
            while (!chars.isEmpty()) {
                tmpString.append(chars.pop());
            }
            tmpString = tmpString.reverse();
            resp.append(tmpString);
        }

        return resp.toString();

    }

    public String decodeStringUsingPointer(String s) {

        char[] chars = s.toCharArray();
        StringBuilder sbr = new StringBuilder();
        int count = -1;
        int rightIndex = 0;

        for (int j = 0; j < chars.length; j++) {

            char ch = chars[j];
            String nestedString = "";

            if (Character.isDigit(ch)) {
                if (count == -1) {
                    count = ch - '0';
                } else {
                    count = count * 10 + ch - '0';
                }
            } else if (ch == '[') {
                rightIndex = getRightIndex(j + 1, chars);

                if (s.indexOf('[', j + 1) == -1 || s.indexOf('[', j + 1) >= rightIndex) {
                    nestedString = s.substring(j + 1, rightIndex);
                } else {
                    nestedString = decodeString(s.substring(j + 1, rightIndex));
                }

                for (int k = 0; k < count; k++) {
                    sbr.append(nestedString);
                }
                count = -1;

                j = rightIndex;        // Jump to right index
            } else {
                sbr.append(ch);
            }

        }

        return sbr.toString();

    }

    public int getRightIndex(int index, char[] chars) {

        int counter = 0;
        for (int j = index; j < chars.length; j++) {
            char ch = chars[j];

            if (ch == '[') {
                counter++;
            } else if (ch == ']') {
                counter--;
            }

            if (counter < 0) {
                return j;
            }
        }
        return index;
    }


}
