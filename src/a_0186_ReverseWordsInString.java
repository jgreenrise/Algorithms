import java.util.Arrays;

public class a_0186_ReverseWordsInString {

    public void reverseWords(char[] s) {

        for (int k = 0; k < s.length / 2; k++) {
            char tmp = s[k];
            s[k] = s[s.length - 1 - k];
            s[s.length - 1 - k] = tmp;
        }

        System.out.println("Before transformation: " + Arrays.toString(s));

        int k = 0;
        while (k < s.length) {
            int left = k;
            int right = k;
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            s = swap(left, right, s);
            left = right++;
            k = right;
        }

        System.out.println(Arrays.toString(s));
    }

    public char[] swap(int left, int right, char[] s) {
        for (int k = left; (k < (left + right) / 2 && k < s.length); k++) {
            char tmp = s[k];
            s[k] = s[left + right - 1 - k];
            s[left + right - 1 - k] = tmp;
        }
        return s;
    }

}
