package Array.problems.matrix;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

	public static void main(String[] args) {

		// 4 by 4
		char[][] matrix = { { '1', '0', '1' ,'0', '0'}, { '1' ,'0', '1' ,'1', '1' }, { '1', '1', '1' ,'1', '1' },
				{ '1' ,'0', '0', '1', '0' } };

		matrix = new char[][] {{'1'}};
		matrix = new char[][] {{'0'}};

		MaximalSquare class1 = new MaximalSquare();

		// TC: O (mn square)
		System.out.println(class1.maximalSquare_Recursive(matrix));

		// TC: O(mn) - Dynamic Programming
		System.out.println(class1.maximalSquare(matrix));

	}

	public int maximalSquare(char[][] matrix) {

		int rows = matrix.length;
		if(rows == 0)
			return 0;

		int cols = matrix[0].length;
		if(cols == 0)
			return 0;

		int currMax = 0;
		int globalMax = 0;

		int [][] tmpMat = new int [rows+1][cols+1];

		for(int row = 1; row < tmpMat.length; row ++){
			for(int col = 1; col < tmpMat[0].length; col++){
				if(matrix[row-1][col-1] == '0'){
					// Skip
				}else{
					// Calculate Min (Top, left, Adjacent)
					int min = Math.min(tmpMat[row-1][col], tmpMat[row][col-1]);
					min = Math.min(min, tmpMat[row-1][col-1]);

					// Assign
					tmpMat[row][col] = 1+min;

					// Global max
					globalMax = Math.max(globalMax,tmpMat[row][col]);
				}
			}
		}

		return globalMax*globalMax;
	}

	public int maximalSquare_Recursive(char[][] matrix) {

		int rows = matrix.length;
		if(rows == 0)
			return 0;

		int cols = matrix[0].length;
		if(cols == 0)
			return 0;

		int currMax = 0;
		int globalMax = 0;

		for(int row = 0; row < rows; row ++){
			for(int col = 0; col < cols; col++){
				if(matrix[row][col] == '1'){
					currMax = getMaxSquare(matrix, row, col, row, col, 1, rows, cols);
					globalMax = Math.max(currMax * currMax, globalMax);
				}
			}
		}

		return globalMax;
	}

	public int getMaxSquare(char [][] mat, int minRow, int minCol, int sr, int sc, int depth, int rows, int cols){

		if(sr+1 >= rows || sc+1 >= cols){
			return depth;
		}

		// Validate Adjacent
		if(mat[sr+1][sc+1] == '1'){
			// Navigate UP
			for(int j = sr; j >= minRow; j--){
				if(mat[j][sc+1] == '0')
					return depth;
			}

			// Navigate LEFT
			for(int j = sc; j >= minCol; j--){
				if(mat[sr+1][j] == '0')
					return depth;
			}

			return getMaxSquare(mat, minRow, minCol, sr+1, sc+1, depth+1, rows, cols);
		}else{
			return depth;
		}

	}



}
