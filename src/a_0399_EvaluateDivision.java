import java.util.*;

public class a_0399_EvaluateDivision {

    public static void main(String[] args) {
        a_0399_EvaluateDivision class1 = new a_0399_EvaluateDivision();
        double[] values = {2.0, 3.0};
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        System.out.println(Arrays.toString(class1.calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();
        double[] out = new double[queries.size()];
        int counter = 0;

        // Populate the graph with the equations and their values
        for (int j = 0; j < equations.size(); j++) {
            String top = equations.get(j).get(0);
            String bottom = equations.get(j).get(1);
            graph.putIfAbsent(top, new HashMap<>());
            graph.putIfAbsent(bottom, new HashMap<>());

            // Store the relationships in both directions
            graph.get(top).put(bottom, values[j]); // top -> bottom
            graph.get(bottom).put(top, 1 / values[j]); // bottom -> top
        }

        for (List<String> query : queries) {
            String top = query.get(0);
            String bottom = query.get(1);

            if (top.equals(bottom) && graph.containsKey(top)) {
                out[counter++] = 1.0;
            } else if (!graph.containsKey(top) || !graph.containsKey(bottom)) {
                out[counter++] = -1.0;
            } else {
                out[counter++] = dfs(top, bottom, graph, new HashSet<>(), 1.0);
            }
        }
        return out;
    }

    // Change: Perform a DFS to find the path and accumulate the product of values
    private double dfs(String src, String dest, Map<String, Map<String, Double>> graph, Set<String> visited, double currResult) {

        if (visited.contains(src)) return -1.0; // Prevent cycles
        if (!graph.containsKey(src)) return -1.0; // Source not in graph
        if (src.equals(dest)) return currResult; // Found the destination

        visited.add(src); // Mark the current node as visited
        Map<String, Double> neighbors = graph.get(src); // Get neighbors of the current node

        for (String neighbor : neighbors.keySet()) {
            double edgeValue = neighbors.get(neighbor); // Get the edge value to the neighbor
            double result = dfs(neighbor, dest, graph, visited, currResult * edgeValue); // Recur for the neighbor
            if (result != -1.0) {
                return result; // Found a valid path, return the result
            }
        }
        visited.remove(src); // Clean up visited set
        return -1.0; // No valid path found
    }
}
