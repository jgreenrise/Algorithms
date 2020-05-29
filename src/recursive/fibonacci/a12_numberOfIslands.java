package recursive.fibonacci;

import java.util.HashSet;
import java.util.Set;

public class a12_numberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//char[][] matrix = { {1,1,0,1}, {0,0,1,0}, {0,0,0,0} };
		char[][] matrix = { {1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0} };

		a12_numberOfIslands class1 = new a12_numberOfIslands();
		System.out.println("\n Total island: "+ class1.numIslands(matrix));

	}

	public int numIslands(char[][] grid) {

		int totRows = grid.length;
		int totCols = grid[0].length;
		int islands = 2;

		for(int row=0; row<totRows; row++){
			for(int col=0; col<totCols; col++){
				if(grid[row][col] == 0 || grid[row][col] > 1){
					continue;
				}
				islands = dfs(grid, row, col, totRows, totCols, islands) + 1;
			}
		}

		return islands-2;
	}

	public int dfs(char [][] grid, int sr, int sc, int totRows, int totCols, int islands){

		if(sr >= totRows || sc >= totCols){
			return islands;
		}

		if(grid[sr][sc] == 0){
			return islands;
		}

		if(grid[sr][sc] == 1){
			grid[sr][sc] = (char) islands;
			dfs(grid, sr+1, sc, totRows, totCols, islands);
			dfs(grid, sr, sc+1, totRows, totCols, islands);
		}

		return islands;

	}

}
