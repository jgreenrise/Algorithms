package recursive.fibonacci;

import java.util.HashSet;
import java.util.Set;

public class a11_paintfill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4 by 4
		int[][] matrix = { {0,0,0}, {0,1,1} };

		a11_paintfill class1 = new a11_paintfill();
		System.out.println("\n Input"+ class1.floodFill(matrix, 1,1, 1));

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int currColor = image[sr][sc];
		int totRows = image.length;
		int totCols = image[0].length;
		Set<String> set = new HashSet<>();
		dfs(currColor, image, sr, sc, newColor, totRows, totCols, set);
		return image;

	}

	public boolean dfs(int currColor, int[][] image, int sr, int sc, int newColor, int totRows, int totCols, Set<String> set){

		if(sr < 0 || sc < 0 || sr >= totRows || sc >= totCols){
			return false;
		}

		String tmp = String.valueOf(sr)+","+String.valueOf(sc);
		if(image[sr][sc] == currColor && !set.contains(tmp)){
			image[sr][sc] = newColor;
			set.add(tmp);
			dfs(currColor, image, sr-1, sc, newColor, totRows, totCols, set); // TOP
			dfs(currColor, image, sr, sc-1, newColor, totRows, totCols, set); // LEFT
			dfs(currColor, image, sr+1, sc, newColor, totRows, totCols, set); // BOTTOM
			dfs(currColor, image, sr, sc+1, newColor, totRows, totCols, set); // RIGHT
		}

		return true;

	}

}
