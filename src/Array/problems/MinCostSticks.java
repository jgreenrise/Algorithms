package Array.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */
public class MinCostSticks {

    public static void main(String[] args) {
        MinCostSticks class1 = new MinCostSticks();
        //int [] nums = {3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        int [] nums = {1,3,4,5,6,8};
        System.out.println(class1.connectSticks(nums));
        //System.out.println(class1.connectSticks_UsingPriorityQueue(new int[]{3354,4316,3259,4904,4598,474,3166,6322,8080,9009}));
        System.out.println(class1.connectSticks_UsingPriorityQueue(new int[]{1,3,4,5,6,8}));
    }

    /**
     * Bruteforce Solution
     *  Is not efficient at all
     *  Sorrting required after every for loop
     *
     * Throws Time limit exception, since sorting required inside for loop.
     */
    private int connectSticks(int[] sticks) {
        Arrays.sort(sticks);

        int out = 0;
        for (int i = 1; i < sticks.length; i++) {
            int currOut = sticks[i] + sticks[i-1];
            out += currOut;
            sticks[i] = currOut;
            System.out.println("Out: "+out);

            Arrays.sort(sticks);
        }

        return out;
    }

    public int connectSticks_UsingPriorityQueue(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < sticks.length; i++) {
            pq.offer(sticks[i]);
        }

        int out = 0;
        while(pq.size() > 1){
            int currSum = pq.poll() + pq.poll();
            out += currSum;
            pq.offer(currSum);
            System.out.println("** Out: "+out);
        }

        return out;

    }


}
