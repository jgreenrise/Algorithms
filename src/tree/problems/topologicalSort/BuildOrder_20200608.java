package tree.problems.topologicalSort;

import java.util.*;

public class BuildOrder_20200608 {

    public static void main(String args[]) {
        BuildOrder_20200608 class1 = new BuildOrder_20200608();

        Character[] words = {'a', 'b', 'c', 'd', 'e', 'f'};
        Character[][] dependencies = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};
        System.out.println(class1.buildOrder(words, dependencies));
    }

    public String buildOrder(Character[] projects, Character[][] dependencies) {

        int[] ascii = new int[26];

        // From Node > Parent nodes
        Map<Character, Set<Character>> graph = new HashMap();

        // 1: Create Graph
        buildGraph(graph, projects, dependencies, ascii);

        // 2: BFS
        return bfs(graph, projects, dependencies, ascii);

    }

    private String bfs(Map<Character, Set<Character>> graph, Character[] projects, Character[][] dependencies, int[] ascii) {

        StringBuilder out = new StringBuilder();
        Queue<Character> q = new LinkedList();

        for (Character key : graph.keySet()) {

            // Loop though parent-less nodes (Nodes with no parent)
            if (ascii[key - 'a'] == 0) {
                q.offer(key);
                out.append(key);

                // Mark node as visited
                ascii[key - 'a'] = -1;

                while (!q.isEmpty()) {
                    Character curr = q.poll();

                    // Add child nodes to Queue, if exist
                    if (graph.get(curr) == null || graph.get(curr).size() == 0) {
                        continue;
                    }

                    for (char neighbour : graph.get(curr)) {
                        if (ascii[neighbour - 'a'] != -1) {

                            // Mark node as visited
                            ascii[neighbour - 'a'] = -1;
                            q.offer(neighbour);
                            out.append(neighbour);
                        }

                    }

                }

            }
        }

        return out.length() == graph.size() ? out.toString() : "";
    }

    private void buildGraph(Map<Character, Set<Character>> graph, Character[] projects, Character[][] dependencies, int[] ascii) {

        // 1.1 CREATE EMPTY GRAPH
        for (Character project : projects)
            graph.putIfAbsent(project, new HashSet());

        for (int j = 0; j < dependencies.length; j++) {
            Character from = dependencies[j][1];
            Character to = dependencies[j][0];
            graph.get(from).add(to);

            // Child Nodes ++
            ascii[to - 'a']++;
        }

    }

}
