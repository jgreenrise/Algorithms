import java.util.Arrays;

public class a_1385_FindDistanceBetweenArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int dist = 0;
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (!inRange(arr2, arr1[i] - d, arr1[i] + d)) {
                dist++;
            }
        }
        return dist;
    }

    public boolean inRange(int[] nums, int min, int max) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= min && nums[mid] <= max) {
                return true;
            }

            if (left == right) {
                return false;
            } else {
                if (nums[mid] > max) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}
