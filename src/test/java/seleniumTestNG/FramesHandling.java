package seleniumTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class FramesHandling extends BaseSetUp {

    public FramesHandling() {
    }

    public static void HandlingFrame(){
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();
        WebElement Frames_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Frames\")]"));
        Frames_span.click();

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
