package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;


public class ModalDialogHandling extends BaseSetUp {

    public static Boolean HandlingModalDialog() throws InterruptedException {
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();
        WebElement ModalDialogs_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Modal Dialogs\")]"));
        ModalDialogs_span.click();
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
        bol=true;
        return bol;

    }
}
