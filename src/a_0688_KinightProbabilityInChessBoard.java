import java.util.HashMap;
import java.util.Map;

public class a_0688_KinightProbabilityInChessBoard {

    public double knightProbability(int n, int k, int row, int column) {
        Map<String, Double> map = new HashMap<>();
        return recursivelySolve(n, k, row, column, map);
    }

    public double recursivelySolve(int n, int k, int row, int col, Map<String, Double> map) {
        if (k < 0) {
            return 1;
        } else if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0;
        } else {
            String key = k + "," + row + "," + col;
            if (map.containsKey(key)) {
                return map.get(key);
            }

            int[] arrRows = {-2, -2, 2, 2, -1, -1, 1, 1};
            int[] arrCols = {-1, 1, -1, 1, -2, 2, -2, 2};
            double output = 0;
            for (int d = 0; d < 8; d++) {
                output += (1.0 / 8) * recursivelySolve(n, k - 1, row + arrRows[d], col + arrCols[d], map);
            }
            map.put(key, output);
            return output;
        }
    }

}