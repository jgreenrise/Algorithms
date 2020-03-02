package Array.heap;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr_i_input = { 8,4,7,1,3,5 };
		System.out.println("Input "+Arrays.toString(arr_i_input));
		buildHeap(arr_i_input);
	}

	private static void buildHeap(int[] arr_i_input) {
		int []  oArr = new int [arr_i_input.length];
		for (int i = 0; i< arr_i_input.length; i++){
			oArr = buildMaxHeap(arr_i_input[i], oArr, i);
		}
		System.out.println("Output: "+Arrays.toString(oArr));

		// Heapsort
		oArr = heapSort(oArr);
		System.out.println("Heap sort: "+Arrays.toString(oArr));
	}

	private static int[] heapSort(int[] oArr) {

		for (int i = 0; i < oArr.length; i++) {
			// Swap between Root node and Last node
			swap(0, oArr.length-1-i, oArr);

			// Heapify from start to last node
			oArr = heapify(0, oArr.length-2-i, oArr);
		}

		return oArr;
	}

	private static int[] heapify(int startIndex, int lastIndex, int[] oArr) {
		int findIndexOfLargestNode = fetchIndexOfLargestNode(startIndex, oArr, lastIndex);

		if(findIndexOfLargestNode == startIndex ||
				// No child node exist
			 	findIndexOfLargestNode == -1)
		{
			// no swapping is required
			return oArr;
		}else{
			// Swap node <-> child
			oArr = swap(startIndex, findIndexOfLargestNode, oArr);

			// heapify from the swapped node index
			return heapify(findIndexOfLargestNode, lastIndex, oArr);
		}
	}

	/**
	 * Check if node or its children node is bigger
	 */
	private static int fetchIndexOfLargestNode(int startIndex, int[] oArr, int lastIndex) {
		int leftChild = 2* startIndex+1;
		int rightChild = 2* startIndex+2;

		if(leftChild <= lastIndex && rightChild <= lastIndex){
			// Both right and left child exist
			int indexBiggestChild = oArr[leftChild] > oArr[rightChild] ? leftChild : rightChild;
			return oArr[indexBiggestChild] > oArr[startIndex] ? indexBiggestChild : startIndex;
		}else if(leftChild > lastIndex){
			// Both right and left does not exist
			return -1;
		}else if(leftChild <= lastIndex && rightChild > lastIndex){
			// Only left child exist
			return oArr[leftChild] > oArr[startIndex] ? leftChild : startIndex;
		}
		return startIndex;
	}

	private static int[] buildMaxHeap(int i, int[] oArr, int currIndex) {
		if(currIndex == 0){
			oArr[currIndex] = i;
			return oArr;
		}else{
			oArr[currIndex] = i;
			if(oArr[currIndex] > oArr[(currIndex-1)/2])
				oArr = percolateUp(currIndex, oArr);
			return oArr;
		}
	}

	private static int[] percolateUp(int currIndex, int[] oArr) {
		if(oArr[currIndex] > oArr[(currIndex-1)/2]){
			oArr = swap(currIndex, (currIndex-1)/2, oArr);
			if ((currIndex-1)/2 == 0) return oArr;
			else percolateUp((currIndex-1)/2, oArr);
		}
		return oArr;
	}

	private static int[] swap(int currIndex, int parentIndex, int[] oArr) {
		int tmp = oArr[currIndex];
		oArr[currIndex] = oArr[parentIndex];
		oArr[parentIndex] = tmp;
		return oArr;
	}


}
