package Array.problems.hIndex;

import java.util.Arrays;

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
public class HindexUsingBucketSort {

    public static void main(String [] args){
        //int[] citations = {2,1,3,5,6};
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }


    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Step 1: Accmulate the number of citations for each bucket
        for (int i = 0; i < n; i++) {
            if (citations[i] <= n) {
                buckets[citations[i]]++;
            } else {
                buckets[n]++;
            }

        }

        // Step 2: iterate the citations from right to left.
        int numPapers = 0;
        for (int i = n; i >= 0; i--) {
            numPapers += buckets[i];
            if (numPapers >= i) {
                return i;
            }
        }

        return 0;
    }
}
