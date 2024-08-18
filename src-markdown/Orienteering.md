import java.util.ArrayList; import java.util.HashSet; import
java.util.List; import java.util.Set;

public class Orienteering {

    public static void main(String args[]){

        List<String> field = List.of("*#..#",
                ".#*#.",
                "*...*"
        );
        int k = 2;
        System.out.println(expected_length(field, k));
    }

    private static int expected_length(List<String> field, int k) {


        //To do: Handle Negative scenarious

        int totalExpectedLen = 0;

        // Create matrix
        char [][] mat = getCharMatrixFromListOfString(field);

        // Get checkpoint locations
        List<Pair> pairs = getCheckPointLocations(mat);

        for(int count=pairs.size()-1; count > 0; count--){

            Pair prev = pairs.get(count-1);
            Pair curr = pairs.get(count);
            Set<Integer> isVisited = new HashSet<>();

            int getDistanceBetweenNodes = getTotalNodesBetweenPairs(prev, curr, mat, isVisited);
            totalExpectedLen = totalExpectedLen + getDistanceBetweenNodes;
        }

        return totalExpectedLen/pairs.size();
    }

    private static int getTotalNodesBetweenPairs(Pair<Integer, Integer> from, Pair<Integer, Integer> to, char [][] mat, Set<Integer> isVisited) {
        int rows = mat.length;
        int cols = mat[0].length;
        return getTotalNodesBetweenIndexes(from.u, from.v, to.u, to.v, mat, rows, cols, isVisited);

    }

    /**
     *
     * sr x cols + sc
     * row = id / cols
     * col = id % cols
     *
     */
    private static int getTotalNodesBetweenIndexes(int fromRow, int fromCol, int toRow, int toCol, char[][] mat, int rows, int cols, Set<Integer> isVisited){

        System.out.println("From: "+fromRow +", from col: "+fromCol);

        if(fromRow == toRow && fromCol == toCol){
            return 1;
        }

        int currRecord = fromRow * cols + fromCol;
        if(isVisited.contains(currRecord)){
            return -1;
        }

        isVisited.add(fromRow * cols + fromCol);
        int currOptimalSequence = Integer.MAX_VALUE;
        if(fromRow <0 || fromRow >= rows || fromCol <0 || fromCol >= cols || mat[fromRow][fromCol] == '#'){
            return -1;
        }



        int left = getTotalNodesBetweenIndexes(fromRow, fromCol-1, toRow, toCol, mat, rows, cols, isVisited);
        if(left == -1){
            // Skip it
        }else{
            currOptimalSequence = left + 1;
        }

        int top =  getTotalNodesBetweenIndexes(fromRow-1, fromCol, toRow, toCol, mat, rows, cols, isVisited);
        if(top == -1){
            // Skip it
        }else{
            currOptimalSequence = Math.min(currOptimalSequence, top + 1);
        }

        int right =  getTotalNodesBetweenIndexes(fromRow, fromCol+1, toRow, toCol, mat, rows, cols, isVisited);
        if(right == -1){
            // Skip it
        }else{
            currOptimalSequence = Math.min(currOptimalSequence, right + 1);
        }

        int bottom = getTotalNodesBetweenIndexes(fromRow+1, fromCol, toRow, toCol, mat, rows, cols, isVisited);
        if(bottom == -1){
            // Skip it
        }else{
            currOptimalSequence = Math.min(currOptimalSequence, bottom + 1);
        }

        return currOptimalSequence == Integer.MAX_VALUE ? 0 :  currOptimalSequence;
    }

    private static List<Pair> getCheckPointLocations(char[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        List<Pair> pairs = new ArrayList<>();

        for(int row=0; row< rows; row++){
            for (int col = 0; col< cols; col++){
                if(mat[row][col] == '*'){
                    pairs.add(new Pair<Integer, Integer>(row, col));
                }
            }
        }

        return pairs;
    }

    private static char[][] getCharMatrixFromListOfString(List<String> field) {
        int cols = field.get(0).toCharArray().length;
        int rows = field.size();
        char [][] mat = new char[rows][cols];
        int rowCount = 0;
        for (String row: field){
            mat[rowCount++] = row.toCharArray();
        }
        return mat;
    }

    static class Pair<U,V>{
        U u;
        V v;
        public Pair(U u, V v){
            this.u = u;
            this.v = v;
        }
    }

}
