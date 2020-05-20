package recursive.fibonacci.a8_towerOfHanoi;

import java.util.Stack;

/**
 * Tower of hanoi Output
 * https://www.youtube.com/watch?v=Ajy8XweC3L8
 */
public class TOHUsingStack {

    public static void main(String[] args) {

        TOHUsingStack class1 = new TOHUsingStack();

        //for(int j = 2; j < 10; j++){
        for(int j = 2; j < 10; j++){
            System.out.println("Number of Moves required for Disk: "+j+", moves: "+class1.getNumberOfMoves(j));
        }

    }

    private Stack<Integer> getNumberOfMoves(int towers) {
        Stack<Integer> source = new Stack<Integer>();
        for (int i = towers; i > 0; i--) {
            source.add(i*10);
        }
        Stack<Integer> auxillary = new Stack<Integer>();
        Stack<Integer> destination = new Stack<Integer>();
        return towerOfHanoi(towers,source, auxillary, destination);
    }

    private Stack<Integer> towerOfHanoi(int n, Stack<Integer> source, Stack<Integer> auxillary, Stack<Integer> destination) {
        if(n == 1){
            destination.add(source.pop());
            return destination;
        }

        // Move n-1 disk from source to Aux
        towerOfHanoi(n-1, source, destination, auxillary);

        // Move from Source to destination
        destination.add(source.pop());

        // Move n-1 disks from AUX to Destination
        towerOfHanoi(n-1, auxillary, source, destination);

        return destination;
    }
}
