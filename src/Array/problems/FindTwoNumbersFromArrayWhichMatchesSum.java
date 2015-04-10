package Array.problems;

import java.util.HashSet;

/**
 * http://www.careercup.com/question?id=5727163577794560
 * 
 * Given an array of random integers and a sum value, find two numbers from the
 * array that sum up to the given sum. eg. array = {2,5,3,7,9,8}; sum = 11
 * output -> 2,9
 * 
 * Implement in O(n) time complexity. Find all distinct pairs. (2,9) and (9,2)
 * are not distinct.
 * 
 * @author JatinPatel
 *
 */
public class FindTwoNumbersFromArrayWhichMatchesSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] input = new int []{10, 20, 30, 9, 21,45, 55};
		int sum = 30;
		
		printPairs(input, sum);

	}

	private static void printPairs(int[] input, int sum) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i: input) {
			set.add(i);
		}
		
		for(int j: input){
			if(set.contains(sum-j)){
				System.out.println("Pair: "+j+","+(sum-j));
			}
		}
	}


}
