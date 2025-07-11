package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
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
        List<String> jsonList = new ArrayList<>();

        for (Map<String, String> row : csvData)
        {
            String populatedJson = replacePlaceholders(jsonTemplate, row);
            jsonList.add(populatedJson);
        }

        // Converting List<String> to String[]
        String[] jsonArray = jsonList.toArray(new String[0]);
        for (String json : jsonArray) {
            JSONObject jsonObject = new JSONObject(json);
            String ID = jsonObject.getString("TestCaseID");
            String Name = jsonObject.getString("Name");
            String Email=jsonObject.getString("Email");
            String Age=jsonObject.getString("Age");
            System.out.println("TestCaseID:" + ID + ", " +
                    "Name:" + Name +", " +
                    "Email:" + Email +", " +
                    "Age:" + Age);
        }


        // Convert List<String> to POJO List
        ObjectMapper mapper = new ObjectMapper();
        List<TestData> testCases = new ArrayList<>();

        for (String json : jsonList){
            TestData testCase = mapper.readValue(json, TestData.class);
            testCases.add(testCase);
        }

        // Print the POJO objects
        for (TestData testCase : testCases){
            System.out.println(testCase);
            testCase.setTestCaseID("TestCaseID");
            System.out.println(testCase.getTestCaseID());
        }


    }
}