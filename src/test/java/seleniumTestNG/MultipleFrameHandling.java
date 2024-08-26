package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;


public class MultipleFrameHandling  extends BaseSetUp {


    public MultipleFrameHandling() {
    }

    public static void HandlingMultipleFrames(){
      setup();
        driver.get("https://demoqa.com/nestedframes");

       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement frame1=driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]//following-sibling::div[@id=\"frame1Wrapper\"]/iframe[@id=\"frame1\"]"));
            driver.switchTo().frame(frame1);
        WebElement frame1Element=driver.findElement(By.tagName("body"));
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);


        int countFrameInFrame1=driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);

        WebElement frame2=driver.findElement(By.xpath("//p"));
        System.out.println(frame2.getAttribute("innerText"));
        System.out.println("Number of frame:"+countFrameInFrame1);

        int countIframeINframe2=driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of frame:"+countIframeINframe2);

      shutDown();

    }
}
