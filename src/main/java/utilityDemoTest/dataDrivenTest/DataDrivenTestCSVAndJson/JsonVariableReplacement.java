package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonVariableReplacement {
    public static void main(String[] args) throws IOException {
        String csvFile = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/DataSheet.csv";
        String jsonTemplateFile = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/DataSheet.json";

        // Read CSV and JSON template
        List<Map<String, String>> csvData = readCsv(csvFile);
        String jsonTemplate = readJsonTemplate(jsonTemplateFile);

        // Iterate through CSV data and replace placeholders
        for (Map<String, String> row : csvData) {
            String populatedJson = replacePlaceholders(jsonTemplate, row);
            System.out.println("Generated JSON:\n" + populatedJson);
            // You can write the populatedJson to a file or use it in your tests
        }
    }

    // Method to read CSV data into a List of Maps
    private static List<Map<String, String>> readCsv(String csvFile) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] headers = br.readLine().split(","); // First row as headers
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> row = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], values[i]);
                }
                data.add(row);
            }
        }
        return data;
    }

    // Method to read JSON template as a String
    private static String readJsonTemplate(String jsonTemplateFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(jsonTemplateFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    // Method to replace placeholders in JSON template with CSV data
    private static String replacePlaceholders(String template, Map<String, String> data) {
        String result = template;
        for (Map.Entry<String, String> entry : data.entrySet()) {
            result = result.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return result;
    }
}