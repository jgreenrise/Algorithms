package Array.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

	public static void main(String[] args) {

		int[] i_arr_input = { 2, 0 };
		int[] i_arr_input2 = { 1 };
		//System.out.println(merge(i_arr_input, 1, i_arr_input2, 1));
		System.out.println(Arrays.toString(merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3)));
	}


	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

		if(m == 0){
			nums1[m] = nums2[n-1];
			System.out.println(Arrays.toString(nums1));
			return nums1;
		}

		/// nums1 : 1 2 3 0 0 0
		/// nums2 : 2 5 6

		int counter = nums1.length - 1; //5
		m = m-1; //2
		n = n-1; //2

		while(m > -1 || n > -1){

			if(n < 0){
				break;
			}

			if(m < 0){
				nums1[counter] = nums2[n];
				counter--;
				n--;
				continue;
			}

			if(nums2[n] >= nums1[m]){
				nums1[counter] = nums2[n];
				counter--;
				n--;
			}else if(nums1[m] > nums2[n]){
				nums1[counter] = nums1[m];
				counter--;
				m--;
			}


		}

		return nums1;

	}


}