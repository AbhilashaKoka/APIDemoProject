package selenium.demo.dataProvider;
import com.google.common.reflect.TypeToken;
import selenium.demo.manager.FileReaderManager;
import selenium.demo.testData.PracticeFormsDetails;
import selenium.demo.testData.TextBoxDetails;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

public class JsonDataReader {
private final String TextBoxFilePath;//configs//TextBoxData.json";

    {
        try {
            TextBoxFilePath = System.getProperty("user.dir")+ FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"TextBoxData.json";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final String PracticalFormsDetailsFilePath;

    {
        try {
            PracticalFormsDetailsFilePath = System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"PracticeFormData.json";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final List<TextBoxDetails>  textBoxDetails;
private final List<PracticeFormsDetails> practiceFormsDetails;


    public JsonDataReader() {
        textBoxDetails=getTextBoxDetails();
        practiceFormsDetails=getPracticeFormsDetails();
    }


    private List<TextBoxDetails> getTextBoxDetails() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(TextBoxFilePath));
            TextBoxDetails[] Details = gson.fromJson(bufferedReader, TextBoxDetails[].class);
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
//    public void ReadJson(){
//    String json = "[{\n" +
//            "\"username\":\"geeta\",\n" +
//            "\"email\":\"geeta@gmail.com\",\n" +
//            "\"currentaddress\":\"sdsfgsggg\" ,\n" +
//            "\"permanentaddress\": \"afdfsff\"\n" +
//            "}]";
//    Gson gson = new Gson();
//    List<TextBoxDetails> users = gson.fromJson(json, new TypeToken<List<TextBoxDetails>>(){}.getType());
//    // Iterate and use parameters
//        for (TextBoxDetails user : users) {
//        System.out.println("ID: " + user.getUsername() + ", Name: " + user.getEmail());
//    }
//}

    private List<PracticeFormsDetails> getPracticeFormsDetails(){
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(TextBoxFilePath));
            PracticeFormsDetails[] Details = gson.fromJson(bufferedReader, PracticeFormsDetails[].class);
            return Arrays.asList(Details);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json File Not Found at Path:" + PracticalFormsDetailsFilePath);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ignore) {
            }
        }
    }


        public final TextBoxDetails getTextBoxDetailsByUserName(String userName){
            return textBoxDetails.stream().filter(x->x.getUsername().equalsIgnoreCase(userName)).findAny().get();
        }


        public final PracticeFormsDetails getPracticeFormDetailsByFirstName(String firstName){
        return practiceFormsDetails.stream().filter(x->x.getFirstName().equalsIgnoreCase(firstName)).findAny().get();
        }
    }


