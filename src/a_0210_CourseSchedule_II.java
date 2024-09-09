import java.util.*;

public class a_0210_CourseSchedule_II {

    /**
     * numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * a,b >> 6th, 5th
     * <p>
     * 1 0
     * 2 0
     * 3 1
     * 3 2
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] outIndexes = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        int[] empty = new int[0];
        int ansCounter = 0;

        for (int[] prereq : prerequisites) {
            int firstGrade = prereq[1];
            int secondGrade = prereq[0];
            map.putIfAbsent(firstGrade, new ArrayList());
            map.get(firstGrade).add(secondGrade);
            outIndexes[secondGrade]++;
        }
        /**
         * Map: 0 - {1,2}, 1 - {3}, 2 - {3}
         * 0 1 2 3 - idx
         * 0 1 1 2 - value
         */
        for (int j = 0; j < outIndexes.length; j++) {
            if (outIndexes[j] == 0) {
                q.offer(j);
            }
        }

        int visited = 0;
        while (!q.isEmpty()) {
            visited++;
            int source = q.poll();
            ans[ansCounter++] = source;

            List<Integer> neigh = map.get(source);
            if (neigh != null && !neigh.isEmpty()) {
                for (int node : map.get(source)) {
                    outIndexes[node]--;
                    if (outIndexes[node] == 0) {
                        q.offer(node);
                    }
                }
            }
        }

        return numCourses == visited ? ans : empty;

    }

}
