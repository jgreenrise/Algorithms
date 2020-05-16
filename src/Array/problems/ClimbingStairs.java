package Array.problems;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {

        //System.out.println(climbStairs(3));
        //System.out.println(climbStairs(4));
        //System.out.println(climbStairs(5));
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {

        if(n == 1)
            return 1;

        if(n == 2)
            return 2;

        int [] memo  = new int [n+1];

        return getTotalSteps(1, n, memo) + getTotalSteps(2, n, memo);

    }

    public static int getTotalSteps(int currTot, int n, int[] memo){

        if(currTot == n){
            return 1;
        }else if(currTot > n){
            return 0;
        }

        if(memo[currTot] > 0)
            return memo[currTot];

        memo[currTot] = getTotalSteps(1+currTot, n, memo) + getTotalSteps(2+currTot, n, memo);
        return memo[currTot];
    }
}
