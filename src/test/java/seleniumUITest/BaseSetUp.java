package seleniumUITest;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BaseSetUp {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;
    static  BrowserMobProxy proxy;

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
      //   localDriverSetUp();
        driver.get("https://demoqa.com");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

    }

    public WebDriver getDriver() {
        return driver;
    }


    private static void localDriverSetUp() {
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar("exampleTest");
        Proxy seleniumProxy = new Proxy();
        seleniumProxy.setHttpProxy("localhost:" + proxy.getPort());
        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", seleniumProxy);
        options.addArguments("start-maximized");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }


    public void failedScreenshot(String testMethodName) {
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
    public static void tearDown() throws IOException {
        if (driver != null) {
            driver.quit();
            File harFile = new File("network_capture.har");
            proxy.getHar().writeTo(harFile);
            proxy.stop();

        }
    }

        public void executeScrollAction(){
            js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)");
        }

    }

