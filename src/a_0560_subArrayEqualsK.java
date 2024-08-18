public class a_0560_subArrayEqualsK {

    public static void main(String[] args) {

        a_0560_subArrayEqualsK class1 = new a_0560_subArrayEqualsK();

        //int[] arr_i_input = {10, 20, -20, 40, 30, 10, 10, 10, 10};
        //int[] arr_i_input = {-1, -2};
        //int[] arr_i_input = {5,7};
        //int [] arr_i_input = {-1,-1,1};
        int [] arr_i_input = {0,0};

        System.out.printf("Sub array: " + class1.subarraySum(arr_i_input, 0));
        //System.out.printf("Sub array: " + class1.combinationSum(new int[]{2,3,6,7}, 7));
        //System.out.printf("Sub array: " + class1.combinationSum(new int[]{2,3,5}, 8));
        //System.out.printf("Sub array: " + class1.combinationSum(new int[]{2,7, 6, 5}, 16));

    }

    public int subarraySum(int[] nums, int k) {

        if(nums.length == 1) return nums[0] == k ? 1 : 0;
        int [] arr_i_input = {-1,-1,1};

        int counter = 0;
        int [] prefix_sum = new int [nums.length];
        prefix_sum[0] = nums[0];

        for(int j = 1; j < nums.length; j++){
            prefix_sum[j] = prefix_sum[j-1] + nums[j];
            if(prefix_sum[j] == k){
                counter++;
            }
        }
        System.out.println("Counter "+String.valueOf(counter));

        for(int j = 0; j < nums.length; j++){
            for(int l = j+1; l < nums.length; l++){
                if((prefix_sum[l] - prefix_sum[j]) == k){
                    counter++;
                }
            }
        }

        System.out.println("Final out: "+counter);
        return counter;

    }


}