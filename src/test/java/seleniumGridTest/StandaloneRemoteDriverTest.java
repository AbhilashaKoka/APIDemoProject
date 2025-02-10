package seleniumGridTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


//Run Standalone mode -java -jar selenium-server-4.25.0.jar standalone

public class StandaloneRemoteDriverTest {
    static String jarPath = "src/test/resource/driver/selenium-server-4.25.0.jar";
    public static WebDriver driver;


    private static void killProcess(String processName) {
        ProcessBuilder processBuilder = new ProcessBuilder("pkill", "-f", processName);
        processBuilder.redirectErrorStream(true);
        try {
           Process  process = processBuilder.start();
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            int exitCode = process.waitFor();
            System.out.println("Pkill exited with code: "+ exitCode);
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void StartSeleniumServer() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "standalone");
        processBuilder.redirectErrorStream(true);
        try {
          Process  process = processBuilder.start();
            System.out.println("Selenium Server started.");
            // Optionally, you can read the output of the process
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            // Wait for the process to complete (if needed)
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
       }
 }


    public static void setup(String browser) throws IOException {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                   driver = (new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions));
             //   driver = (new RemoteWebDriver(new URL("http://IPStandalone:4444"), chromeOptions));
              }
            else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = (new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions));

            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = (new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions));
            }
            else {
                throw new Error("Browser configuration is not defined!!");
            }
        }


@Test
public static void main(String[] args) throws IOException, InterruptedException {
   String processName = "java.exe";
   killProcess(processName);
    StartSeleniumServer();
    setup("chrome");
        driver.get("https://demoqa.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement TextBox_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
        TextBox_Span.click();
        String sText=js.executeScript("return document.title;").toString();
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        String sText1=js.executeScript("return document.title;").toString();
        System.out.println(sText1);
        String sText2=js.executeScript("return document.domain;").toString();
        System.out.println(sText2);
        String sText3=js.executeScript("return document.URL;").toString();
        System.out.println(sText3);
        js.executeScript("arguments[0].scrollIntoView;",element);
        js.executeScript("location.reload()");
        js.executeScript("document.getElementById('userName').value='sita';");
        js.executeScript("document.getElementById('userEmail').value='sita@gmail.com';");
        js.executeScript("document.getElementById('currentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('permanentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('submit').click();");
        List<WebElement> ele3=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
        if(ele3.size()!=0){
            System.out.println(ele3.size()+"Element found as tag name as input \n");
            for(WebElement inputele:ele3)
            {
                System.out.println(inputele.getText());
            }
        }
    tearDown();
    }




    public static void tearDown() throws InterruptedException {
        driver.quit();


    }
    }




