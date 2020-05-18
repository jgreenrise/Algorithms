package recursive.fibonacci;

import java.util.ArrayList;

/**
 * DivideAndConquer: [a, b, ab, c, d, cd, ac, ad, acd, bc, bd, bcd, abc, abd, abcd],
 * 	Dynamic prog: [a, b, ab, c, ac, bc, abc, d, ad, bd, abd, cd, acd, bcd, abcd]
 * DivideAndConquer: [d, e, de, f, df, ef, def],
 * 	Dynamic prog: [d, e, de, f, df, ef, def]
 * DivideAndConquer: [a, b, ab],
 * 	Dynamic prog: [a, b, ab]
 * DivideAndConquer: [a],
 * 	Dynamic prog: [a]
 */
public class a5_SubSetOfStrings {

    public static void main(String[] args) {

        a5_SubSetOfStrings class1 = new a5_SubSetOfStrings();
        String[] subsets = {"abcd", "def", "ab", "a"};

        for (String str : subsets) {
            System.out.println(
                    // TC: O(nlgn)
                    "DivideAndConquer: " + class1.divideAndC(str)+", \n\t" +
                    // TC: O(n2)
                    "Dynamic prog: "+class1.dynamicProgramming(str));
        }

    }

    public ArrayList<String> dynamicProgramming(String s) {

        ArrayList<String> out = new ArrayList<>();
        out.add(String.valueOf(s.charAt(0)));

        for (int j = 1; j < s.length(); j++) {
            out = merge(out, String.valueOf(s.charAt(j)));
        }

        return out;
    }

    private ArrayList<String> merge(ArrayList<String> left, String currchar) {
        ArrayList<String> output = new ArrayList();
        output.addAll(left);
        output.add(currchar);

        for (int i = 0; i < left.size(); i++) {
            output.add(left.get(i)+currchar);
        }

        return output;
    }


    public ArrayList<String> divideAndC(String s) {
        return divide(s, 0, s.length()-1);
    }

    public ArrayList<String> divide(String s, int start, int end) {

        ArrayList<String> list = new ArrayList();
        if(start == end){
            list.add(String.valueOf(s.charAt(start)));
            return list;
        }

        int mid = (start+end)/2;

        ArrayList<String> left  = divide(s, start, mid);
        ArrayList<String> right = divide(s, mid+1, end);
        return conquer(left, right);
    }

    public ArrayList<String> conquer(ArrayList<String> left, ArrayList<String> right){

        ArrayList<String> output = new ArrayList();
        output.addAll(left);
        output.addAll(right);

        StringBuilder sbr = null;
        for(int j=0; j<left.size(); j++){
            sbr = new StringBuilder();
            sbr.append(left.get(j));
            for(int i = 0; i<right.size(); i++){
                output.add(sbr.toString()+right.get(i));
            }
        }

        return output;

    }


}
