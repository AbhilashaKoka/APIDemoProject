package Selenium.AlertsFrameAndWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ModalDialogHandling {
   static WebDriver driver;
   static Actions action;

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        driver.get("https://demoqa.com/modal-dialogs");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

        WebElement modalWrapper=driver.findElement(By.xpath("//*[@id=\"modalWrapper\"]"));
        System.out.println(modalWrapper.getAttribute("innerText"));

        WebElement smallButton=driver.findElement(By.xpath("//button[@id=\"showSmallModal\"] "));
        smallButton.click();
        WebElement modalBox=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-sm\"]"));
        WebElement closeButton=driver.findElement(By.xpath("//*[@id=\"closeSmallModal\"]"));
        action.moveToElement(modalBox).perform();
        action.moveToElement(closeButton).click().perform();

        Thread.sleep(3000);
        WebElement largeButton=driver.findElement(By.xpath("//*[@id=\"showLargeModal\"]"));
        largeButton.click();
        js.executeScript("window.scrollBy(0,400)");
        WebElement modalBox1=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-lg\"]"));
        WebElement closeButton1=driver.findElement(By.xpath("//*[@id=\"closeLargeModal\"]"));
        action.moveToElement(modalBox1).perform();
        action.moveToElement(closeButton1).click().perform();
    }
}
