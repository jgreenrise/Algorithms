package recursive.fibonacci;

/**
 * https://leetcode.com/problems/climbing-stairs/submissions/
 */
public class a2_ClimbingStairs {

    public static void main(String[] args) {

        for (int i = 3; i < 10; i++) {
            System.out.println("\nRecursive: " + i + ": \t" + recursive(i, 0) );
            System.out.println("Recursive - Memo: " + i + ": \t" + recWithMemo(i) );
            System.out.println("Dynamic Prog " + i + ": \t" + dynamicProg(i) );
            System.out.println("Dynamic Prog (Space efficient): " + i + ": \t" + dynamicProgSpaceEff(i) );
        }
    }

    public static int dynamicProgSpaceEff(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int grandParent = 1;
        int parent = 2;
        int out = 0;

        for (int j = 3; j <= n; j++) {
            out = parent + grandParent;
            grandParent = parent;
            parent = out;
        }

        return out;

    }

    public static int dynamicProg(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1; // 1 step only
        dp[2] = 2; // {1,1}, {2} > 2 steps only

        for (int j = 3; j <= n; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }

        return dp[n];

    }

    public static int recursive(int n, int currTot) {

        int left = 0;
        int right = 0;

        if(currTot == n)
            return 1;

        if(currTot+1 <= n)
            left = recursive(n,currTot +1);

        if(currTot+2 <= n)
            right = recursive(n,currTot +2);

        return left + right;

    }

    public static int recWithMemo(int n) {

        int memo [] = new int [n+1];
        return recursive(n,0, memo);
    }

    public static int recursive(int n, int currTot, int[] memo) {

        if(memo[currTot] != 0)
            return memo[currTot];

        int left = 0;
        int right = 0;
        if(currTot == n)
            return 1;

        if(currTot+1 <= n)
            left = recursive(n,currTot +1, memo);

        if(currTot+2 <= n)
            right = recursive(n,currTot +2, memo);

        memo[currTot] = left+right;
        return left+right;

    }

}
