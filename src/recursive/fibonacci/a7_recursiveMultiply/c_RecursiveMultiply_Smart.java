package recursive.fibonacci.a7_recursiveMultiply;

import java.util.HashMap;

// TC: O(lgS): S smaller of two numbers
public class c_RecursiveMultiply_Smart {

    public static void main(String[] args) {

        c_RecursiveMultiply_Smart class1 = new c_RecursiveMultiply_Smart();
        int [][] numbers = {{2,3},{5,4}, {20, 4}, {20,20}, {4, 20}, {100, 1}, {100,200} ,{17, 23}};
        //int [][] numbers = {{17, 23}};

        for (int [] nums : numbers) {
            System.out.println("Multiply: "+nums[0]+","+nums[1]+" > " + class1.minProduct1(nums[0], nums[1], new HashMap<Integer, Integer>()));
        }

    }

    public int minProduct1(int left, int right, HashMap<Integer, Integer> map) {

        if(map.containsKey(left*right)){
            return map.get(left*right);
        }

        int smaller = left > right ? right : left;
        int bigger = right > left ? right : left;

        return recursiveMinProduct(smaller, bigger, map);
    }

    public int recursiveMinProduct(int left, int right, HashMap<Integer, Integer> map){
        if(left == 1){
            return right;
        }

        int half = left >> 1;
        int leftSum = minProduct1(half, right, map);
        int rightSum = leftSum;

        if(left % 2 == 1){
            rightSum = leftSum + right;
        }

        map.put(left*right, leftSum+rightSum);
        return leftSum + rightSum;

    }

}
