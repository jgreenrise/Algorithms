package Array.problems.kMostFrequent;

import java.util.*;

/*-
 * Output
 * Before sorting: [3, 5, 4, 1, 4, 5, 5, 6, 7, 1, 1]

 Input array: [3, 5, 4, 1, 4, 5, 5, 6, 7, 1, 1]
 Hashmap: {1=3, 3=1, 4=2, 5=3, 6=1, 7=1}
 Treemap: {1=[3, 6, 7], 2=[4], 3=[1, 5]}

 Most famous number: [1, 5]
 1 famous numbers: [1, 5]
 2 famous numbers: [4]
 3 famous numbers: [3, 6, 7]

 *
 */
public class NthMostFrequentNumberInArray {

    public static void main(String[] args) {
        int[] i_arr_input = {3, 5, 4, 1, 4, 5, 5, 6, 7, 1, 1};
        System.out.println("Before sorting: " + Arrays.toString(i_arr_input));
        //retrieveNthMostFrequentNumber(i_arr_input);
        //retrieveNthMostFrequentNumberUsingCustomSort(i_arr_input);
        retrieveNthMostFrequentNumberUsingPriorityQueu(i_arr_input);
    }

    /*-
     * Using combination of hashmap and tree map
     *
     * O(n): Insert into hash map.
     * O(lgn): Insert into tree map
     * O(lgn): Search from tree map
     */
    private static void retrieveNthMostFrequentNumber(int[] i_arr_input) {

        System.out.println("Input array: " + Arrays.toString(i_arr_input));
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, LinkedList<Integer>> pairs = null;
        LinkedList<Integer> pair = null;

        /**
         * Add elements to hashmap
         */
        for (int i : i_arr_input) {
            Integer count = map.get(i);
            map.put(i, count != null ? count + 1 : 1);
        }
        System.out.println("Hashmap: " + map.toString());

        /**
         * Add values to tree map
         */
        pairs = new TreeMap<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map_pair = (Map.Entry) it.next();

            if (pairs.containsKey(map_pair.getValue())) {
                pair = pairs.get(map_pair.getValue());
            } else {
                pair = new LinkedList<Integer>();
            }

            pair.add(Integer.parseInt(map_pair.getKey().toString()));
            pairs.put(Integer.parseInt(map_pair.getValue().toString()), pair);
        }
        System.out.println("Treemap: " + pairs.toString());
        System.out.println("\nMost famous number: " + pairs.get(pairs.size()));

        int frequency = 1;
        System.out.println(frequency + " famous numbers: " + pairs.get(pairs.size() - (frequency - 1)));

        frequency = 2;
        System.out.println(frequency + " famous numbers: " + pairs.get(pairs.size() - (frequency - 1)));

        frequency = 3;
        System.out.println(frequency + " famous numbers: " + pairs.get(pairs.size() - (frequency - 1)));

    }

    private static void retrieveNthMostFrequentNumberUsingCustomSort(int[] i_arr_input) {

        System.out.println("Input array: " + Arrays.toString(i_arr_input));
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, LinkedList<Integer>> pairs = null;

        /**
         * Add elements to hashmap
         */
        for (int i : i_arr_input) {
            Integer count = map.get(i);
            map.put(i, count != null ? count + 1 : 1);
        }
        System.out.println("Hashmap: " + map.toString());

        List<Integer> candidates = new ArrayList(map.keySet());

        Collections.sort(candidates, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));

        System.out.println(candidates.subList(0, 1));

    }

    private static void retrieveNthMostFrequentNumberUsingPriorityQueu(int[] i_arr_input) {

        System.out.println("Input array: " + Arrays.toString(i_arr_input));
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, LinkedList<Integer>> pairs = null;

        for (int i : i_arr_input) {
            Integer count = map.get(i);
            map.put(i, count != null ? count + 1 : 1);
        }


        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        map.entrySet().stream().forEach(a -> queue.add(a.getValue()));

        int k = 3;
        List<Integer> out = new ArrayList<>();
        int counter = 0;
        while (!queue.isEmpty()) {

            if (counter < k) {
                out.add(queue.poll());
            }else{
                break;
            }
            counter++;
        }
        System.out.println(out);
    }

}