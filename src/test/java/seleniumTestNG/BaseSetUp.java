package seleniumTestNG;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSetUp {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;


    @BeforeMethod
    public static void setup() {
        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("start-maximized");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        driver.get("https://demoqa.com");
        js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }


    @AfterMethod
    public static void shutDown(){
        driver.quit();
    }
}
