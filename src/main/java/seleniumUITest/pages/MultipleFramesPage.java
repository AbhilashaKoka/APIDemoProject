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

public class MultipleFramesPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;
    @FindBy(how= How.XPATH,using= "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]")
    private WebElement   Window_Frames;
   @FindBy(how= How.XPATH,using= "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Nested Frames\")]")
   private WebElement    NestedFrames_span;
  @FindBy(how= How.XPATH,using="//*[@id=\"framesWrapper\"]//following-sibling::div[@id=\"frame1Wrapper\"]/iframe[@id=\"frame1\"]")
  private WebElement frame1 ;

    @FindBy(how= How.TAG_NAME,using="body")
    private WebElement  frame1Element;

     @FindBy(how= How.TAG_NAME,using="iframe")
     private WebElement   countFrameInFrame1;

   @FindBy(how= How.XPATH,using="//p")
   private WebElement  frame2;



    @FindBy(how= How.TAG_NAME,using="iframe")
    private WebElement  countIframeINframe2;


    public void MultipleFramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean MultipleFramesLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Window_Frames);
        Window_Frames.click();
        NestedFrames_span.click();
        bol=true;
        return bol;
    }



    public static Boolean HandlingMultipleFrames(){
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();
        WebElement NestedFrames_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Nested Frames\")]"));
        NestedFrames_span.click();

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
        bol=true;
        return bol;

    }

}
