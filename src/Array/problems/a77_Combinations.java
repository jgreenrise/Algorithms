package Array.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/?envType=study-plan-v2&envId=top-interview-150
 */
public class a77_Combinations {

    public static void main(String[] args) {

        a77_Combinations class1 = new a77_Combinations();
        System.out.printf("Sub array: " + class1.combine(4, 2));

    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> fOut = new ArrayList();
        List<Integer> buffer = new ArrayList();
        for(int j = 1; j <= n; j++){
            int currLen = 1;
            buffer = new ArrayList();
            buffer.add(j);
            getAllCombinationsForCurrentIndex(j, currLen, n, k, fOut, buffer);
        }
        return fOut;
    }

    //                                                      1,1,4,2,null, {1}
    //                                                          2,2,4,2,null {1,2}
    //                                                          3,2,4,2,null {1,3}
    //                                                          4,2,4,2,null {1,4}

    //                                                      2,1,4,2,null, {2}
    //                                                          3,2,4,2,null {2,3}
    //                                                          4,2,4,2,null {2,4}

    //                                                      3,1,4,2,null, {3}
    //                                                          4,2,4,2,null {3,4}

    public void getAllCombinationsForCurrentIndex(int currIndx, int currLen, int n, int k, List<List<Integer>> finalOut, List<Integer> buffer){

        if(currLen >= k){
            finalOut.add(new ArrayList<Integer>(buffer));
            return;
        }

        for(int j = currIndx + 1; j <= n; j++){
            buffer.add(j);
            getAllCombinationsForCurrentIndex(j, currLen + 1, n,k, finalOut, buffer);
            buffer.remove(buffer.size()-1);
        }

    }


}