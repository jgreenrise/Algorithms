import java.util.Arrays;

public class a_1385_FindDistanceBetweenArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int ans = 0;
        Arrays.sort(arr2);

        for (int j = 0; j < arr1.length; j++) {
            if (!inRange(arr2, arr1[j] - d, arr1[j] + d)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean inRange(int[] arr, int min, int max) {
        System.out.println("In range Left: min: " + min + ", max: " + max);
        int mid = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right && left < arr.length) {

            mid = left + (right - left) / 2;
            int val = arr[mid];
            if (min <= val && val <= max) {
                return true;
            } else if (val > max) {
                if (left == right) {
                    return false;
                }
                right = mid - 1;
            } else {
                if (left == right) {
                    return false;
                }
                left = mid + 1;
            }
            System.out.println();
        }

        return false;
    }
}
