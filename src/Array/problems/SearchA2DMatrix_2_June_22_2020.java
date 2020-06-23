package Array.problems;

public class SearchA2DMatrix_2_June_22_2020 {

	public static void main(String[] args) {

		SearchA2DMatrix_2_June_22_2020 class1 = new SearchA2DMatrix_2_June_22_2020();

		// 4 by 4
		int[][] matrix = { { 1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, { 3,   6,  9, 16, 22 },
				{ 10, 13, 14, 17, 24 } , {18, 21, 23, 26, 30} };
		System.out.println(class1.searchMatrix(matrix, 5));
		System.out.println(class1.searchMatrix(matrix, 20));

/*
		int[][] matrix = { { 1, 1} };
		System.out.println(class1.searchMatrixTwice(matrix, 0));
		System.out.println(class1.searchMatrixTwice(matrix, 0));
*/

	}

	/**
	 * Snake Strategy
	 */
	private boolean searchMatrix(int[][] mat, int target) {

		int rows = mat.length;
		if(rows == 0){
			return false;
		}

		int cols = mat[0].length;
		if(cols == 0){
			return false;
		}

		if(rows == 1 && cols == 1){
			return mat[0][0] == target;
		}

		int row = rows-1;
		int col = 0;

		while(row >=0 && col < cols){
			if(mat[row][col] == target){
				return true;
			}

			if(mat[row][col] > target){
				row -- ;
			}else if(mat[row][col] < target){
				col --;
			}else{
				return true;
			}
		}



	}

	/**
	 * 1. Search in 1st column, and then scroll through entire row
	 * 2. Search in 1st rows and then scroll through all columsn values
	 */
	public boolean searchMatrixTwice(int[][] mat, int target) {

		int rows = mat.length;
		if(rows == 0){
			return false;
		}

		int cols = mat[0].length;
		if(cols == 0){
			return false;
		}

		if(rows == 1 && cols == 1){
			return mat[0][0] == target;
		}

		int col = 0;
		int row = 0;
		boolean matchFound = false;

		// Searching in 1st column
		for(col = 0; col < cols; col++){
			for(row = 0; row < rows; row++){
				if(mat[row][col] == target){
					return true;
				}

				if(mat[row][col] < target){
					matchFound = false;
					continue;
				}

				if(mat[row][col] > target){
					if(row == 0){
						matchFound = true;
						break;
					}
					matchFound = true;
					row = row - 1;
					break;
				}

				if(row == rows-1){ 	// Last row
					matchFound = true;
					break;
				}
			}
			if(matchFound){
				break;
			}
		}

		for(col =0; col < cols; col++){
			if(row < rows && mat[row][col] == target){
				return true;
			}
		}

		matchFound = false;

		// Searching in 1st row
		for(row =0; row < rows; row++){
			for(col = 1; col < cols; col++){
				if(mat[row][col] == target){
					return true;
				}

				if(mat[row][col] < target){
					matchFound = false;
					continue;
				}

				if(mat[row][col] > target){
					if(col == 0){
						matchFound = true;
						break;
					}
					matchFound = true;
					col = col - 1;
					break;
				}


				if(col == cols - 1){	// Last column
					matchFound = true;
					break;
				}

			}
		}

		for(row = 0; row < rows; row++){
			if(col < cols && mat[row][col] == target){
				return true;
			}
		}

		return false;

	}



}
