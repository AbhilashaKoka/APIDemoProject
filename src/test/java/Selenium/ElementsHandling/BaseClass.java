package Selenium.ElementsHandling;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;

    public static void setup() {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
    }

    public static void shutDown(){
        driver.quit();
    }
}
