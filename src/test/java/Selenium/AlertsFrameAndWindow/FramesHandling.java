package Selenium.AlertsFrameAndWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class FramesHandling {
   static  WebDriver driver;
   static  Actions action;

    public static void main(String args[]){
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        driver.get("https://demoqa.com/frames");
        WebElement iframes=driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]"));
        System.out.println(iframes.getAttribute("innerText"));
        WebElement iframes1=driver.findElement(By.xpath("//*[@id=\"frame1Wrapper\"]//iframe"));
         driver.switchTo().frame("frame1");
         WebElement framesHeading=driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]"));
        System.out.println(framesHeading.getText());
        driver.switchTo().defaultContent();


        WebElement iframes2=driver.findElement(By.xpath("//*[@id=\"frame2Wrapper\"]//iframe"));
        driver.switchTo().frame("frame2");
        System.out.println(iframes2.getAttribute("innerText"));
        driver.switchTo().defaultContent();







    }
}
