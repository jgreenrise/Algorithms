package Array.heap;

import java.util.Arrays;

public class MinHeap {

	public static void main(String[] args) {

		int[] arr_i_input = { 10,6,20,5,16,17,13,2 };
		System.out.println(Arrays.toString(arr_i_input));
		buildHeap(arr_i_input);
	}

	private static void buildHeap(int[] arr_i_input) {

		int []  outArr = new int [arr_i_input.length];
		for (int i = 0; i< arr_i_input.length; i++){
			outArr = buildMinHeap(arr_i_input[i], outArr, i);
		}
		System.out.println(Arrays.toString(outArr));
	}

	private static int[] buildMinHeap(int inArrVal, int[] oArr, int currIndex) {
		if(currIndex == 0){
			oArr[currIndex] = inArrVal;
			return oArr;
		}else{
			oArr[currIndex] = inArrVal;
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
