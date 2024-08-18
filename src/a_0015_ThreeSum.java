import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 * Input: nums = [-1,0,1,2,-1,-4], k = 0
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * 1. solution set must not contain duplicate triplets.
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * <p>
 * [-1,0,1,2,-1,-4]
 * -4,-1,-1,0,1,2
 * -4 [1, 6] =
 * -4 [1, 6], k = 4
 * -1 [2, 6] =
 * [2,6], k = 1, -1
 * {-1, 2}, -1
 * {0, 1}, -1
 * -1 already considered, skip it
 * 0, 1, 2
 * [1,2], k = 0
 **/
class a_0015_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            if (j != 0 && nums[j] == nums[j - 1]) continue;

            int left = j + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[left] + nums[right] + nums[j];
                //System.out.println("currindex: "+j+", num[j]: "+nums[j]+", LtL: "+left+", RT: "+right+", currSum: "+currSum);
                if (currSum == 0) {
                    System.out.println("\t101");
                    int currLeft = nums[left];
                    int currRight = nums[right];
                    out.add(List.of(nums[j], currLeft, currRight));
                    while (left + 1 < nums.length && currLeft == nums[left + 1]) left++;
                    while (right - 1 >= 0 && currRight
                            == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (currSum < 0) {
                    //System.out.println("\tmoving right");
                    int currLeft = nums[left];
                    while (left + 1 < nums.length && currLeft == nums[left + 1]) left++;
                    left++;
                } else {
                    //System.out.println("\tmoving left");
                    int currRight = nums[right];
                    while (right - 1 >= 0 && currRight == nums[right - 1]) right--;
                    right--;
                }
            }
        }
        return out;

    }


}