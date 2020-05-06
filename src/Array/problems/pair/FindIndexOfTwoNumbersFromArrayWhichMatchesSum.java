package Array.problems.pair;

import java.util.*;

public class FindIndexOfTwoNumbersFromArrayWhichMatchesSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] input = new int []{10, 20, 30, 9, 21,45, 55};
		int target = 30;

		System.out.println(Arrays.toString(bruteForce(input, target)));
		System.out.println(Arrays.toString(usingSet(input, target)));
		System.out.println(Arrays.toString(usingHash(input, target)));

		input = new int []{3,2,4};
		target = 6;

		System.out.println(Arrays.toString(bruteForce(input, target)));
		System.out.println(Arrays.toString(usingSet(input, target)));
		System.out.println(Arrays.toString(usingHash(input, target)));

	}

	/**
	 * TC : O(N2)
	 * SC: O(1)
	 */
	public  static int[] bruteForce(int[] arr, int target) {

		int [] out = new int [2];
		boolean matchFound = false;

		for(int i =0; i< arr.length; i++){
			for(int j = i+1; j< arr.length; j++){

				if(arr[i] + arr[j] == target){
					out[0] = i;
					out[1] = j;
					matchFound = true;
					break;
				}
			}
			if(matchFound){
				break;
			}
		}
		return out;
	}

	/**
	 * TC : O(N2)
	 * SC: O(N)
	 */
	public static int[] usingSet(int[] nums, int target) {

		int [] output = new int [2];
		Set<String> set = new HashSet();

		// 1. Add elements to array
		for(int j=0;j<nums.length; j++){
			String str = String.valueOf(nums[j]);
			set.add(str);
		}

		int temp =0;
		boolean matchFound = false;
		int k = 0;
		while(!matchFound){

			/**
			 * Start from Loop 0, if no match found, start from next index
			 */

			for(int j=k;j<nums.length; j++){
				int intDiff = target - nums[j];
				String strDiff = String.valueOf(intDiff);

				/**
				 * Find index of first element
				 */
				if(set.contains(strDiff)){
					output[0] = j;
					temp = target - nums[j];
					break;
				}
			}

			/**
			 * Find index of next element
 			 */
			for(int j=0;j<nums.length; j++){
				if( j == output[0])
					continue;
				if(nums[j] == temp){
					matchFound = true;
					output[1] = j;
					break;
				}
			}

			if(matchFound){
				return output;
			}
			k++;
		}

		return output;

	}

	/**
	 * TC : O(N)
	 * SC : O(N)
	 */
	public static int[] usingHash(int[] nums, int target) {

		int [] out = new int [2];
		Map<Integer, Integer> map = new HashMap();

		for(int j=0;j<nums.length; j++){

			if(map.containsKey(target- nums[j])){
				// Match Found
				out[0]=map.get(target- nums[j]);
				out[1]=j;
				break;
			}else{
				// Add item to array
				map.put(nums[j], j);
			}

		}

		return out;

	}


}
