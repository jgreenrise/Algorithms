import java.util.*;

public class a_0207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a map to represent the graph and an array to keep track of in-degrees
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        // If there are no prerequisites, all courses can be completed
        if (prerequisites.length == 0) return true;

        // Build the graph and count the in-degrees
        for (int k = 0; k < prerequisites.length; k++) {
            int[] course = prerequisites[k];
            int to = course[0]; // course that needs a prerequisite
            int from = course[1]; // prerequisite course

            // Create the adjacency list
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
            // Increment the in-degree of the course
            inDegree[to]++;
        }

        // Add all courses with an in-degree of 0 to the queue
        for (int l = 0; l < numCourses; l++) {
            if (inDegree[l] == 0) {
                q.offer(l);
            }
        }

        int visitedCount = 0;
        // Perform a topological sort using BFS
        while (!q.isEmpty()) {
            int curr = q.poll(); // Get the current course with in-degree 0
            visitedCount++; // Count it as visited

            // Get the neighbors of the current course
            List<Integer> neighbors = map.get(curr);
            if (neighbors == null || neighbors.isEmpty()) continue; // Skip if no neighbors

            // Process each neighbor
            for (int neighbor : neighbors) {
                inDegree[neighbor]--; // Decrease the in-degree
                if (inDegree[neighbor] == 0) { // If in-degree becomes 0, add to queue
                    q.offer(neighbor);
                }
            }
        }

        // Check if all courses have been visited
        return visitedCount == numCourses;
    }

}
