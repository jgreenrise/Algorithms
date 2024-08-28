import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class a_0027_wordLadder {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        start = "red";
        end = "tax";
        words = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");

        a_0027_wordLadder class1 = new a_0027_wordLadder();
        System.out.println(class1.ladderLength(start, end, words));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        q.offer(beginWord);
        int ans = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            // Loop through q
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();

                // Skip char from currWord
                for (int k = 0; k < currWord.length(); k++) {

                    // Replace with char [a..z]
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        char arr[] = currWord.toCharArray();
                        arr[k] = (char) ch;
                        String newWord = new String(arr);

                        if (newWord.equals(endWord)) {
                            return ans + 1;
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord) && !newWord.equals(currWord)) {
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }

            // Increment ans after processing all nodes at the current level
            ans++;

        }
        return 0;

    }
}