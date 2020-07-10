package Array.problems.subarray;

import java.util.*;

public class SubarrayEqualsK {

    public static void main(String[] args) {

        SubarrayEqualsK class1 = new SubarrayEqualsK();

        int[] arr_i_input = {10, 20, -20, 40, 30, 10, 10, 10, 10};
        //int[] arr_i_input = {-1, -2};
        //int[] arr_i_input = {5,7};

        //System.out.printf("Sub array: " + class1.subarraySum(arr_i_input, 40));
        System.out.printf("Sub array: " + class1.subarraySum(new int[]{1, 1, 1}, 2));
        //System.out.printf("Sub array: " + class1.subarraySum(new int[]{-1, -1, 1}, 1));
        //System.out.printf("Sub array: " + class1.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
        //System.out.printf("Sub array: " + class1.subarraySum(new int[]{-624,-624,-624,-624,-624,-624,-624,-624,-624,-624},-624));

    }

    // O(n): CREATE LEFT SUM & HASM MAP
    public int usingMap(int[] nums, int k) {

        int sum = 0;
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 0; i < nums.length; i++) {

            sum+= nums[i];

            if(map.containsKey(sum - k)){
                counter += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) +1);

        }

        return counter;
    }

    // O(n2): CREATE LEFT SUM
    public int createPrefixSum(int[] nums, int k) {

        int sum = 0;
        int counter = 0;
        int [] left_sum = new int[nums.length];
        left_sum[0] = nums[0];

        // O(n): CREATE LEFT_SUM
        for (int i = 1; i < nums.length; i++) {
            left_sum[i] = left_sum[i] + left_sum[i - 1];
        }

        for (int i = 0; i < left_sum.length; i++) {
            for (int j = i; j < left_sum.length; j++) {

                if (i == 0) {
                    sum = left_sum[j];
                } else {
                    sum = left_sum[j] - left_sum[i - 1];
                }

                if (sum == k)
                    counter++;
            }
        }
        return counter;
    }

    // TC: O(n3)
    public int bruteForce(int[] nums, int k) {
        int tot = 0;

        // O(n):  Loop from left till last element
        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];

            if (currSum == k)
                tot++;

            // O(n):  Loop from left + 1 till Last element
            for (int j = i + 1; j < nums.length; j++) {

                // O(n): Calculate sum for O(n) times
                currSum += nums[j];

                if (currSum == k)
                    tot++;
            }
        }

        return tot;

    }

    /**
     * TIME LIMIT EXCEEDED
     * Negative items goes to left side of array: tmp[tmp.length/2 + currSum]
     * Positive items goes to right side of array: tmp[tmp.length/2 + currSum]
     */
    public int subarraySum2(int[] nums, int k) {

        int[] tmp = new int[1000000];
        int res = 0;
        List<Integer> list = new ArrayList();

        for (int j = nums.length - 1; j >= 0; j--) {
            int num = nums[j];

            for (int i = 0; i < list.size(); i++) {
                int currSum = num + list.get(i);
                list.remove(i);
                list.add(i, currSum);
                tmp[tmp.length / 2 + currSum]++;

            }

            list.add(num);
            tmp[tmp.length / 2 + num]++;

        }

        return tmp[tmp.length / 2 + k];

    }


}