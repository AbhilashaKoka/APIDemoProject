package seleniumTestNG;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsHandling extends BaseSetUp {


    public AlertsHandling() {

    }

    public static void HandlingAlert(){
        setup();
        driver.get("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement AlertWrapper=driver.findElement(By.xpath("//*[@id=\"javascriptAlertsWrapper\"]"));
        System.out.println(AlertWrapper.getAttribute("innerText"));
        WebElement alertButton=driver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
        alertButton.click();
     //   driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        WebElement timeralertbutton=driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]"));
        timeralertbutton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        WebElement confirmButton=driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        confirmButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement promptButton=driver.findElement(By.xpath("//button[@id=\"promtButton\"]"));
        promptButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        shutDown();
    }
}
