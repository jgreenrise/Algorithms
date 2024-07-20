package Array.problems;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

Given an M x N array where each cell could be {empty, lighthouse, rock}, find the maximum luminance value within this array.

1. Lighthouses (L) emit light in for directions (up, down, left, right).
2. Each lighthouse emits light with luminance of 1.
3. Luminance is additive - if a cell is illuminated by two light houses, it has a luminance of 2.
4. Rocks block light from all directions.

Rocks/lighthouses

string [][] inputMatrix
╔══╦═══╦═══╦═══╦══╗
║  ║   ║   ║   ║  ║
╠══╬═══╬═══╬═══╬══╣
║  ║ L ║   ║   ║  ║
╠══╬═══╬═══╬═══╬══╣
║  ║ R ║   ║ L  ║  ║
╠══╬═══╬═══╬═══╬══╣
║  ║   ║   ║   ║  ║
╚══╩═══╩═══╩═══╩══╝
  L
L L L
  L


2 3 2
3 5 3
2 3 2
o(m*n) - find the L value
*(m+n)

Luminance
╔══╦═══╦═══╦═══╦══╗
║  ║ 1 ║   ║ 1 ║  ║
╠══╬═══╬═══╬═══╬══╣
║1 ║ 1 ║ 1 ║ 2 ║ 2║
╠══╬═══╬═══╬═══╬══╣
║  ║   ║ 1 ║ 1 ║ 2║
╠══╬═══╬═══╬═══╬══╣
║  ║   ║   ║ 2 ║ l ║
╚══╩═══╩═══╩═══╩══╝

 maxVale = 2
int [] []
╔══╦═══╦═══╦═══╦══╗
║  ║ 1  ║   ║1  ║  ║
╠══╬═══╬═══╬═══╬══╣
║ 1 ║  L ║ 1  ║  2 ║  1 ║
╠══╬═══╬═══╬═══╬══╣
║  ║ R ║ 1 ║ l ║ 1║
╠══╬═══╬═══╬═══╬══╣
║  ║   ║   ║ 1 ║  ║
╚══╩═══╩═══╩═══╩══╝

 */
public class GetMaximumIlluminanceValue {

	public GetMaximumIlluminanceValue(){

	}

	public static void main(String[] args) {

		GetMaximumIlluminanceValue class1 = new GetMaximumIlluminanceValue();

		// 4 by 5
		String[][] matrix = new String[4][5];
		matrix[1][1] = "L";
		matrix[2][1] = "R";
		matrix[2][3] = "L";
		System.out.println(class1.getMaxIlluminanceValue(matrix));

	}

	public int getMaxIlluminanceValue(String [][] matrix){

		if(matrix == null)
			return 0;

		if(matrix.length == 0){
			return 0;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int maxIllumninance = 0;
		int [][] intMatrix = new int [rows][cols];

		if(rows == 0 && cols == 0){
			return 0;
		}

		for(int row = 0; row< rows; row++){
			for(int col=0; col< cols; col++){
				if(matrix[row][col] != null && matrix[row][col].equals("L") ){
					int currMax = currMaxIlluminance(row-1, col, matrix, intMatrix, maxIllumninance, rows, cols, "T");
					maxIllumninance = Math.max(currMax, maxIllumninance);

					currMax = currMaxIlluminance(row+1, col, matrix, intMatrix, maxIllumninance, rows, cols, "B");
					maxIllumninance = Math.max(currMax, maxIllumninance);

					currMax = currMaxIlluminance(row, col-1, matrix, intMatrix, maxIllumninance, rows, cols, "L");
					maxIllumninance = Math.max(currMax, maxIllumninance);

					currMax = currMaxIlluminance(row, col+1, matrix, intMatrix, maxIllumninance, rows, cols, "R");
					maxIllumninance = Math.max(currMax, maxIllumninance);
				}
			}
		}

		return maxIllumninance;
	}

	public int currMaxIlluminance(int row, int col, String [][] matrix, int [][] intMatrix, int maxValue, int maxRows, int maxCols, String direction){

		if(row < 0 || row >= maxRows || col < 0 || col >= maxCols){
			return maxValue;
		}

		if(matrix[row][col] != null && (matrix[row][col]).equals("R")){
			return maxValue;
		}

		intMatrix [row][col] = intMatrix [row][col] + 1;
		int currMax = Math.max(intMatrix [row][col], maxValue);

		int val = switch (direction) {
            case "T" -> currMaxIlluminance(row - 1, col, matrix, intMatrix, currMax, maxRows, maxCols, "T");
            case "B" -> currMaxIlluminance(row + 1, col, matrix, intMatrix, currMax, maxRows, maxCols, "B");
            case "L" -> currMaxIlluminance(row, col - 1, matrix, intMatrix, currMax, maxRows, maxCols, "L");
            case "R" -> currMaxIlluminance(row, col + 1, matrix, intMatrix, currMax, maxRows, maxCols, "R");
            default -> maxValue;
        };

        currMax = Math.max(val, currMax);
		return currMax;

	}



}
