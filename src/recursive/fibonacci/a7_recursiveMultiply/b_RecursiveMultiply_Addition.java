package recursive.fibonacci.a7_recursiveMultiply;

public class b_RecursiveMultiply_Addition {

    public static void main(String[] args) {

        b_RecursiveMultiply_Addition class1 = new b_RecursiveMultiply_Addition();
        int [][] numbers = {{2,3},{5,4}, {20, 4}, {20,20}, {4, 20}, {100, 1}, {100,200} ,{17, 23}};

        for (int [] nums : numbers) {
            System.out.println("Multiply: "+nums[0]+","+nums[1]+" > " + class1.minProduct1(nums[0], nums[1]));
        }

    }

    public int minProduct1(int left, int right) {

        int smaller = left > right ? right : left;
        int bigger = right > left ? right : left;

        return recursiveMinProduct(smaller, bigger);
    }

    public int recursiveMinProduct(int left, int right){
        if(left == 1){
            return right;
        }

        int half = left >> 1;
        int leftSum = minProduct1(half, right);
        int rightSum = leftSum;

        if(left % 2 == 1){
            rightSum = minProduct1(left - half, right);
        }
        return leftSum + rightSum;

    }

}
