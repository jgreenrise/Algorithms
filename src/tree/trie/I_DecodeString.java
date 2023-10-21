package tree.trie;

import java.util.*;

/**
 *
 */
class I_DecodeString {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        String  [] strs = {"abc3[cd]xyz", "3[a]2[bc]", "2[abc]3[cd]ef", "3[a2[c]]"};
        //String  [] strs = {"3[a2[c]]"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println("String "+strs[i]+", Decoded string: "+decodeString(strs[i]));
        }
    }

    // 3[a]2[bc]
    public static String decodeString(String s){

        Stack<Integer> stackCount = new Stack<>();
        Stack<StringBuilder> stackChars = new Stack<>();
        StringBuilder out = new StringBuilder();
        char [] chars = s.toCharArray();
        int k = 0;
        StringBuilder currStr = new StringBuilder();

        for(int j = 0; j < chars.length; j++){

            char ch = chars[j];

            if(Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            }else{
                if(ch == ']'){

                    int count = stackCount.pop();
                    boolean shouldAppend = false;

                    if(currStr.length() == 0) {
                        currStr = stackChars.pop();
                        shouldAppend = true;
                    }

                    for(int l=0; l < count; l++){
                        if(shouldAppend)
                            out.insert(0, currStr);
                        else
                            out.append(currStr);
                    }

                    // Create String
                    currStr = new StringBuilder();

                }else if(ch == '['){

                    // Save count
                    stackCount.push(k);
                    k = 0;

                    // Save string
                    stackChars.push(currStr);

                    currStr = new StringBuilder();

                }else{

                    if(stackCount.isEmpty()){
                        // Helps when string starts with character
                        out.append(ch);
                    }else{
                        currStr.append(ch);
                    }
                }
            }
        }

        return out.toString();
    }

}


