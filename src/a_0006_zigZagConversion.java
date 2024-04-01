// https://www.youtube.com/watch?v=Q2Tw6gcVEwc
// https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
public class a_0006_zigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder sbr = new StringBuilder();
        int jump = numRows * 2 - 2;
        int counter = 2;
        int sLen = s.length();

        //System.out.println("Jump: "+jump);
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                while (j < sLen) {
                    //System.out.println("101 Adding str at indx: "+j);
                    sbr.append(String.valueOf(s.charAt(j)));
                    j = j + jump;
                }
            } else {
                int j = i;
                while (j < sLen) {
                    //System.out.println("102 Adding str at indx: "+j);
                    sbr.append(String.valueOf(s.charAt(j)));
                    int intermediatecharIndex = j + jump - counter;
                    if (intermediatecharIndex < sLen)
                        sbr.append(String.valueOf(s.charAt(intermediatecharIndex)));
                    //System.out.println("Adding str at indx: "+(intermediatecharIndex));
                    j = j + jump;
                }
                counter = counter + 2;
            }
        }
        return sbr.toString();

    }

}
