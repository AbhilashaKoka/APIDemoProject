package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class jsonreaderFile {
    private final String TextBoxFilePath;
    //configs//TextBoxData.json";
    {
        TextBoxFilePath = "src/main/java/utilityDemoTest/dataDrivenTest/DataDrivenTestCSVAndJson/DataSheet.json";
    }


    private List<DataSheet> dataSheetDetails;



    public void JsonDataReader() {
        dataSheetDetails=getDataSheetDetails();

    }



    private List<DataSheet> getDataSheetDetails() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(TextBoxFilePath));
            DataSheet[] Details = gson.fromJson(bufferedReader, DataSheet[].class);
            return Arrays.asList(Details);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json File Not Found at Path:" + TextBoxFilePath);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final DataSheet getTextBoxDetailsByTestCaseID(String TestCaseID){
        return dataSheetDetails.stream().filter(x->x.getTestCaseID().equalsIgnoreCase(TestCaseID)).findAny().get();
    }

}
