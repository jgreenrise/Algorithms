import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timer {
    String name = null;
    List<Integer> buckets = null;
    Map<Integer, Integer> map = null;

    public Timer(String name, List<Integer> buckets) {
        this.name = name;
        this.buckets = buckets;
        map = new HashMap<>();
        buckets.add(Integer.MAX_VALUE); // Add the MAX bucket
        buildMap();
    }

    private void buildMap() {
        for (int bucketId : buckets) {
            map.put(bucketId, 0);
        }
    }

    public void record(int time) {
        int bucketId = findBestBucketId(time);
        map.put(bucketId, map.getOrDefault(bucketId, 0) + 1);
    }

    private int findBestBucketId(int time) {
        int left = 0;
        int right = buckets.size() - 1;

        // Binary search to find the correct bucket for the given time
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (time < buckets.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return buckets.get(left); // Return the correct bucket value
    }

    public String scrape() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // Remove the last comma
        }
        return sb.toString();
    }
}

class TimerFactory {

    private static TimerFactory instance = null;
    private static Timer timer = null;

    private TimerFactory() {
    }

    public static TimerFactory getInstance() {
        if (instance == null) {
            instance = new TimerFactory();
        }
        return instance;
    }

    public Timer getTimer(String name, List<Integer> buckets) {
        if (timer == null) {
            timer = new Timer(name, buckets);
        }
        return timer;
    }
}

class MetricController {
    public String getSearchApiTimerMetrics() {
        return TimerFactory.getInstance().getTimer("search.latency", List.of(10, 20, 30, 40, 50)).scrape();
    }
}

class SearchController {
    public String searchV1(String query) {
        int startTime = (int) System.currentTimeMillis();
        String searchResult = SearchUtils.doSearch(query);
        int endTime = (int) System.currentTimeMillis();
        TimerFactory.getInstance().getTimer("search.latency", List.of(10, 20, 30, 40, 50)).record(endTime - startTime);
        return searchResult;
    }

    private static class SearchUtils {
        public static String doSearch(String query) {
            return "Any";
        }
    }
}
