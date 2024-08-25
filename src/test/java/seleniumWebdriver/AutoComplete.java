package seleniumWebdriver;
import org.openqa.selenium.*;


public class AutoComplete extends BaseSetUp {

    public AutoComplete() {
    }

    public static void HandlingAutomComplete(){
        setup();
        driver.get("https://demoqa.com/auto-complete");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement firstPlaceholder=driver.findElement(By.xpath("//div[@class=\"auto-complete__input\"]//input[@id=\"autoCompleteMultipleInput\" and @type=\"text\"]"));
        firstPlaceholder.sendKeys("Green");
        firstPlaceholder.sendKeys(Keys.TAB);
        firstPlaceholder.sendKeys(Keys.TAB);
        WebElement secondPlaceHolder=driver.findElement(By.xpath("//*[@class=\"css-1g6gooi\"]/div[@class=\"auto-complete__input\"]/input[@id=\"autoCompleteMultipleInput\" and @type =\"text\"]"));
        secondPlaceHolder.sendKeys("Green");
       // secondPlaceHolder.sendKeys(Keys.TAB);
        shutDown();
    }
}
