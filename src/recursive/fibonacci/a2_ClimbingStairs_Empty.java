package recursive.fibonacci;

public class a2_ClimbingStairs_Empty {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));

    }

    public static int climbStairs(int n) {

        if(n == 0) return n;

        int [] memo = new int [n+1];
        for(int j =0; j < n+1; j++)
            memo[j] = -1;

        return climbStairsAdd(n, 1, 0, memo, 1) +
                climbStairsAdd(n, 2, 0, memo, 2);

    }

    public static int climbStairsAdd(int n, int currCount, int tot, int[] memo, int step) {

        if(memo[currCount] != -1){
            return memo[currCount];
        }

        if(currCount == n){
            return tot + 1;
        }else if(currCount > n){
            return 0;
        }

        memo[currCount] = climbStairsAdd(n, currCount + step, tot, memo, step);
        return memo[currCount];

    }



}
