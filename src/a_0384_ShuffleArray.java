import java.util.Random;

public class a_0384_ShuffleArray {

    int[] original = null;
    int[] array = null;
    Random rand = new Random();

    public a_0384_ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    // [1, 2, 3]
    public int[] shuffle() {
        for (int k = array.length - 1; k >= 0; k--) {
            int randNumberIndex = rand.nextInt(k + 1); //  1
            int tmp = array[k];
            array[k] = array[randNumberIndex];
            array[randNumberIndex] = tmp;
        }
        return array;
    }

}
