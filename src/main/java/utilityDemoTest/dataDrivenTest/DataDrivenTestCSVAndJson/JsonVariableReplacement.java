package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson.ReaderFile.*;

public class JsonVariableReplacement {
    public static void main(String[] args) throws IOException {
        String csvFile = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/TestData.csv";
        String jsonTemplateFile = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/TestData.json";

        // Read CSV and JSON template
        List<Map<String, String>> csvData = readCsv(csvFile);
        String jsonTemplate = readJsonTemplate(jsonTemplateFile);



        // Iterate through CSV data and replace placeholders
        for (Map<String, String> row : csvData) {
            String populatedJson = replacePlaceholders(jsonTemplate, row);
            System.out.println("Generated JSON:\n" + populatedJson);
         // You can write the populatedJson to a file or use it in your tests


            // Fetch values and convert to String[]
            String[] stringArray = row.values().toArray(new String[0]);

            // Print the array
            for (String value : stringArray) {
                System.out.println(value);
            }

            for(Map.Entry<String, String> entry:row.entrySet())
            {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }

        ReaderFile jsonreaderFile = new ReaderFile();
        TestData dataSheet= jsonreaderFile.getTestDataByTestCaseID("TC01");
        System.out.println(dataSheet.toString());
    }


}