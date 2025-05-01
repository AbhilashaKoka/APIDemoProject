package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReaderFile {

    private final String TestDataFilePath;

    {
     TestDataFilePath ="src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/TestData.json";
    }


    private List<TestData> testDataList;



    public void ReaderFile() {
        testDataList = getTestDataList();
    }



    private List<TestData> getTestDataList() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(TestDataFilePath));
            TestData[] Details = gson.fromJson(bufferedReader, TestData[].class);
            return Arrays.asList(Details);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json File Not Found at Path:" + TestDataFilePath);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final TestData getTestDataByTestCaseID(String TestCaseID){
        return testDataList.stream().filter(x->x.ID.equalsIgnoreCase(TestCaseID)).findAny().get();
    }


    // Method to read CSV data into a List of Maps
    static List<Map<String, String>> readCsv(String csvFile) throws IOException {
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
    static String readJsonTemplate(String jsonTemplateFile) throws IOException {
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
    static String replacePlaceholders(String template, Map<String, String> data) {
        String result = template;
        for (Map.Entry<String, String> entry : data.entrySet()) {
            result = result.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return result;
    }

    // Method to replace placeholders in JSON template with CSV data
    static String replacePlaceholders2(String template, Map<String, String> data) {
        String result = template;
        for (Map.Entry<String, String> entry : data.entrySet()) {
            result = result.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return result;
    }
}
