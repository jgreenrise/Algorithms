package Array.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class a64MinimumPathSum {

	public static void main(String[] args) {

		a64MinimumPathSum class1 = new a64MinimumPathSum();

		// 4 by 4
		int[][] matrix = { {1,3,1},{1,5,1},{4,2,1} };
		System.out.println(class1.minPathSum(matrix));

	}

	public int minPathSum(int[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;
		Map<Integer, Integer> map = new HashMap();
		return minPathSums(0,0, rows, cols, grid, map);

	}

	public int minPathSums(int currR, int currC, int rows, int cols, int [][] grid, Map<Integer, Integer> map){

		if(currR >= rows && currC >= cols){
			return 0;
		}

		if(currR >= rows || currC >= cols) {
			return -1;
		}

		if(currR == rows-1 && currC == cols - 1){
			return grid[currR][currC];
		}else{
			Integer currLoc = currR * cols + currC;
			if(map.containsKey(currLoc)){
				return map.get(currLoc);
			}else{
				int right = minPathSums(currR, currC+1, rows, cols, grid, map);
				int bottom = minPathSums(currR +1, currC, rows, cols, grid, map);
				int currVal = grid[currR][currC] + Math.min(right == -1 ? bottom: right, bottom == -1? right: bottom);
				map.put(currLoc, currVal);
				return currVal;
			}
		}
	}



}
