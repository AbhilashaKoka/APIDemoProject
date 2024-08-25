package seleniumWebdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class FramesHandling extends BaseSetUp {

    public FramesHandling() {
    }

    public static void HandlingFrame(){
        setup();
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
shutDown();
    }
}
