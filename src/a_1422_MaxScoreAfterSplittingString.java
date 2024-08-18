public class a_1422_MaxScoreAfterSplittingString {

    public static void main(String[] args) {
        a_1422_MaxScoreAfterSplittingString solution = new a_1422_MaxScoreAfterSplittingString();

        // Test the maxScore method with a sample string
        String sampleString = "011101";
        int result = solution.maxScore(sampleString);

        // Print the result
        System.out.println("Max Score: " + result);
    }

    public int maxScore(String s) {

        char[] chars = s.toCharArray();
        int[] left_prefix = new int[chars.length];
        left_prefix[0] = chars[0] == '0' ? 1 : 0;
        int[] right_prefix = new int[chars.length];
        right_prefix[chars.length - 1] = chars[chars.length - 1] == '1' ? 1 : 0;
        int maxScore = 0;

        for (int j = 1; j < chars.length - 1; j++) {

            left_prefix[j] = chars[j] == '0' ? left_prefix[j - 1] + 1 : left_prefix[j - 1];

            right_prefix[chars.length - 1 - j] = chars[chars.length - 1 - j] == '1'
                    ? right_prefix[chars.length - 1 - j + 1] + 1
                    : right_prefix[chars.length - 1 - j + 1];
        }

        for (int j = 0; j < chars.length - 1; j++) {
            maxScore = Math.max(maxScore, (left_prefix[j] + right_prefix[j + 1]));
        }
        return maxScore;
    }
}
