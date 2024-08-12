package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath="Configs//Configuration.properties";


    public ConfigFileReader() throws IOException {
        BufferedReader reader=null;
       try {
           reader = new BufferedReader(new FileReader(propertyFilePath));
           properties = new Properties();
          try {
              properties.load(reader);
          }
          catch(IOException e) {
          e.printStackTrace();
          }
       }catch (FileNotFoundException e)
       {
           throw new RuntimeException("properties file not found at path:"+propertyFilePath);
       }

       finally
       {
           try {
                   if (reader != null)
                   reader.close();} catch(IOException ignore) { }
       }
       }

    public String getDriverPath(){
        String driverPath=properties.getProperty("driverPath");
        if(driverPath!=null)
            return driverPath;
        else throw new RuntimeException("Driver path not specified in the Configuration.properties file for the key:driverPath");
       }

    }

