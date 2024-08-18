/**
 * Tower of hanoi Output
 * https://www.youtube.com/watch?v=Ajy8XweC3L8
 */
public class a_0000_cci_8_6_TowerOfHanoi_MovesRequired {
    public static void main(String[] args) {
        a_0000_cci_8_6_TowerOfHanoi_MovesRequired class1 = new a_0000_cci_8_6_TowerOfHanoi_MovesRequired();
        for (int j = 1; j < 10; j++) {
            System.out.println("Number of Moves required for Disk: " + j + ", moves: " + class1.getNumberOfMoves(j));
        }
    }

    private int getNumberOfMoves(int j) {
        String source = new String();
        String auxillary = new String();
        String destination = new String();
        return towerOfHanoi(j, source, auxillary, destination);
    }

    private int towerOfHanoi(int n, String source, String auxillary, String destination) {
        if (n == 1) {
            return 1;
        }

        // Move n-1 disk from source to Aux, using Destination tower
        int countSteps = towerOfHanoi(n - 1, source, destination, auxillary);

        // Move from Source to destination
        countSteps++;

        // Move n-1 disks from AUX to Destination, using Source
        countSteps += towerOfHanoi(n - 1, auxillary, source, destination);

        return countSteps;
    }
}
