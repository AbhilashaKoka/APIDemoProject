package seleniumUITest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

public class FramePage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;

  @FindBy(how= How.XPATH,using=" //*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]")
  private WebElement    Window_Frames;
   @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Frames\")]")
   private WebElement   Frames_span;

  @FindBy(how= How.XPATH,using="//*[@id=\"framesWrapper\"]")
    private WebElement  iframes;
@FindBy(how= How.XPATH,using="//*[@id=\"frame1Wrapper\"]//iframe")
    private WebElement  frame1;
    @FindBy(how= How.XPATH,using="//*[@id=\"sampleHeading\"]")
    private WebElement framesHeading;

    @FindBy(how= How.XPATH,using="//*[@id=\"frame2Wrapper\"]//iframe")
    private WebElement  frame2;

    public void FramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean FrameLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Window_Frames);
        Window_Frames.click();
        Frames_span.click();
        bol=true;
        return bol;
    }



    public static Boolean HandlingFrame(){
        Boolean bol=false;
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
        bol=true;
        return bol;

    }
}
