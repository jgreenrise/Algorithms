package recursive.fibonacci;

public class a2_ClimbingStairs {

    public static void main(String[] args) {

        for (int i = 4; i < 20; i++) {
            System.out.println("Stairs combination: " + i + ": " + climbStairsRec(i) + " Memo: " + climbStairsMemo(i) + ", BottomUp: " + bottomUp(i) + ", Great: " + bottomUpSpaceEff(i));
        }
    }

    public static int bottomUpSpaceEff(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int greatGrandParent = 0;
        int grandParent = 1;
        int parent = 2;
        int out = 0;

        for (int j = 3; j <= n; j++) {
            if (j == 3) {
                out = 1 + parent + grandParent + greatGrandParent;
            } else {
                out = parent + grandParent + greatGrandParent;
            }
            greatGrandParent = grandParent;
            grandParent = parent;
            parent = out;
        }

        return out;

    }

    public static int bottomUp(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1; // 1 step only
        dp[2] = 2; // {1,1}, {2} > 2 steps only
        dp[3] = 4; // {1,1,1}, {2,1}, {1,2}, {3} > 4 steps only

        for (int j = 4; j <= n; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        return dp[n];

    }

    public static int climbStairsRec(int n) {
        if (n == 0)
            return n;
        return getStairSteps(0, n);
    }

    public static int getStairSteps(int tot, int n) {

        int left = 0, middle = 0, right = 0;

        if (tot + 1 <= n) {
            if (tot + 1 == n) {
                left = 1;
            } else {
                left = getStairSteps(tot + 1, n);
            }
        }

        if (tot + 2 <= n) {
            if (tot + 2 == n) {
                middle = 1;
            } else {
                middle = getStairSteps(tot + 2, n);
            }
        }

        if (tot + 3 <= n) {
            if (tot + 3 == n) {
                right = 1;
            } else {
                right = getStairSteps(tot + 3, n);
            }
        }

        return left + middle + right;
    }

    public static int climbStairsMemo(int n) {
        if (n == 0)
            return n;
        return getStairSteps(0, n, new int[n + 1]);
    }

    public static int getStairSteps(int tot, int n, int[] memo) {

        if (memo[tot] != 0) {
            return memo[tot];
        }

        int left = 0, middle = 0, right = 0;

        if (tot + 1 <= n) {
            if (tot + 1 == n) {
                left = 1;
            } else {
                memo[tot + 1] = getStairSteps(tot + 1, n, memo);
                left = memo[tot + 1];
            }
        }

        if (tot + 2 <= n) {
            if (tot + 2 == n) {
                middle = 1;
            } else {
                memo[tot + 2] = getStairSteps(tot + 2, n, memo);
                middle = memo[tot + 2];
            }
        }

        if (tot + 3 <= n) {
            if (tot + 3 == n) {
                right = 1;
            } else {
                memo[tot + 3] = getStairSteps(tot + 3, n, memo);
                right = memo[tot + 3];
            }
        }

        return left + middle + right;
    }

}
