import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class a_0055_JumpGame {


    /**
     *
     * 1. Iterate backwards from the second-to-last element.
     * 2. jump_reqd: Track the minimum jumps needed to reach the end.
     *     We need -1 jump to reach to the next location
     * 3. If you can jump from the current position to cover the required jumps,
     *      reset the requirement;
     *          jump_reqd = -1;
     *      otherwise,
     *          increment the requirement.
     *              jump_reqd --;
     *
     * return jump_reqd == -1
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        if(nums.length == 1)    return true;

        if(nums[0] == 0)
            return false;

        if(nums.length == 2){
            return nums[0] > 0;
        }

        int jump_req = -1;

        for(int k = nums.length-2; k >= 0; k--){
            if(nums[k] > 0){
                if(nums[k] + jump_req >= 0){
                    jump_req = -1;
                }else{
                    jump_req--;
                }
                //System.out.println("1 Jump reqd: "+jump_req);
            }else{
                jump_req--;
                //System.out.println("2 Jump reqd: "+jump_req+", k: "+k);
            }
        }

        return jump_req == -1;

    }

}
