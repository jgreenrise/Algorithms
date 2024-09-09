import java.util.*;

public class a_0815_BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int busNo = 0; busNo < routes.length; busNo++) {
            int[] stops = routes[busNo];
            for (int j = 0; j < stops.length; j++) {
                map.putIfAbsent(stops[j], new ArrayList<>());
                map.get(stops[j]).add(busNo);
            }
        }

        if (!map.containsKey(source) || !map.containsKey(target)) {
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            System.out.println("Q size: " + size + ", peek: " + q.peek());
            for (int i = 0; i < size; i++) {

                int currBusStop = q.poll();
                if (currBusStop == target) {
                    return level;
                }

                if (!visitedStops.contains(currBusStop)) {
                    visitedStops.add(currBusStop);

                    List<Integer> currBuses = map.get(currBusStop);
                    for (int j = 0; j < currBuses.size(); j++) {
                        int currBus = currBuses.get(j);
                        if (!visitedBuses.contains(currBus)) {
                            int[] busStopsByBuses = routes[currBus];
                            for (int k : busStopsByBuses) {
                                if (!visitedStops.contains(k)) {
                                    q.offer(k);
                                    System.out.println("\t Added to q: " + k);
                                }
                            }

                        }
                        visitedBuses.add(currBus);
                    }
                }
                System.out.println("----");
            }
            level++;
            System.out.println("Level incremented: " + level);
        }

        return -1;

    }

}