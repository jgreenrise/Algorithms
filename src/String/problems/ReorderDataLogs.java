package String.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataLogs {

    public static void main(String[] args) {

        String [] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        //String [] logs = {"dig1 8 1 5 1","let1 art can"};

        // Approach String Builder or String
        //System.out.println(usingStringBuilder(input));
        System.out.println(Arrays.toString(reorderLogFiles(logs)));

    }

    public static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (entry1, entry2) -> {
            // split1 > [dig1, 8 1 5 1]
            // split2 > [let1, art can]
            String [] split1 = entry1.split(" ", 2);
            String [] split2 = entry2.split(" ", 2);

            boolean isDigitLogs1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigitLogs2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigitLogs1 && !isDigitLogs2){
                // Both are letter logs
                // Letter-logs are sorted alphanumerically, by content then identifier;

                // Compare by content
                int cmp = split1[1].compareTo(split2[1]);

                if(cmp != 0){
                    // Not equal to 0, means they are not equal
                    return cmp;
                }

                // Content is Same, Compare by identifier
                return split1[0].compareTo(split2[0]);

            }

            if(isDigitLogs1){
                if(isDigitLogs2){
                    // Preserve Log > Equal
                    return 0;
                }else{
                    // SWP > Left: D, Right: L
                    return -1;
                }
            }else{
                // Preserve Log > Letter logs comes before digit log
                return 1;
            }

        });


        return logs;

    }
}
