package Array.problems.hIndex;

import java.util.Arrays;
import java.util.Collections;

/**
 * Daily coding problem 241
 *
 * A researcher has index h if at least h of her N papers have h citations each.
 * If there are multiple h satisfying this formula, the maximum is chosen.
 *
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 *              received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 *
 * 0 # there is 1 paper with citation 0
 * 1 # there are 4 papers have citations at least 1
 * 3 # there are 3 papers have citations at least 3
 * 5 # there are 2 papers have citations at least 5
 * 6 # there are 1 paper have citations at least 6
 *
 *
 */
public class Hindex {

    public static void main(String [] args){
        int[] citations = {2,1,3,5,6};
        System.out.println(hIndex(citations));
    }


    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        citations = reverserSort(citations);
        int len = citations.length;

        int hIndex = 0;
        for (hIndex = 0; hIndex < len; hIndex++) {
            if (hIndex + 1 > citations[hIndex]) {
                return hIndex;
            }
        }

        return hIndex;
    }

    private static int[] reverserSort(int[] citations) {
        Arrays.sort(citations);
        // Reverse the array
        int m = 0;
        int n = citations.length - 1;
        while (m < n) {
            swap(citations, m, n);
            m++;
            n--;
        }
        return citations;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
