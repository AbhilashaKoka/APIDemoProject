package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;
import java.io.*;
import java.util.*;

public class CsvReaderWithTestID {
    public static void main(String[] args) throws IOException {
        String csvFile = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/TestData.csv";


        // Read the CSV and store rows indexed by TestID
        Map<String, Map<String, String>> dataByTestID = readCsvWithTestID(csvFile);



        // Example usage: Fetch a row by TestID
        String testID = "TC01";
        if (dataByTestID.containsKey(testID)){
            System.out.println("Data for TestID " + testID + ": " + dataByTestID.get(testID));
        } else {
            System.out.println("No data found for TestID: " + testID);
        }
    }



    // Method to read CSV and store rows indexed by TestID
    private static Map<String, Map<String, String>> readCsvWithTestID(String csvFile) throws IOException {
        Map<String, Map<String, String>> dataMap = new HashMap<>(); // Store data by TestID

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] headers = br.readLine().split(","); // First row as headers
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> row = new HashMap<>();
                String testID = null;

                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], values[i]);
                    if (headers[i].equalsIgnoreCase("TestID")) { // Identify TestID column
                        testID = values[i];
                    }
                }

                if (testID != null) {
                    dataMap.put(testID, row); // Index row by TestID
                }
            }
        }
        return dataMap;
    }
}