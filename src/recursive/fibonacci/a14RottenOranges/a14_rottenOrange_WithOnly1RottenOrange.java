package recursive.fibonacci.a14RottenOranges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/solution/
 */
public class a14_rottenOrange_WithOnly1RottenOrange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //int[][] matrix = { {2,1,1}, {1,1,0}, {0,1,1} };
        int[][] matrix = { {1,2,2} };

        a14_rottenOrange_WithOnly1RottenOrange class1 = new a14_rottenOrange_WithOnly1RottenOrange();
        System.out.println("\n Total island: " + class1.orangesRotting(matrix));

    }

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int rottenRow = 0;
        int rottenCol = 0;
        boolean matchFound = doesFreshOrangesExist(grid, rows, cols);
        if(!matchFound){
            // No fresh oranges found
            return 0;
        }

        boolean matchFoundRottenOranges = doesRottenOrangesExist(grid, rows, cols);
        if(matchFound && !matchFoundRottenOranges){
            // Fresh orange exist, Rotten doesnt
            return -1;
        }

        for(int j=0; j<rows; j++){
            for(int i=0; i< cols; i++){
                if(grid[j][i] == 2){
                    rottenRow = j;
                    rottenCol = i;
                    break;
                }
            }
        }

        int time = dfs(rottenRow, rottenCol, grid, rows, cols);

        boolean doesFreshOrangeExist = doesFreshOrangesExist(grid, rows, cols);
        if(doesFreshOrangeExist){
            return -1;
        }

        return time/10;

    }

    public int dfs(int rottenRow, int rottenCol, int [][] grid, int rows, int cols){

        Queue<Integer> q = new LinkedList();
        q.add(rottenRow * cols + rottenCol);
        grid[rottenRow][rottenCol] = 0;
        int out = 0;

        while(!q.isEmpty()){

            int id = q.poll();
            int row = id / cols;
            int col = id % cols;
            int val = grid[row][col];
            boolean matchFound = false;

            if(row+1 < rows && grid[row+1][col] == 1){
                q.add((row+1) * cols + col);
                grid[row+1][col] = val+10;
                matchFound = true;
            }

            if(row-1 >= 0 && grid[row-1][col] == 1){
                grid[row-1][col] = val+10;
                q.add((row-1) * cols + col);
                matchFound = true;
            }

            if(col-1 >= 0 && grid[row][col-1] == 1){
                grid[row][col-1] = val+10;
                q.add(row * cols + col-1);
                matchFound = true;
            }

            if(col+1 < cols && grid[row][col+1] == 1){
                grid[row][col+1] = val+10;
                q.add(row * cols + col+1);
                matchFound = true;
            }

            if(matchFound){
                out = Math.max(out, val+10);
            }else{
                out = Math.max(out, val);
            }
        }

        return out;

    }

    public boolean doesRottenOrangesExist(int[][] grid, int rows, int cols){

        for(int j=0; j<rows; j++){
            for(int i=0; i< cols; i++){
                if(grid[j][i] == 2)
                    return true;
            }
        }

        return false;

    }

    public boolean doesFreshOrangesExist(int[][] grid, int rows, int cols){

        for(int j=0; j<rows; j++){
            for(int i=0; i< cols; i++){
                if(grid[j][i] == 1)
                    return true;
            }
        }

        return false;

    }

}
