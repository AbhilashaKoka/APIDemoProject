package Selenium.Wigets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AccordionHandling {
    static WebDriver driver;
    static Actions action;
    public static void main(String args[]) {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        driver.get("https://demoqa.com/accordian");
        WebElement accordianContainer=driver.findElement(By.xpath(" //*[@id=\"accordianContainer\"]"));
        System.out.println(accordianContainer.getAttribute("innerText"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        List<WebElement> accordiansLIst=driver.findElements(By.xpath(" //div[@id=\"accordianContainer\"]//following::div[@class=\"accordion\"]"));
        int size=accordiansLIst.size();
        for(WebElement ele:accordiansLIst){
            action.moveToElement(ele).perform();
            action.moveToElement(ele.findElement(By.xpath("//*[@class=\"card-header\"]"))).clickAndHold().perform();
            WebElement accordianBody=driver.findElement(By.xpath("//*[@id=\"section1Heading\"]/following::div[starts-with(@class,'collapse')]"));
            action.moveToElement(accordianBody.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p"))).perform();
            action.build();
           System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("class"));
//            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("autocomplete"));
//            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("nonExistingAttribute"));
          }
    }
}
