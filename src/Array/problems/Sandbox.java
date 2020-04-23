package Array.problems;

public class Sandbox {

    public static void main(String args[]) {

        int[] i_arr_input = {5, 1, 2, 7, 3, 4};
        int k = 3;
        System.out.println(splitArray(i_arr_input, k));
    }

    public static int splitArray(int[] nums, int m) {

        int N = nums.length;
        int[] k = new int[m];
        int diff = 0;
        int max = 0;
        int min = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < N - m +1; i++) {
            k[m-3] = nums[i] + k[m-3];

            k[m-2] = 0;
            for (int j = i + 1; j < N - 1; j++) {
                k[m-2] = nums[j] + k[m-2];

                k[m-1] = 0;
                for (int l = j + 1; l < N; l++) {
                    k[m-1] = nums[l] + k[m-1];
                }

                max = k[0];
                min = k[0];
                for (int o = 1; o < k.length; o++) {
                    max = Math.max(max, k[o]);
                    min = Math.min(min, k[o]);
                }


                if(diff == 0){
                    diff = max - min;
                    str.append(k[0] +" > "+ k[1] +" > "+ k[2]);
                }else if (diff >= (max - min)) {
                    str = new StringBuilder();
                    str.append(k[0] +" > "+ k[1] +" > "+ k[2]);
                    diff = max - min;
                }

                System.out.println("Max Min"+(max-min));
            }
        }

        System.out.println("String output: "+str);

        return diff;


    }

}
