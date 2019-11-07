package String.problems;

public class StringCompression {

    public static void main(String[] args) {
        String input = "aabcccccaaa";

        // Approach String Builder or String
        System.out.println(usingStringBuilder(input));
        System.out.println(usingStringBuilder("abcdef"));
        System.out.println(usingStringBuilder("aabBBcccccAaa"));

        // Approach 2
        System.out.println("\n In Place" + inPlace(input).toString());

        // Approach 3: Intialized String builder
        // Not coded
        /**
         * 3.1: Find out the final string lenght
         * 3.2 Intialize String builder with (final string lenght)
         * 3.3 Append to String builder
         */

    }

    private static char[] inPlace(String input) {

        char[] chars = input.toCharArray();
        char tmp = input.charAt(0);
        int counter = 1;
        int index = 0;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == tmp) {
                counter++;
            } else {
                chars[index++] = tmp;
                chars[index++] = (char) (counter + '0');
                tmp = input.charAt(i);
                counter = 1;
            }
        }
        chars[index++] = tmp;
        chars[index++] = (char) (counter + '0');

        for (int i = index; i < chars.length; i++) {
            chars[index++] = 'X';
        }

        return chars;

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
