package Array.problems;

import java.util.*;

public class PrisonCellAfterNDays {

    public static void main(String args[]) {

        PrisonCellAfterNDays sandbox = new PrisonCellAfterNDays();
/*        System.out.println(Arrays.toString(sandbox.prisonAfterNDays(new int[]{0, 1, 0, 1}, 5)));
        System.out.println(Arrays.toString(sandbox.prisonAfterNDays(new int[]{0, 1, 0, 1}, 7)));
        System.out.println(Arrays.toString(sandbox.prisonAfterNDays(new int[]{0, 1, 0, 1}, 9)));
        System.out.println(Arrays.toString(sandbox.prisonAfterNDays(new int[]{0, 1, 0, 1}, 8)));
        System.out.println(Arrays.toString(sandbox.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));*/
        System.out.println(Arrays.toString(sandbox.prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        Set<String> set = new HashSet<>();
        boolean matchFound = false;
        int [] nextDay = null;
        int blockSize = 0;

        for (int day = 0; day < N; day++){
            nextDay = getNextDay(cells);
            String strNextDay = Arrays.toString(nextDay);

            if(set.contains(strNextDay)){
                // Pattern match found.
                matchFound = true;

                break;
            }else{
                // Add to set
                set.add(strNextDay);

                // Update input cells
                cells = nextDay;

                System.out.println(Arrays.toString(nextDay));

                // Update block size
                blockSize++;
            }
        }

        if(matchFound){
            int mod = N % blockSize;
            for (int i = 0; i < mod; i++) {
                cells = getNextDay(cells);
            }
        }


        return cells;

    }

    private int[] getNextDay(int[] cells) {
        int [] out = new int[cells.length];

        for (int cell = 1; cell < cells.length-1; cell++){
            if(cells[cell-1] == cells[cell+1]){
                out[cell] = 1;
            }
        }
        return out;
    }

}
