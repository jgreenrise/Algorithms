package String.problems;

import java.util.Arrays;

public class StringCompression1 {

    public static void main(String[] args) {
        //String input = "aabbccc";
        //String input = "abbbbbbbbbbbb";
        String input = "aaabbaaa";

        // Approach String Builder or String
        //System.out.println(usingStringBuilder(input));
        System.out.println(usingStringBuilder("abcdef"));
        System.out.println(usingStringBuilder("aabBBcccccAaa"));

        // Approach 2
        System.out.println("\n In Place" + inPlace(input.toCharArray()));

        // Approach 3: Intialized String builder
        // Not coded
        /**
         * 3.1: Find out the final string lenght
         * 3.2 Intialize String builder with (final string lenght)
         * 3.3 Append to String builder
         */

    }

    public static int inPlace(char[] chars) {

        int len = chars.length;

        if(len == 1){
            return len;
        }

        int counter = 0;
        char currChar = ' ';
        int jumpTo = 0;

        for(int j = 0; j< chars.length; j++){

            counter = 0;
            currChar = chars[j];

            for(int k = j+1; k< chars.length; k++){
                if(currChar == chars[k]){
                    chars[k] = ' ';
                    counter++;
                }else{
                    break;
                }
            }

            if(counter > 0){
                if(1+counter > 9){
                    chars[j+1] = (char)((1+counter)/10 + '0');
                    chars[j+2] = (char)((1+counter)%10 + '0');
                }else{
                    chars[j+1] = (char)(1+counter + '0');
                }

                j = (j+counter);
            }
        }

        System.out.println(Arrays.toString(chars));

        counter = 0;
        for(int j = 0; j< chars.length; j++){
            if(chars[j] != ' '){
                counter++;
            }else{
                for(int k =j+1; k <chars.length; k++){
                    chars[k-1] = chars[k];
                }
            }
        }

        return counter;

    }

    private static String usingStringBuilder(String input) {

        char tmp = input.charAt(0);
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == tmp) {
                counter++;
            } else {
                stringBuilder.append(tmp);
                stringBuilder.append(counter);

                tmp = input.charAt(i);
                counter = 1;
            }
        }

        stringBuilder.append(tmp);
        stringBuilder.append(counter);

        return stringBuilder.toString();

    }
}
