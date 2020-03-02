package Array.heap;

import java.util.Arrays;

public class MinHeapRemoveMin {

	public static void main(String[] args) {
		int[] arr_i_input = { 10,6,20,5,16,17,13,2 };
		System.out.println("Input aRRAY: "+Arrays.toString(arr_i_input));
		buildHeap(arr_i_input);
	}

	private static void buildHeap(int[] arr_i_input) {
		int []  oArr = new int [arr_i_input.length];
		for (int i = 0; i< arr_i_input.length; i++){
			oArr = buildMinHeap(arr_i_input[i], oArr, i);
		}
		System.out.println("Output array: "+Arrays.toString(oArr));

		// Remove Min
		oArr = removeMin(oArr);
		System.out.println("Output array (Remove Min): "+Arrays.toString(oArr));
	}

	private static int[] removeMin(int[] oArr) {

		int min = oArr[0];
		oArr[0] = oArr[oArr.length-1];
		oArr[oArr.length-1]=0;
		oArr = percolateDown(0, oArr);
		return oArr;
	}

	private static int[] percolateDown(int currIndex, int[] oArr) {

		if(2*currIndex+1 < oArr.length-1 && oArr[currIndex] > oArr[2*currIndex+1]){
			// Compare with left
			oArr = swap(currIndex, 2*currIndex+1, oArr);
			return percolateDown(2*currIndex+1, oArr);
		}else if (2*currIndex+2 < oArr.length-1 && oArr[currIndex] > oArr[2*currIndex+2]){
			// Compare with right
			oArr = swap(currIndex, 2*currIndex+2, oArr);
			return percolateDown(2*currIndex+2, oArr);
		}
		return oArr;
	}

	private static int[] buildMinHeap(int i, int[] oArr, int currIndex) {
		if(currIndex == 0){
			oArr[currIndex] = i;
			return oArr;
		}else{
			oArr[currIndex] = i;
			if(oArr[currIndex] < oArr[(currIndex-1)/2])
				oArr = percolateUp(currIndex, oArr);
			return oArr;
		}
	}

	private static int[] percolateUp(int currIndex, int[] oArr) {
		if(oArr[currIndex] < oArr[(currIndex-1)/2]){
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
