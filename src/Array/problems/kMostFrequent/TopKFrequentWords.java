package Array.problems.kMostFrequent;

import java.util.*;
import java.util.stream.Collectors;


public class TopKFrequentWords {

    public static void main(String[] args) {
        String[][] nums = {{"i", "love", "leetcode", "i", "love", "coding"}};
        //String[][] nums = {{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}};
        //String[][] nums = {{"plpaboutit","jnoqzdute","sfvkdqf","mjc","nkpllqzjzp","foqqenbey","ssnanizsav","nkpllqzjzp","sfvkdqf","isnjmy","pnqsz","hhqpvvt","fvvdtpnzx","jkqonvenhx","cyxwlef","hhqpvvt","fvvdtpnzx","plpaboutit","sfvkdqf","mjc","fvvdtpnzx","bwumsj","foqqenbey","isnjmy","nkpllqzjzp","hhqpvvt","foqqenbey","fvvdtpnzx","bwumsj","hhqpvvt","fvvdtpnzx","jkqonvenhx","jnoqzdute","foqqenbey","jnoqzdute","foqqenbey","hhqpvvt","ssnanizsav","mjc","foqqenbey","bwumsj","ssnanizsav","fvvdtpnzx","nkpllqzjzp","jkqonvenhx","hhqpvvt","mjc","isnjmy","bwumsj","pnqsz","hhqpvvt","nkpllqzjzp","jnoqzdute","pnqsz","nkpllqzjzp","jnoqzdute","foqqenbey","nkpllqzjzp","hhqpvvt","fvvdtpnzx","plpaboutit","jnoqzdute","sfvkdqf","fvvdtpnzx","jkqonvenhx","jnoqzdute","nkpllqzjzp","jnoqzdute","fvvdtpnzx","jkqonvenhx","hhqpvvt","isnjmy","jkqonvenhx","ssnanizsav","jnoqzdute","jkqonvenhx","fvvdtpnzx","hhqpvvt","bwumsj","nkpllqzjzp","bwumsj","jkqonvenhx","jnoqzdute","pnqsz","foqqenbey","sfvkdqf","sfvkdqf"}};

        for (String[] num : nums) {
            int k = 2;
            System.out.println("Top F Frequent words using treeMap: " + Arrays.toString(usingTreeMap(num, k).toArray()));
            System.out.println("Top F Frequent words using Custom comparator: " + Arrays.toString(usingCustomComparator(num, k).toArray()));
            System.out.println("Top F Frequent words using Priority Queue: " + Arrays.toString(usingPriorityQueue(num, k).toArray()));
        }
    }

    public static List<String> usingPriorityQueue(String[] words, int k) {

        /**
         * i        2
         * love     2
         * leetcode 1
         * coding   1
         */
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w2) - map.get(w1));

        for (String word : map.keySet()) {
            // Add to heap
            heap.offer(word);

            if (heap.size() > k) {
                // Remove smaller items from Heap
                heap.poll();
            }
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty() && k > 0) {
            ans.add(heap.poll());
            k--;

            if (k <= 0) {
                break;
            }
        }


        Collections.reverse(ans);
        return ans;

    }

    public static List<String> usingCustomComparator(String[] words, int k) {

        /**
         * i        2
         * love     2
         * leetcode 1
         * coding   1
         */
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<String> out = new ArrayList<>(map.keySet());

        // SORT KEYS BY COUNT
        Collections.sort(out, (a1, a2) -> map.get(a1).equals(map.get(a2)) ? a1.compareTo(a2) : map.get(a2) - map.get(a1));
        return out.subList(0, k);

    }

    public static List<String> usingTreeMap(String[] words, int k) {

        /**
         * i        2
         * love     2
         * leetcode 1
         * coding   1
         */
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        /**
         * 1 >  leetcode > coding
         * 2 >  i > love
         */
        //TreeMap<Integer, List<String>> treeMap = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, List<String>> treeMap = new TreeMap(new CustomComparator());
        for (String key : map.keySet()) {
            if (treeMap.containsKey(map.get(key))) {
                List<String> list = treeMap.get(map.get(key));
                list.add(key);
                treeMap.put(map.get(key), list);
            } else {
                List<String> list = new LinkedList<>();
                list.add(key);
                treeMap.put(map.get(key), list);
            }
        }

        List<String> out = new ArrayList<>();
        int l = 0;
        Iterator<Map.Entry<Integer, List<String>>> iterator = treeMap.entrySet().iterator();
        while (k > 0 && iterator.hasNext()) {
            List<String> list = iterator.next().getValue();
            list.sort(Comparator.naturalOrder());

            int j = 0;
            while (k > 0 && j < list.size()) {
                out.add(list.get(j++));
                k--;
            }

            if (k <= 0) {
                break;
            }

        }
        return out;


    }


    private static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer number1, Integer number2) {
            int value = number1.compareTo(number2);

            // elements are sorted in reverse order
            if (value > 0) {
                return -1;
            } else if (value < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
