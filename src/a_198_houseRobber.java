public class a_198_houseRobber {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        nums[2] = nums[2] + nums[0];
        for(int j = 3; j < nums.length; j++){
            nums[j] = nums[j-2] > nums[j-3]
                    ? nums[j] + nums[j-2] :
                    nums[j] + nums[j-3];
        }

        return Math.max(nums[nums.length-1], nums[nums.length-1-1]);


    }
}
