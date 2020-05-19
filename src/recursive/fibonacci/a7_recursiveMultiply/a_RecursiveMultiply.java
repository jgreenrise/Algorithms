package recursive.fibonacci.a7_recursiveMultiply;

public class a_RecursiveMultiply {

    public static void main(String[] args) {

        a_RecursiveMultiply class1 = new a_RecursiveMultiply();

        for (int i = 0; i < 10; i++) {
            System.out.println(i+" i "+ (i >> 1));
        }
        System.out.println(5 >> 1);
        System.out.println(5 >> 1);

        int [][] numbers = {{100,200}};
        //int [][] numbers = {{2,3},{5,4}, {20, 4}, {20,20}, {4, 20}, {100, 1}, {100,200}};

        for (int [] nums : numbers) {
            System.out.println("Multiply: "+nums[0]+","+nums[1]+" > " + class1.multiplyUsingbitoperation(nums[0], nums[1]));
        }

    }

    public int multiplyUsingbitoperation(int int1, int int2) {
        int [] left = getBinaryIntArray(int1);
        int [] right = getBinaryIntArray(int2);
        int [] output = multiplyUsingbitoperation(left, right, right.length-1, 0, null);;
        return Integer.parseInt(convertIntArrToString(output), 2);

    }

    public int [] multiplyUsingbitoperation(int [] left, int [] right, int rightIndex, int zerosToAdd, int [] currentTot){

        if(rightIndex < 0){
            return currentTot;
        }

        int rightVal = right[rightIndex];
        int [] output = new int [zerosToAdd+left.length];

        for(int j = 0; j< left.length; j++){
            if(rightVal == 0 || left [j] == 0){
                output[j] = 0;
            }
            else{
                output[j] = 1;
            }
        }

        return multiplyUsingbitoperation(left, right, rightIndex-1, zerosToAdd+1, sum(currentTot, output));
    }

    // Right len is always bigger than left len
    public int [] sum(int [] left, int [] right){

        if(left == null){
            return right;
        }

        StringBuilder sbr = new StringBuilder();
        int carryOver = 0;
        int sum = 0;

        int leftLen = left.length-1;
        int rightLen = right.length-1;

        while(leftLen >= 0 || rightLen >= 0){
            sum = 0;

            if(rightLen >= 0 && right[rightLen] == 1)
                sum++;

            if(leftLen>=0 && left[leftLen] == 1)
                sum++;

            sum += carryOver;

            if(sum >=2){
                sbr.insert(0, 0);
                carryOver = 1;
            }else{
                sbr.insert(0, sum);
                carryOver = 0;
            }

            leftLen--;
            rightLen--;

        }

        if(carryOver == 1){
            sbr.insert(0, sum);
        }

        return sbrToArrays(sbr);

    }

    public int [] sbrToArrays(StringBuilder val){

        String temp = val.toString();
        int[] ints = new int[temp.length()];

        for (int i=0; i < temp.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }

        return ints;
    }

    public int [] getBinaryIntArray(int val){

        String temp = Integer.toBinaryString(val);

        int[] ints = new int[temp.length()];
        for (int i=0; i < temp.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }

        return ints;
    }

    public String convertIntArrToString(int [] nums){

        StringBuilder sbr = new StringBuilder();

        for (int i = 0 ; i< nums.length; i++) {
            sbr.append(nums[i]);
        }

        return sbr.toString();

    }
}
