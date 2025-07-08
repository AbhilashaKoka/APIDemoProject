package DataDrivenTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson.ReaderFile.*;

public class ReaderUtility {

    public static String[] getTestData(String csvFile, String jsonTemplateFile){
        //Read CSV and JSON Template
        List<Map<String, String>> csvData=null;
        try {
            csvData=readCsv(csvFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonTemplate=null;
        try {
            jsonTemplate=readJsonTemplate(jsonTemplateFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> ls=new ArrayList<>();
        //Iterate through CSV data and replace placeholders
        for(Map<String, String> row:csvData){
            String populatedJson=replacePlaceholders(jsonTemplate,row);
            ls.add(populatedJson);
        }
        //converting List<String> to String[]
       return  ls.toArray(new String[ls.size()]);
    }

    public static void SearchMethod(String UserName, String Password){
        System.out.println(UserName);
        System.out.println(Password);
    }
}
