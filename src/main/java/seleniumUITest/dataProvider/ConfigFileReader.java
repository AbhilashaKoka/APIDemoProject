package seleniumUITest.dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;
    private final String propertyFilePath="src/test/resource/Configs/Configuration.properties";


    public ConfigFileReader() {
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


    public String getGeckoDriverPath(){
        String driverPath = properties.getProperty("GeckodriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    public String getIEDriverPath(){
        String driverPath = properties.getProperty("IEdriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }


    public String getChromeDriverPath(){
        String driverPath = properties.getProperty("chromedriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) {
            try{
                return Long.parseLong(implicitlyWait);
            }catch(NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }


    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }
    public String getTestDataResourcePath(){
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
    public String getBaseUrl() {
        String baseUrl = properties.getProperty("baseURL");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }

    public String getUserID() {
        String userId = properties.getProperty("user_Id");
        if(userId != null) return userId;
        else throw new RuntimeException("user_Id not specified in the Configuration.properties file.");
    }

//    public String getLoggerPath() {
//    	String logPath=properties.getProperty("LogPath");
//		if(logPath !=null)return logPath;
//		else throw new RuntimeException("LogPath not specified in the Configuration.properties file");
//    }

    }

