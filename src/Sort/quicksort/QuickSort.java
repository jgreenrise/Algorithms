package Sort.quicksort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        QuickSort class1 = new QuickSort();
        //a = new int[] { 50, 40, 60, 30, 10, 20 };
        int [] a = new int[]{10, 16, 8, 12, 15, 6, 3, 9, 5};
        class1.sort(a, 0, a.length-1);

    }

    private void sort(int [] arr, int left, int right) {

        if(left < right){

            int partition = quickSort(arr, left, right);

            sort(arr, left, partition-1);   // Sort left partition
            sort(arr, partition+1, right);   // Sort right partition
        }

    }

    private int quickSort(int[] arr, final int inputLeft, final int inputRight) {

        int pivotVal = arr[inputLeft];
        int pivotIndex = inputLeft;
        int left = inputLeft;
        int right = inputRight;

        while(left < right){

            while(arr[left] <= pivotVal && left < inputRight)
                left++;
            while(arr[right] > pivotVal && right > inputLeft)
                right--;

            if(left < right){
                swap(arr, left, right);
            }else{
                if(pivotIndex != right)
                    swap(arr, pivotIndex, right);
            }

            System.out.println(Arrays.toString(arr));
        }

        return right;

    }

    private void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }


}
