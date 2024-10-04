package kiddom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class RewardDedciatedStudents {

    public static void main(String args[]) {

        String logFile = "/Users/jatinpatel/Library/Mobile Documents/com~apple~CloudDocs/Documents/code/Algorithms/src/kiddom/students.log"; // Specify the path to your log file here
        List<LogData> logDataList = new ArrayList<>();
        List<String> out = new ArrayList<>();
        String filePath = "output.csv";

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write CSV header
            fileWriter.append("timestamp,userId,pageId,pageType,action\n");

            try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Parse the JSON string manually
                    LogData logData = parseJsonToLogData(line);
                    fileWriter.append(logData.toString());
                    logDataList.add(logData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all log data instances
        for (LogData log : logDataList) {
            //System.out.println(log);
        }

        Map<String, List<LogData>> map = new HashMap<>();
        for (LogData record : logDataList) {
            if (record.getAction().equalsIgnoreCase("End") && record.getPageType().equalsIgnoreCase("ASSIGNMENT")) {
                map.putIfAbsent(record.getUserId(), new ArrayList<>());
                map.get(record.getUserId()).add(record);
            }
        }

        /**
         * Student Id: 110a05c1-209c-42a6-b3ad-de3c6aad2511
         * [LogData{timestamp=1719819408, userId='110a05c1-209c-42a6-b3ad-de3c6aad2511', pageId='589e6566-de91-494b-9dc9-266371a065c8', pageType='ASSIGNMENT', action='END'},
         * LogData{timestamp=1719819652, userId='110a05c1-209c-42a6-b3ad-de3c6aad2511', pageId='d64fd11f-490d-4a93-9462-c6aeadd7d978', pageType='ASSIGNMENT', action='END'}]
         */
        for (String studentId : map.keySet()) {
            //System.out.println("Student Id: " + studentId);
            //System.out.println(map.get(studentId));
            //Map<assignemntId, Listofdays>
            Map<String, Integer> mapResp = new HashMap<>();
            Set<String> assignemnetsCompleted = new HashSet<>();

            for (LogData record : map.get(studentId)) {
                // Convert Unix timestamp to ZonedDateTime
                ZonedDateTime dateTime = Instant.ofEpochSecond(record.getTimestamp()).atZone(ZoneId.systemDefault());
                // Get the year, month, and day
                int year = dateTime.getYear();
                int month = dateTime.getMonthValue(); // Month is 1-12
                int day = dateTime.getDayOfMonth(); // Day of the month

                String key = record.getPageId() + "-" + day + "-" + month + "-" + year;

                if (!assignemnetsCompleted.contains(record.getPageId())) {
                    mapResp.putIfAbsent(key, 0);  // Put key with 0 if absent
                    mapResp.put(key, mapResp.get(key) + 1);
                }
                assignemnetsCompleted.add(record.getPageId());
                // Map <p1:d1>,  <p1: d1, d2>, <p2: d3>, map.size > 1
            }

            // Loop through each entry in the mapResp and print the key-value pair
            for (Map.Entry<String, Integer> entry : mapResp.entrySet()) {
                System.out.println("StudentId: " + studentId + " Assignment Id: " + entry.getKey() + ", Days: " + entry.getValue());
            }

            if (mapResp.size() == 2) {
                //System.out.println("****Student Id: " + studentId + "\t");
                out.add(studentId);
            }
        }


        // 58a380cf-d512-43b8-a527-7228a7c41434 : {r1, r2, r3 ....  r4}
        System.out.println("Final Output: " + out);


    }

    private static LogData parseJsonToLogData(String jsonString) {
        // Remove whitespace and curly braces
        jsonString = jsonString.trim();
        jsonString = jsonString.substring(1, jsonString.length() - 1);

        // Split the string by commas
        String[] keyValuePairs = jsonString.split(", ");

        // Initialize variables to hold parsed values
        long timestamp = 0;
        String userId = null;
        String pageId = null;
        String pageType = null;
        String action = null;

        // Loop through each key-value pair
        for (String pair : keyValuePairs) {
            String[] entry = pair.split(": "); // Split by colon
            String key = entry[0].replace("\"", ""); // Remove quotes from key
            String value = entry[1].replace("\"", ""); // Remove quotes from value

            // Assign values based on keys
            switch (key) {
                case "timestamp":
                    timestamp = Long.parseLong(value); // Parse long
                    break;
                case "userId":
                    userId = value; // String
                    break;
                case "pageId":
                    pageId = value; // String
                    break;
                case "pageType":
                    pageType = value; // String
                    break;
                case "action":
                    action = value; // String
                    break;
            }
        }

        // Create and return a LogData object
        return new LogData(timestamp, userId, pageId, pageType, action);
    }
}
