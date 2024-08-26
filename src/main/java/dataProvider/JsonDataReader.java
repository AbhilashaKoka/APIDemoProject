package dataProvider;
import manager.FileReaderManager;
import testData.PracticeFormsDetails;
import testData.TextBoxDetails;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

public class JsonDataReader {

private final String TextBoxFilePath=System.getProperty("user.dir")+ FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"TextBoxData.json";//configs//TextBoxData.json";
     private final String PracticalFormsDetailsFilePath=System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"PracticeFormData.json";
private List<TextBoxDetails>  textBoxDetails;
private List<PracticeFormsDetails> practiceFormsDetails;


    public JsonDataReader() throws IOException {

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


