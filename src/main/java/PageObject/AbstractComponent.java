package PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;




public class AbstractComponent{
   static WebDriver webDriver;
   static JavascriptExecutor js;
   static Actions action;
    WebElement element;


    public AbstractComponent(WebDriver  driver) {
        webDriver=driver;
    }



    public static void waitForElementToAppear(By finBy) {
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finBy));
    }


    public static void scrollWindow() {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,300)");
    }


    public static void scrollWindowUp(WebElement element) {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,300)", element);
    }

    public static void scrollWindowDown() {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,-300)");
    }

    public static void MoveToElement(WebElement element) {
        action = new Actions(webDriver);
        action.moveToElement(element).click().perform();
    }


    public static void waitForElementToVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getWindowHandler() {
        return webDriver.getWindowHandle();
    }

    public static ArrayList<String> getWindowHandlers() {
        return new ArrayList<>(webDriver.getWindowHandles());
    }

    public static Object[] getWindowHandlersArrayOfObject() {

        return webDriver.getWindowHandles().toArray();

    }

    public static void SwitchTOWindowObject(Object[] windowsHandles, int index){
        webDriver.switchTo().window((String) windowsHandles[index]);

    }

    public static void SwitchToWindowByIndex(ArrayList<String> handles, int index)
    {
        String handle=handles.get(index);
        webDriver.switchTo().window(handle);
    }

    public static void SwitchToWindowByName(String parentWindow)
    {

        webDriver.switchTo().window(parentWindow);
    }

    public static void NavigateToUrl(String url)
    {
        webDriver.get(url);
    }

    public static Dimension GetSizeOfWindow(){
        return webDriver.manage().window().getSize();
    }

    public static Point GetPositionOfWindow()
    {
        return webDriver.manage().window().getPosition();
    }


    public static void switchToframeByIndex(int index)
    {
        webDriver.switchTo().frame(index);
    }


    public static void switchToframeByName(WebElement str)
    {
        webDriver.switchTo().frame(str);
    }






}
