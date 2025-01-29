package seleniumUITest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUITest.manager.DriverManager;

import java.time.Duration;

public class AlertPage {

    WebDriver driver;


    @FindBy(how= How.XPATH,using=" //*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]")
    private WebElement Window_Frames;

    @FindBy(how= How.XPATH,using=" //*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Alerts\")]")
    private WebElement Alerts_span;

   @FindBy(how= How.XPATH,using="//*[@id=\"javascriptAlertsWrapper\"]")
   private WebElement  AlertWrapper;

   @FindBy(how= How.XPATH,using="//button[@id=\"alertButton\"]")
   private WebElement alertButton;

    @FindBy(how= How.XPATH,using="//button[@id=\"timerAlertButton\"]")
    private WebElement   timeralertbutton;

   @FindBy(how= How.XPATH,using="//button[@id=\"confirmButton\"]")
    private WebElement confirmButton;

    @FindBy(how= How.XPATH,using="//button[@id=\"promtButton\"]")
    private WebElement  promptButton;


    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean AccordionLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Window_Frames);
        Window_Frames.click();
        Alerts_span.click();
        bol=true;
        return bol;
    }

    public  Boolean HandlingAlert(){
        Boolean bol=false;
        Window_Frames.click();
       Alerts_span.click();
       System.out.println(AlertWrapper.getAttribute("innerText"));
        alertButton.click();
       driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        timeralertbutton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
         confirmButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        promptButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        bol=true;
        return  bol;
    }
}
