package recursive.fibonacci.a3_robotIngrid;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class a3_RobotInGrid_getPathsInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4 by 4
		int[][] matrix = new int [4][3];
		boolean [][] offlimits = new boolean [4][3];
		offlimits[1][1] = true;
		offlimits[2][1] = true;

		a3_RobotInGrid_getPathsInList robot = new a3_RobotInGrid_getPathsInList();
		System.out.println("Rec: "+robot.getWays(matrix, offlimits)+", \nMmeo: "+robot.getWaysMmeo(matrix, offlimits));

	}

	private HashSet<Point> getWaysMmeo(int[][] mat, boolean[][] offlimit) {
		int totalRows = mat.length;
		int totalCols = mat[0].length;
		var set = new HashSet<Point>();

		if(getTotalWaysMmeo(mat,offlimit,0,0,totalRows,totalCols, set)){
			return set;
		}

		return null;
	}

	private boolean getTotalWaysMmeo(int[][] mat, boolean[][] offlimits, int currRow, int currCol, int totalRows, int totalCols, HashSet<Point> set) {

		if(set.contains(new Point(currRow, currCol))){
			return true;
		}

		if(currCol+1 < totalCols && !offlimits[currRow][currCol+1]){
			if(currCol+1 == totalCols-1 && currRow == totalRows-1){
				set.add(new Point(currRow, currCol+1));
				return true;
			}else{
				if(getTotalWaysMmeo(mat, offlimits, currRow, currCol+1, totalRows, totalCols, set)){
					set.add(new Point(currRow, currCol+1));
				}
			}
		}

		if(currRow+1 < totalRows && !offlimits[currRow+1][currCol]){
			if(currCol == totalCols-1 && currRow+1 == totalRows-1){
				set.add(new Point(currRow+1, currCol));
				return true;
			}else {
				if(getTotalWaysMmeo(mat, offlimits, currRow + 1, currCol, totalRows, totalCols, set)){
					set.add(new Point(currRow+1, currCol));
				}
			}
		}

		return !set.isEmpty();
	}


	public ArrayList<Point> getWays(int [][]mat, boolean [][]offlimit){
		int totalRows = mat.length;
		int totalCols = mat[0].length;
		var points = new ArrayList<Point>();
		if(getWaysRec(mat,offlimit,0,0,totalRows,totalCols, points)){
			return points;
		}
		return null;
	}

	public boolean getWaysRec(int[][] mat, boolean[][] offlimits, int currRow, int currCol, int totalRows, int totalCols, ArrayList<Point> points){

		if(currCol+1 < totalCols && !offlimits[currRow][currCol+1]){
			if(currCol+1 == totalCols-1 && currRow == totalRows-1){
				points.add(new Point(currRow, currCol+1));
				return true;
			}else{
				if(getWaysRec(mat, offlimits, currRow, currCol+1, totalRows, totalCols, points))
					points.add(new Point(currRow, currCol+1));
			}
		}

		if(currRow+1 < totalRows && !offlimits[currRow+1][currCol]){
			if(currCol == totalCols-1 && currRow+1 == totalRows-1){
				points.add(new Point(currRow+1, currCol));
				return true;
			}else {
				if(getWaysRec(mat, offlimits, currRow + 1, currCol, totalRows, totalCols, points))
					points.add(new Point(currRow+1, currCol));
			}
		}

		return true;

	}

}
