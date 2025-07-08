package DataDrivenTest;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static DataDrivenTest.ReaderUtility.SearchMethod;
import static DataDrivenTest.ReaderUtility.getTestData;

public class TestMethod{

    String csvFilePath="src/test/resource/TestDataDriver/search.csv";
    String jsonTemplateFile="src/test/resource/TestDataDriver/search.json";
    JSONObject jsonObject;

    @Test(dataProvider = "SearchUser")
    public void SearchUser(JSONObject jsonObject){
        SearchMethod(jsonObject.getString("UserName"),jsonObject.getString("Password"));
    }


    @DataProvider(name="SearchUser")
    public Object[][] dataProviderMethod(Method method){
        List<Object[]> list=new ArrayList<>();
        String[] data=getTestData(csvFilePath,jsonTemplateFile);
        for(String json:data){
            jsonObject=new JSONObject(json);
            list.add(new Object[]{
                    jsonObject
            });
        }
        return list.toArray(new Object[data.length][]);

    }
}
