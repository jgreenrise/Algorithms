package recursive.fibonacci.a3_robotIngrid;

public class a3_RobotInGrid_getTotalPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4 by 4
		int[][] matrix = new int [4][3];
		boolean [][] offlimits = new boolean [4][3];
		offlimits[1][1] = true;
		offlimits[2][1] = true;

		a3_RobotInGrid_getTotalPaths robot = new a3_RobotInGrid_getTotalPaths();
		System.out.println("Rec: "+robot.getWays(matrix, offlimits)+", Mmeo: "+robot.getTotalWaysMemo(matrix, offlimits));

		matrix = new int [2][1];
		matrix[0][0]=7;
		matrix[1][0]=3;
		offlimits = new boolean [2][1];
		robot = new a3_RobotInGrid_getTotalPaths();
		System.out.println("Rec: "+robot.getWays(matrix, offlimits)+", Mmeo: "+robot.getTotalWaysMemo(matrix, offlimits));

		matrix = new int [2][1];
		matrix[0][0]=1;
		matrix[1][0]=1;
		offlimits = new boolean [2][1];
		robot = new a3_RobotInGrid_getTotalPaths();
		System.out.println("Rec: "+robot.getWays(matrix, offlimits)+", Mmeo: "+robot.getTotalWaysMemo(matrix, offlimits));

	}

		public int getTotalWaysMemo(int[][] mat, boolean[][] offlimit) {
			int totalRows = mat.length;
			int totalCols = mat[0].length;
			int [][] memo = new int [totalRows+1][totalCols+1];

			for(int i = 0; i <= totalRows; i++) {
				for(int j = 0; j <= totalCols; j++) {
					// read information from somewhere
					memo[i][j] = -1;
				}
			}

			return getTotalWaysMemo(mat,offlimit,0,0,totalRows,totalCols, memo);
		}

		private int getTotalWaysMemo(int[][] mat, boolean[][] offlimits, int currRow, int currCol, int totalRows, int totalCols, int[][] memo) {

			if(memo[currRow][currCol] > -1){
				return memo[currRow][currCol];
			}

			int count = 0;
			int right = 0;
			int bottom = 0;

			if(currCol+1 < totalCols && !offlimits[currRow][currCol+1]){
				if(currCol+1 == totalCols-1 && currRow == totalRows-1){
					count++;
					memo[currRow][currCol+1] = count;
				}else{
					right= getTotalWaysMemo(mat, offlimits, currRow, currCol+1, totalRows, totalCols, memo);
					memo[currRow][currCol+1] = right;
				}
			}

			if(currRow+1 < totalRows && !offlimits[currRow+1][currCol]){
				if(currCol == totalCols-1 && currRow+1 == totalRows-1){
					count++;
					memo[currRow+1][currCol] = count;
				}else {
					bottom = getTotalWaysMemo(mat, offlimits, currRow + 1, currCol, totalRows, totalCols, memo);
					memo[currRow + 1][currCol] = bottom;
				}
			}

			return count+right+bottom;
		}


	public int getWays(int [][]mat, boolean [][]offlimit){
		int totalRows = mat.length;
		int totalCols = mat[0].length;
		return getWaysRec(mat,offlimit,0,0,totalRows,totalCols);
	}

	public int getWaysRec(int [][] mat, boolean [][] offlimits, int currRow, int currCol, int totalRows, int totalCols){

		int count = 0;
		int right = 0;
		int bottom = 0;

		if(currCol+1 < totalCols && !offlimits[currRow][currCol+1]){
			if(currCol+1 == totalCols-1 && currRow == totalRows-1){
				count++;
			}else{
				right= getWaysRec(mat, offlimits, currRow, currCol+1, totalRows, totalCols);
			}
		}

		if(currRow+1 < totalRows && !offlimits[currRow+1][currCol]){
			if(currCol == totalCols-1 && currRow+1 == totalRows-1){
				count++;
			}else {
				bottom = getWaysRec(mat, offlimits, currRow + 1, currCol, totalRows, totalCols);
			}
		}

		return count+right+bottom;

	}

}
