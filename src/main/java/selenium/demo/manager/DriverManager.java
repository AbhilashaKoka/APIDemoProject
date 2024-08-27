package selenium.demo.manager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class DriverManager {
    public static WebDriver driver;
    static JavascriptExecutor js;
    static Actions action;
    static WebElement element;

    public DriverManager() {
    }

    public WebDriver getDriver() {
        if(driver==null) {
            driver=createDriver();
        }
        return driver;
    }

       private WebDriver createDriver( ) {
//        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        return driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //  options.addArguments("headless");
           return  driver=new ChromeDriver(options);
        }


        public void quiteDriver()
       {
        driver.quit();
        }

        public  void launchBaseUrl(){
        driver.get("https://demoqa.com");
        }


    public static void waitForElementToAppear(By finBy) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finBy));
    }


    public static void scrollWindow() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }


    public static void scrollWindowUp(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", element);
    }

    public static void scrollWindowDown() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");
    }

    public static void MoveToElement(WebElement element) {
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }


    public static void waitForElementToVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getWindowHandler() {
        return driver.getWindowHandle();
    }

    public static ArrayList<String> getWindowHandlers() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public static Object[] getWindowHandlersArrayOfObject() {

        return driver.getWindowHandles().toArray();

    }

    public static void SwitchTOWindowObject(Object[] windowsHandles, int index){
        driver.switchTo().window((String) windowsHandles[index]);

    }

    public static void SwitchToWindowByIndex(ArrayList<String> handles, int index)
    {
        String handle=handles.get(index);
        driver.switchTo().window(handle);
    }

    public static void SwitchToWindowByName(String parentWindow)
    {

        driver.switchTo().window(parentWindow);
    }

    public static void NavigateToUrl(String url)
    {
        driver.get(url);
    }

    public static Dimension GetSizeOfWindow(){
        return driver.manage().window().getSize();
    }

    public static Point GetPositionOfWindow()
    {
        return driver.manage().window().getPosition();
    }


    public static void switchToframeByIndex(int index)
    {
        driver.switchTo().frame(index);
    }


    public static void switchToframeByName(WebElement str)
    {
        driver.switchTo().frame(str);
    }



}
