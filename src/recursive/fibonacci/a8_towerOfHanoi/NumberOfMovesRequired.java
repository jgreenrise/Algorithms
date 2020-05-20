package recursive.fibonacci.a8_towerOfHanoi;

/**
 * Tower of hanoi Output
 * https://www.youtube.com/watch?v=Ajy8XweC3L8
 */
public class NumberOfMovesRequired {

    public static void main(String[] args) {

        NumberOfMovesRequired class1 = new NumberOfMovesRequired();

        for(int j = 1; j < 10; j++){
            System.out.println("Number of Moves required for Disk: "+j+", moves: "+class1.getNumberOfMoves(j));
        }

    }

    private int getNumberOfMoves(int j) {
        String source = new String();
        String auxillary = new String();
        String destination = new String();
        return towerOfHanoi(j,source, auxillary, destination);
    }

    private int towerOfHanoi(int n, String source, String auxillary, String destination) {
        if(n == 1){
            return 1;
        }

        // Move n-1 disk from source to Aux
        int countSteps = towerOfHanoi(n-1, source, destination, auxillary);

        // Move from Source to destination
        countSteps++;

        // Move n-1 disks from AUX to Source
        countSteps += towerOfHanoi(n-1, auxillary, destination, source);

        return countSteps;
    }
}
