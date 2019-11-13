package Array.problems;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
class ZeroMatrixTest {

    @Parameterized.Parameter public int [][] input;
    @Parameterized.Parameter(1) public int [][] output;
    @Parameterized.Parameter(2) public int rows;
    @Parameterized.Parameter(3) public int columns;


    @Parameterized.Parameters(name = "{index}: fib({0})={1}, {2}, {3}")
    public static Iterable<Object[]> data() {
         int [][] input1 = {{0, 1, 2, 0},{3, 4, 5, 2}, {1, 3, 1, 5}};
         int [][] output1 = {{0, 0, 0, 0},{0, 4, 5, 2}, {0, 3, 1, 5}};

        int [][] input2 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int [][] output2 = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};

        int [] [] input3 = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        int [] [] output3 = new int[][]{{-9,0,0,0}, {0,4,5,0}, {0,3,1,0}};

        return Arrays.asList(new Object [] []
                {
                        {input1, output1, 3, 4},
                        {input2, output2, 3, 3},
                        {input3, output3, 3, 4}
                }
        );
    }

    @Test
    public void mark1stRowIndexAndIstColumnIndexZero() {

        assertTrue(equal(output, ZeroMatrix.mark1stRowIndexAndIstColumnIndexZero(input, rows, columns)));

    }

    public static boolean equal(final int[][] arr1, final int[][] arr2) {

        if (arr1 == null)
            return (arr2 == null);

        if (arr2 == null)
            return false;

        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

}