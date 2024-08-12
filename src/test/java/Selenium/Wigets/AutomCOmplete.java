package Selenium.Wigets;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AutomCOmplete {
    static WebDriver driver;
    static Actions action;
    public static void main(String arg[]) {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
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


    }
}
