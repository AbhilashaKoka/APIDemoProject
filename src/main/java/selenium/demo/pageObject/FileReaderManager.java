package selenium.demo.pageObject;

import selenium.demo.dataProvider.ConfigFileReader;
import selenium.demo.dataProvider.JsonDataReader;

import java.io.IOException;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager=new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonDataReader jsonDataReader;


    public FileReaderManager() {
    }


    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() throws IOException {
        return (configFileReader==null)?new ConfigFileReader():configFileReader;
    }

    public JsonDataReader getJsonDataReader() throws IOException {

        return(jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;

    }
}
