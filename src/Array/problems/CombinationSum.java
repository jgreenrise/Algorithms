package Array.problems;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum class1 = new CombinationSum();

        int[] arr_i_input = {10, 20, -20, 40, 30, 10, 10, 10, 10};
        //int[] arr_i_input = {-1, -2};
        //int[] arr_i_input = {5,7};

        //System.out.printf("Sub array: " + class1.subarraySum(arr_i_input, 40));
        System.out.printf("Sub array: " + class1.combinationSum(new int[]{2,3,6,7}, 7));
        //System.out.printf("Sub array: " + class1.combinationSum(new int[]{2,3,5}, 8));
        //System.out.printf("Sub array: " + class1.combinationSum(new int[]{2,7, 6, 5}, 16));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> out = new ArrayList();
        startRecursionWithMemoization(0, out, candidates, target, new ArrayList<>());
        return out;
    }

    public List<List<Integer>> startRecursionWithMemoization(int currTotal, List<List<Integer>> out, int[] candidates, int target, List<Integer> tmpList){

        for(int j=0; j < candidates.length; j++){

            int sum = currTotal + candidates[j];
            if(sum == target ){
                tmpList.add(candidates[j]);

                out.add(tmpList);
                Collections.sort(tmpList);
                if(!out.contains(tmpList))
                    out.add(tmpList);

                tmpList.remove(tmpList.size() - 1);

            }else if(sum > target){
                // Do nothing
            }else{
                tmpList.add(candidates[j]);
                startRecursionWithMemoization(sum, out, candidates, target, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }

        return out;

    }


}