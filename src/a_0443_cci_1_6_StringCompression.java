import java.util.Arrays;

public class a_0443_cci_1_6_StringCompression {

    private char[] numChars;

    public static void main(String[] args) {
        //String input = "aabbccc";
        String input = "abbbbbbbbbbbb";
        //String input = "aaabbaaa";

        // Approach String Builder or String
        //System.out.println(usingStringBuilder(input));
        System.out.println(usingStringBuilder("abcdef"));
        System.out.println(usingStringBuilder("aabBBcccccAaa"));

        // Approach 2
        //System.out.println("\n In Place" + inPlace(input.toCharArray()));

        // Approach 3: Initialized String builder
        // Not coded
        /**
         * 3.1: Find out the final string length
         * 3.2 Intialize String builder with (final string lenght)
         * 3.3 Append to String builder
         */

        // Approach 4
        System.out.println("\n In Place" + compress(input.toCharArray()));

    }

    public static int compress(char[] chars) {

        if(chars.length == 1) return 1;

        int globalIndex = 1;
        char ch = chars[0];
        int counter = 1;
        //System.out.println("input char length: "+chars.length+"\t Chars: "+Arrays.toString(chars));

        for(int j = 1; j <= chars.length; j++){

            if(j == chars.length){
                if(counter == 1){

                }else if(counter < 9){
                    chars[globalIndex++] = (char)(counter + '0');
                }else{
                    String counter2 = String.valueOf(counter);
                    char [] newCh = counter2.toCharArray();
                    for(char ch1: newCh)
                        chars[globalIndex++] = ch1;
                }

            }else{
                if(chars[j] == ch){
                    counter++;
                }else{
                    if(counter == 1){

                    }else if(counter < 9){
                        chars[globalIndex++] = (char)(counter + '0') ;
                    }else{
                        // counter = 523
                        String counter2 = String.valueOf(counter);
                        char [] newCh = counter2.toCharArray();
                        for(char ch1: newCh)
                            chars[globalIndex++] = ch1;

                    }

                    ch = chars[j];
                    chars[globalIndex++] = ch ;
                    counter = 1;
                }
            }
        }

        //System.out.println("charss: "+Arrays.toString(chars));
        return globalIndex;

    }

    public static int compressUsingWhileLoop(char[] chars) {

        if (chars == null || chars.length == 0)
            return 0;

        if(chars.length == 1)
            return 1;

        int i = 0; // Current Index
        int n = chars.length;
        int currIndex = 0;

        while(i < n){


            // Get frequency
            int frequency = 0;
            int left_index = i;
            int right_index = i+1;
            char currCh = chars[i];
            while(right_index < n && chars[right_index] == currCh ){
                right_index++;
                i++;
            }
            frequency = right_index - left_index;

            // Add in place
            chars[currIndex++] = currCh;
            if(frequency == 1){
                // Dont do anything
                i++;
            }else if(frequency < 10){
                System.out.println("Cuu Index: "+currIndex+", frequency: "+frequency+", "+Arrays.toString(chars));
                chars[currIndex++] = (char)(frequency + '0');
                i++;
            }else{

                char [] numChars = (String.valueOf(frequency)).toCharArray();
                for(int j=0; j < numChars.length; j++){
                    chars[currIndex++] = numChars[j];
                    i++;
                }

            }

        }

        System.out.println(chars);
        return currIndex;
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
