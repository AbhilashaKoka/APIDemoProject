package selenium.demo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Date;

import java.io.File;

public class BaseSetUp {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;


    @BeforeMethod
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //  options.addArguments("headless");
        driver=new ChromeDriver(options);
        action = new Actions(driver);
        driver.get("https://demoqa.com");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

     private void LocalDriverSetUp()
      {
        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
     }


    public void FailedScreenshot(String testMethodName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String Timestamp = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(src, new File("C:/Users/Abhilasha/IdeaProjects/Spring_Course-master/APIDemoProject/Screenshots/" + testMethodName + "_" + Timestamp + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @AfterMethod
    public static void shutDown() {
        driver.quit();
    }


    public void Scrollwindow() {
    js =(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,300)");
}

}
