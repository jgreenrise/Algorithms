public class a_0443_cci_1_6_StringCompression {

    public int compress(char[] chars) {

        if (chars.length == 1) return 1;

        int globalIndex = 1;
        char ch = chars[0];
        int counter = 1;

        for (int j = 1; j <= chars.length; j++) {

            if (j == chars.length) {
                if (counter == 1) {

                } else if (counter < 9) {
                    chars[globalIndex++] = (char) (counter + '0');
                } else {
                    String counter2 = String.valueOf(counter);
                    char[] newCh = counter2.toCharArray();
                    for (char ch1 : newCh)
                        chars[globalIndex++] = ch1;
                }

            } else {
                if (chars[j] == ch) {
                    counter++;
                } else {
                    if (counter == 1) {

                    } else if (counter < 9) {
                        chars[globalIndex++] = (char) (counter + '0');
                    } else {
                        // counter = 523
                        String counter2 = String.valueOf(counter);
                        char[] newCh = counter2.toCharArray();
                        for (char ch1 : newCh)
                            chars[globalIndex++] = ch1;
                    }

                    ch = chars[j];
                    chars[globalIndex++] = ch;
                    counter = 1;
                }
            }
        }

        return globalIndex;

    }
}
