package Array.heap;

import java.util.Arrays;

/**
 * https://www.slideshare.net/geheri12345/maxheappptx
 */
public class MaxHeap2023 {

	public static void main(String[] args) {
		//int[] arr_i_input = { 1,4,7,3,8,5 };
		int [] arr_i_input = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
		System.out.println(Arrays.toString(arr_i_input));
		arr_i_input = buildHeap(arr_i_input);	
		System.out.println(Arrays.toString(arr_i_input));
	}

	private static int[] buildHeap(int[] nums) {

		// Step 1: Navigate to Last Non Leaf Node 
		int lastNonLeafIndex = nums.length/2 - 1;

		// Step 2: (We need to heapfiy all the non leaf nodes, loop from last node to root node)
		// Loop from last Non Leaf Index to Root index
		for(int j = lastNonLeafIndex; j > -1 ; j--){
			nums = heapify(nums, j);
		}
		return nums;
	}
		

	// Step 3: Heapfiy at index
	// 3.0 Compare value at curr index with Child Nodes
	// 3.1: If val[currIndex] < val [childnode]
	//			swap[currIndex, childNode]
	//			newChildIndex = childNodeIndex			
	// 3.1.1	heapify(arr, newChildIndex)			
	// 3.2	Else
	//			Break;
	//
	private static int[] heapify(int[] nums, int currIndex) {

		int leftIndex = 2*currIndex + 1;
		int rightIndex = 2*currIndex + 2;
		boolean isLeftIndexLarger = false;

		if(leftIndex < nums.length && rightIndex < nums.length)
		{
			// Both the child nodes exists
			if(nums[leftIndex] >= nums[rightIndex]){
				isLeftIndexLarger = true;
			}else{
				isLeftIndexLarger = false;
			}
		}else if(leftIndex < nums.length && rightIndex >= nums.length){
			// Only left child exists
			isLeftIndexLarger = true;
		}else{
			return nums;
		}

		if(isLeftIndexLarger){
			if(nums[currIndex] < nums[leftIndex]){
				// Swap currNode with leftNode
				nums = swap(currIndex, leftIndex, nums);
				// Heapfify at the new child index
				nums = heapify(nums, leftIndex);
			}
		}else{
			if(nums[currIndex] < nums[rightIndex]){
				// Swap currNode with RighNode
				nums = swap(currIndex, rightIndex, nums);
				// Heapfify at the new child index
				nums = heapify(nums, rightIndex);
			}
		}

		return nums;
	}

	private static int[] swap(int currIndex, int childIndex, int[] nums) {
		int tmp = nums[currIndex];
		nums[currIndex] = nums[childIndex];
		nums[childIndex] = tmp;
		return nums;
	}
}