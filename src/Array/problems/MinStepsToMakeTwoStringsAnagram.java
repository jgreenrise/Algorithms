package Array.problems;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class MinStepsToMakeTwoStringsAnagram {

    public static void main(String args[]) {

        MinStepsToMakeTwoStringsAnagram sandbox = new MinStepsToMakeTwoStringsAnagram();
        System.out.println(sandbox.minSteps("bab", "aba"));
        System.out.println(sandbox.minSteps("leetcode", "practise"));
        System.out.println(sandbox.minSteps("gctcxyuluxjuxnsvmomavutrrfb","qijrjrhqqjxjtprybrzpyfyqtzf"));
    }

    public int minSteps(String s, String t) {

        int [] left = getIntArray(s);
        int [] right = getIntArray(t);
        return fetchMinSteps(left,  right);

    }

    //left = 0, 3,4,1,2
    //right = 0, 1,2,3,4

    private int fetchMinSteps(int[] left, int[] right) {


        //[a:1, b:2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //[a:2, b:1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        int counterAdditions = 0;
        int counterSubtractions = 0;

        for (int i = 0; i < left.length; i++) {
            if(left[i] == 0 && right[i] == 0){
                continue;
            }else if(left[i] == 0 && right[i] != 0){
                counterSubtractions = counterSubtractions + right[i];
            }else if(left[i] == right [i]){
                continue;
            }else if(left[i] > right [i]){
                counterAdditions = counterAdditions + (left[i] - right[i]);
            }else{
                counterSubtractions = counterSubtractions + (right[i] - left[i]);
            }
        }

        return (counterAdditions + counterSubtractions) / 2;


    }

    public int [] getIntArray(String str){
        int [] out = new int [26];
        char [] chars = str.toCharArray();
        for (char aChar : chars) {
            // Lower case starts from 97
            out[(int) aChar - 97]++;
        }
        return out;
    }


}
