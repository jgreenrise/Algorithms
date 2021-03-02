package String.problems;

public class OneAwayCheckIfHasEdits {

    public static void main(String[] args) {
        String input1 = "pale";
        String input2 = "ple";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input1, input2));

        input1 = "ple";
        input2 = "pale";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input2, input1));

        input1 = "pales";
        input2 = "pale";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input2, input1));

        input1 = "pale";
        input2 = "bale";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input1, input2));

        input1 = "pale";
        input2 = "bake";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input1, input2));

        input1 = "ppalem";
        input2 = "palem";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input1, input2));

        input1 = "palem";
        input2 = "ppalem";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));

        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input2, input1));

        input1 = "apple";
        input2 = "aple";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input1, input2));

        input1 = "ab";
        input2 = "b";
        System.out.println("\n" + input1 + " : " + input2 + " = " + hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 *: " + input1 + " : " + input2 + " = " + hasEdits_recursive(input1, input2));

    }

    /**
     * @Todo: handle string with equal length
     */
    public static boolean hasEdits_recursive(String s, String t) {

        // Negative
        //	If both of them are null
        //	If either of string is Null
        //	If both.lenght == 1

        // Positive
        if(s.length() >= t.length()){
            return isOneAwayFromAnother(s, t, 0);
        }
        return isOneAwayFromAnother(t, s, 0);

    }

    public static boolean isOneAwayFromAnother(String s, String t, int count){

        if(s.isEmpty() && t.isEmpty()){
            return count < 2;
        }

        if(t.isEmpty() && !s.isEmpty() && s.length() == 1){
            return count < 2;
        }

        if(s.charAt(0) == t.charAt(0)){
            return isOneAwayFromAnother(s.substring(1), t.substring(1), count);
        }else{
            if(count  == 1){
                return false;
            }else{
                return isOneAwayFromAnother(s.substring(1), t, count + 1);
            }
        }

    }

    private static boolean hasEditsUsingCounter(String input1, String input2) {

        if (input1.length() >= input2.length())
            return usingCounter(input1, input2);
        return usingCounter(input2, input1);

    }

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
