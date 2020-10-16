package tree.problems.topologicalSort;

import java.util.*;

public class AlienDictionaryOrder_20200608 {

    public static void main(String args[]) {
        AlienDictionaryOrder_20200608 class1 = new AlienDictionaryOrder_20200608();
        String[] words = {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        System.out.println(class1.alienOrder(words));
    }

    public String alienOrder(String[] words) {

        // Helps differentiate parent nodes vs child nodes

        // Parent (of all Chars) node value: 0
        // Child node value: 1
        int[] ascii = new int[26];

        // From Node > Child nodes
        Map<Character, Set<Character>> graph = new HashMap();

        // 1: Create Graph
        buildGraph(graph, words, ascii);

        // 2: BFS
        return bfs(graph, words, ascii);

    }

    public String bfs(Map<Character, Set<Character>> graph, String[] words, int[] ascii) {

        StringBuilder out = new StringBuilder();
        Queue<Character> q = new LinkedList();

        for (Character key : graph.keySet()) {
            if (ascii[key - 'a'] == 0) {
                q.offer(key);
                out.append(key);
            }
        }

        while (!q.isEmpty()) {
            Character curr = q.poll();

            // Add child nodes to Queue, if exist
            if (graph.get(curr) == null || graph.get(curr).size() == 0) {
                continue;
            }

            for (char neighbour : graph.get(curr)) {
                ascii[neighbour - 'a']--;

                if (ascii[neighbour - 'a'] == 0) {
                    q.offer(neighbour);
                    out.append(neighbour);
                }
            }
        }

        return out.length() == graph.size() ? out.toString() : "";
    }

    public void buildGraph(Map<Character, Set<Character>> map, String[] words, int[] ascii) {

        // 1.1 CREATE EMPTY GRAPH
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet());
            }
        }

        // 1.2 CONVERT TO GRAPH
        for (int j = 1; j < words.length; j++) {
            String first = words[j - 1];
            String second = words[j];
            int minLength = Math.min(first.length(), second.length());

            for (int k = 0; k < minLength; k++) {
                if (first.charAt(k) != second.charAt(k)) {

                    char from = first.charAt(k);
                    char to = second.charAt(k);

                    if (!map.get(from).contains(to)) {
                        map.get(from).add(to);
                        System.out.println(from);
                        ascii[to - 'a']++;
                    }

                    // Since we found the difference, we should break
                    // Since we don't know about the order of remaining chars
                    break;
                }

            }
        }

    }

}
