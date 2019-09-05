package String.problems;

public class OneAway {

    public static void main(String[] args) {
        String input1 = "pale";
        String input2 = "ple";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        input1 = "ple";
        input2 = "pale";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));


        input1 = "pales";
        input2 = "pale";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        input1 = "pale";
        input2 = "bale";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        input1 = "pale";
        input2 = "bake";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        input1 = "ppalem";
        input2 = "palem";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        input1 = "palem";
        input2 = "ppalem";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

        input1 = "apple";
        input2 = "aple";
        System.out.println("\n"+input1 +" : "+ input2 + " = "+ hasEditsUsingCounter(input1, input2));
        System.out.println("Approach 2 2: "+input1 +" : "+ input2 + " = "+hasEditsRecursively(input1, input2, 0, input1.length() > input2.length(), input1.length() == input2.length()));

    }

    private static boolean hasEditsRecursively(
            String input1, String input2, int counter, boolean isInput1BiggerThanInput2, boolean isInput1LengthEqualtoInput2Length ){

        if (Math.abs(input1.length() - input2.length()) > 1)
            return false;

        if (isInput1LengthEqualtoInput2Length && input1.equals(input2))
            return true;

        if(input1.length() == 0){
            if(input2.length() == 1 && counter == 0)
                return true;
        }

        if(input2.length() == 0){
            if(input1.length() == 1 && counter == 0)
                return true;
        }

        if (input1.charAt(0) == (input2.charAt(0))) {

            if (isInput1LengthEqualtoInput2Length && input1.length() == 1)
                return true;

            input1 = input1.substring(1);
            input2 = input2.substring(1);

            return
                    hasEditsRecursively(
                            input1,
                            input2,
                            counter,
                            input1.length() > input2.length(),
                            input1.length() == input2.length());
        } else {

            counter = counter + 1;

            if (counter > 1)
                // More than 1 edits is found
                return false;

            if (isInput1LengthEqualtoInput2Length) {

                input1 = input1.substring(1);
                input2 = input2.substring(1);

                return
                        hasEditsRecursively(
                                input1,
                                input2,
                                counter,
                                input1.length() > input2.length(),
                                input1.length() == input2.length());
            }

            if (isInput1BiggerThanInput2) {
                input1 = input1.substring(1);
                return
                        hasEditsRecursively(
                                input1,
                                input2,
                                counter,
                                input1.length() > input2.length(),
                                input1.length() == input2.length());
            } else {
                input2 = input2.substring(1);
                return
                        hasEditsRecursively(
                                input1,
                                input2,
                                counter,
                                input1.length() > input2.length(),
                                input1.length() == input2.length());
            }
        }

    }

    private static boolean hasEditsUsingCounter(String input1, String input2) {

        if(input1.length() >= input2.length())
            return usingCounter(input1, input2);
        return usingCounter(input2, input1);

    }

    private static boolean usingCounter(String input1, String input2) {

        char[] char1 = input1.toCharArray();
        char[] char2 = input2.toCharArray();
        int counter = 0;

        for (int i = 0; i < input2.length(); i++) {

            if (char1[i + counter] == char2[i]) {
                continue;
            } else {

                counter = counter + 1;
                if (counter > 1)
                    return false;
            }

            if (i == 0 && counter == 1) {
                if (input1.substring(i + 1).equals(input2.substring(i + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        if(counter < 2)
            return true;

        return false;
    }


}
