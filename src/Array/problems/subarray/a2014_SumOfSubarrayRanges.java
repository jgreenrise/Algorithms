package Array.problems.subarray;

/**
 * https://leetcode.com/problems/sum-of-subarray-ranges/
 */
public class a2014_SumOfSubarrayRanges {

    public static void main(String[] args) {

        a2014_SumOfSubarrayRanges class1 = new a2014_SumOfSubarrayRanges();
        System.out.printf("Sub array: " + class1.subArrayRanges(new int[]{2,7,5,0,9,3}));

    }

    public long subArrayRanges(int[] nums) {

        int out = 0;
        for(int j =nums.length - 1; j >= 0; j--){
            out = out + method2(j, nums);
        }
        return out;

    }

    // 5, arr
    public int method2(int endIndex, int [] nums){

        // Min Max at curr index
        int out = nums[endIndex];
        int [] minMaxNextIndex = {nums[endIndex], nums[endIndex]};

        int min = 0;
        int max = 0;
        int diff = 0;

        for(int k = endIndex - 1; k >= 0; k --){
            min = Math.min(minMaxNextIndex[0], nums[k]);
            max = Math.max(minMaxNextIndex[1], nums[k]);
            System.out.println("Diff at index: "+k+" endindex"+endIndex);
            diff = max - min;
            out = out + diff;
            minMaxNextIndex[0] = min;
            minMaxNextIndex[1] = max;
        }

        return out;

    }



}