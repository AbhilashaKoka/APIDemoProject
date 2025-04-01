package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReaderFile {
    private final String TestDataFilePath;

    {
        TestDataFilePath = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/TestData.json";
    }


    private List<TestData> testDataList;



    public void JsonDataReader() {
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

}
