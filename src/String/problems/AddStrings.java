package String.problems;

public class AddStrings {

    public static void main(String[] args) {
        //System.out.println(addStrings("123", "4098"));
        System.out.println(addStrings("1", "9"));

    }

    public static String addStrings(String num1, String num2) {

        int left = num1.length() - 1;
        int right = num2.length() - 1;
        int carryOver = 0;
        StringBuilder sbr = new StringBuilder();

        while(left>-1 || right >-1){

            int currTotal = 0;
            if(left >= 0){
                //CharAt
                //These numbers are UNICODE code points of the digits. If you need to get the digit value, subtract '0' from them:
                currTotal = num1.charAt(left) - '0';
                left = left - 1;
            }
            if(right >= 0){
                currTotal = currTotal + (num2.charAt(right) - '0');
                right = right - 1;
            }

            currTotal = currTotal + carryOver;

            // New Carry Over
            carryOver = currTotal / 10;
            sbr.append(currTotal%10);

        }

        if(carryOver > 0){
            sbr.append(carryOver);
        }

        return sbr.reverse().toString();

    }
}
