package Array.problems.matrix;

/**
 * https://leetcode.com/problems/android-unlock-patterns/
 */
public class AndroidUnlockPatterns {

    public static void main(String [] args){
        System.out.println(numberOfPatterns(2,2));
    }

    public static int numberOfPatterns(int m, int n) {
        // Keep a recod of invalid numbers on the path between
        // two selected keys
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean visited[] = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            // Use the symetry to reduce DFS call
            res += DFS(visited, skip, 1, i - 1) * 4;
            res += DFS(visited, skip, 2, i - 1) * 4;
            res += DFS(visited, skip, 5, i - 1);
        }
        return res;
    }

    public static int DFS(boolean[] visited, int[][] skip, int cur, int remain) {
        // Base case: out of bound
        if (remain < 0) return 0;
        // Base case: no remaining numbers
        if (remain == 0) return 1;
        // Mark number as visited
        visited[cur] = true;
        int res = 0;
        // ?
        for (int i = 1; i <= 9; i++) {
            // Next key must be unvisited
            // Current key and next key are adjacent or skip number is already visited
            if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                res += DFS(visited, skip, i, remain-1);
            }
        }
        // Mark as unvisited for the rest of recursion calls after return from the first one
        visited[cur] = false;
        return res;
    }
}