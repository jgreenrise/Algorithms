package recursive.fibonacci.a12_coins;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class a_coins_recursive {

    public static void main(String[] args) {

        a_coins_recursive class1 = new a_coins_recursive();
        System.out.println("Coins: "+class1.change(5, new int []{1,2,5}));

    }

    public int change(int amount, int[] coins) {
        return coins(amount, coins);
    }

    public int coins(int num, int[] coins) {
        Set<String> set = new HashSet();
        calculateCoins(set, num, 0, "", coins);
        set.forEach(System.out::println);
        return set.size();
    }

    public boolean calculateCoins(Set<String> output, int expectedSum, int currSum, String currSumStr, int[] coins) {

        if (currSum > expectedSum) {
            return false;
        }

        if (currSum == expectedSum) {

            char [] chars = currSumStr.toCharArray();
            Arrays.sort(chars);
            output.add(String.copyValueOf(chars));

            return true;
        }

        for (int j = 0; j < coins.length; j++) {
            calculateCoins(output, expectedSum, currSum + coins[j], currSumStr + String.valueOf(coins[j]), coins);
        }

        return true;

    }
}
