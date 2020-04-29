package String.problems;

public class OneAwayCheckIfHasEdits {

    public static void main(String[] args) {
        String input1 = "pale";
        String input2 = "ple";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input1, input2, 0, input1.length() == input2.length()));

        input1 = "ple";
        input2 = "pale";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        // Input2 length > Input 1 length
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input2, input1, 0, input1.length() == input2.length()));

        input1 = "pales";
        input2 = "pale";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input2, input1, 0, input1.length() == input2.length()));

        input1 = "pale";
        input2 = "bale";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input1, input2, 0, input1.length() == input2.length()));

        input1 = "pale";
        input2 = "bake";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input1, input2, 0, input1.length() == input2.length()));

        input1 = "ppalem";
        input2 = "palem";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input1, input2, 0, input1.length() == input2.length()));

        input1 = "palem";
        input2 = "ppalem";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        // Input 2 lenght > input 1 length
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input2, input1, 0, input1.length() == input2.length()));

        input1 = "apple";
        input2 = "aple";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input1, input2, 0, input1.length() == input2.length()));

        input1 = "ab";
        input2 = "b";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEditsRecursivelyConcise(input1, input2, 0, input1.length() == input2.length()));

    }

    // Left string length >= right string length
    private static boolean hasEditsRecursivelyConcise(String left, String right, int counter, boolean isLengthEqual) {

        // Diff between length > 1
        if (Math.abs(left.length() - right.length()) > 1) return false;

        // Compare if everything is already equal
        if (isLengthEqual && left.equals(right))
            return true;

        if (left.length() == 0 && (right.length() == 1 && counter == 0))
            return true;

        if (right.length() == 0 && (left.length() == 1 && counter == 0))
            return true;

        if (left.charAt(0) == (right.charAt(0))) {

            if (isLengthEqual && left.length() == 1)
                return true;
            return hasEditsRecursivelyConcise(left.substring(1), right.substring(1), counter, left.length() == right.length());

        } else {

            counter = counter + 1;

            if (counter > 1)    // More than 1 edits is found
                return false;

            if (isLengthEqual) {
                return hasEditsRecursivelyConcise(left.substring(1), right.substring(1), counter, left.length() == right.length());
            }
            return hasEditsRecursivelyConcise(left.substring(1), right, counter, left.length() == right.length());
        }

    }

    private static boolean hasEditsRecursively(
            String left, String right, int counter, boolean isInput1BiggerThanInput2, boolean isLengthEqual) {

        // Diff between length > 1
        if (Math.abs(left.length() - right.length()) > 1) return false;

        if (isLengthEqual && left.equals(right))
            return true;

        if (left.length() == 0) {
            if (right.length() == 1 && counter == 0)
                return true;
        }

        if (right.length() == 0) {
            if (left.length() == 1 && counter == 0)
                return true;
        }

        if (left.charAt(0) == (right.charAt(0))) {

            if (isLengthEqual && left.length() == 1)
                return true;

            left = left.substring(1);
            right = right.substring(1);

            return
                    hasEditsRecursively(
                            left,
                            right,
                            counter,
                            left.length() > right.length(),
                            left.length() == right.length());
        } else {

            counter = counter + 1;

            if (counter > 1)
                // More than 1 edits is found
                return false;

            if (isLengthEqual) {

                left = left.substring(1);
                right = right.substring(1);

                return
                        hasEditsRecursively(
                                left,
                                right,
                                counter,
                                left.length() > right.length(),
                                left.length() == right.length());
            }

            if (isInput1BiggerThanInput2) {
                left = left.substring(1);
                return
                        hasEditsRecursively(
                                left,
                                right,
                                counter,
                                left.length() > right.length(),
                                left.length() == right.length());
            } else {
                right = right.substring(1);
                return
                        hasEditsRecursively(
                                left,
                                right,
                                counter,
                                left.length() > right.length(),
                                left.length() == right.length());
            }
        }

    }

    private static boolean hasEditsUsingCounter(String input1, String input2) {

        if (input1.length() >= input2.length())
            return usingCounter(input1, input2);
        return usingCounter(input2, input1);

    }

    /**
     * Left length > Right length
     */
    private static boolean usingCounter(String left, String right) {

        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int counter = 0;

        for (int i = 0; i < right.length(); i++) {

            if (leftArr[i + counter] == rightArr[i]) {
                continue;
            } else {

                counter = counter + 1;
                if (counter > 1)
                    return false;
            }

            if (i == 0 && counter == 1) {
                if (i + 1 < left.length() && i + 1 < right.length()) {
                    if (left.substring(i + 1).equals(right.substring(i + 1))) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (counter < 2)
            return true;

        return false;
    }


}
