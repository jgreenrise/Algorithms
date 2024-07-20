public class a_0088_MergeSortedArray {

    public static void main(String[] args) {

        int[] i_arr_input = {2, 0};
        int[] i_arr_input2 = {1};
        //System.out.println(merge(i_arr_input, 1, i_arr_input2, 1));
        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;
        int leftPtr = m - 1;
        int rightPtr = n - 1;

        if (m == 0) {
            for (int j = 0; j < nums1.length; j++) {
                nums1[j] = nums2[j];
            }
            //System.out.println(Arrays.toString(nums1));
            return;
        }

        while (index >= 0 && rightPtr >= 0) {

            if (leftPtr < 0) {
                for (int j = rightPtr; j >= 0; j--) {
                    nums1[index--] = nums2[rightPtr--];
                }
            } else {
                if (nums1[leftPtr] > nums2[rightPtr]) {
                    nums1[index--] = nums1[leftPtr--];
                } else {
                    nums1[index--] = nums2[rightPtr--];
                }
            }

            //System.out.println("Attenpt"+ Arrays.toString(nums1));
        }

    }


}