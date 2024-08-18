package Array.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		
		int [] input = new int[] { 1,1,2, };
		
		// TODO Auto-generated method stub
		System.out.println(removeDups(input));
		
	}

	public static int removeDups(int[] nums) {

		int prevVal = nums[0];
		int nextOutIndex = 1;

		for(int j = 1; j < nums.length; j++){
			if(nums[j] == prevVal){
				// Ignore
			}else{
				prevVal = nums[j];
				nums[nextOutIndex++] = prevVal;
			}
		}

		return nextOutIndex;

	}

}
