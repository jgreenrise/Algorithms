public class a_0055_JumpGame {

    /**
     * 2   3   1   1   4
     * 0   1   2   3   4
     * -1    -1    -1    -1    -1    jumpRequired
     * <p>
     * 3   2   1   0   4
     * 0   1   2   3   4
     * -5  -4  -3  -2  -1  jumpRequired
     * <p>
     * <p>
     * 6   0   0   0   0   0   7
     * 0   1   2   3   4   5   6
     * -1   -6  -5  -4  -3  -2  -1
     */

    public boolean canJump(int[] nums) {

        int jumpRequired = -1;
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] + jumpRequired >= 0) {
                jumpRequired = -1;
            } else {
                jumpRequired--;
            }
        }
        return jumpRequired == -1 ? true : false;

    }

}
