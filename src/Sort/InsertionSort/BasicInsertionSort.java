package Sort.InsertionSort;

import java.util.Arrays;

public class BasicInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Input
		//int[] A = { 10, 2, 3, 4, 1, 5 };
		int[] A = { 9, 7, 1, 4, 1, 5, 1002, 987, 4, 6 };
		int key = 0;
		int i = 0;

		for (int j = 1; j < A.length; j++) {
			key = A[j]; 
			i = j - 1; 

			while (i > -1 && A[i] > key) {
				A[i + 1] = A[i];
				i = i - 1;
			}

			A[i + 1] = key;
		}

		System.out.println(Arrays.toString(A));

	}
}
