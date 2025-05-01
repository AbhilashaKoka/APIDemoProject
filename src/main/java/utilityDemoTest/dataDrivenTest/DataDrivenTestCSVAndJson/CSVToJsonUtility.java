package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;
import  com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVToJsonUtility {

    public static List<ObjectNode> readCSV(String filePath) throws IOException {
        List<ObjectNode> jsonList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(",");
            String line;
            ObjectMapper mapper = new ObjectMapper();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode jsonNode = mapper.createObjectNode();

                for (int i = 0; i < headers.length; i++) {
                    jsonNode.put(headers[i], values[i]);
                }
                jsonList.add(jsonNode);
            }
        }
        return jsonList;
    }

    public static List<ObjectNode> getRowsByKey(List<ObjectNode> jsonList, String key, String value) {
        List<ObjectNode> filteredRows = new ArrayList<>();
        for (ObjectNode jsonNode : jsonList) {
            if (jsonNode.has(key) && jsonNode.get(key).asText().equals(value)) {
                filteredRows.add(jsonNode);
            }
        }
        return filteredRows;
    }

    public static void main(String[] args) {
        try {
            String csvFilePath = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/TestData.csv"; // Path to CSV file
            List<ObjectNode> jsonData = readCSV(csvFilePath);
            String searchKey = "TC01"; // Column to search
            String searchValue = ""; // Value to find

            List<ObjectNode> results = getRowsByKey(jsonData, searchKey, searchValue);
            System.out.println("Matching Rows: " + results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}