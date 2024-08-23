package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ModalPage{
    static WebDriver webDriver;
    static Actions action;


    public ModalPage(WebDriver driver)
    {

        webDriver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]")
    private WebElement AlertFramesAndWindow_frame;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Modal Dialogs\")]")
    private WebElement ModalDialog_Span;


    @FindBy(how = How.XPATH, using = "//*[@id=\"modalWrapper\"]")
    private WebElement modalWrapper_Span;

    @FindBy(how = How.XPATH, using = "//button[@id=\"showSmallModal\"] ")
    private WebElement small_Button;


    @FindBy(how = How.XPATH, using = "//*[@class=\"modal-dialog modal-sm\"]")
    private WebElement modal_Button;


    @FindBy(how = How.XPATH, using = "//*[@id=\"closeSmallModal\"]")
    private WebElement close_Button;

    @FindBy(how = How.XPATH, using = "//*[@id=\"showLargeModal\"]")
    private WebElement large_Button;

    @FindBy(how = How.XPATH, using = "//*[@class=\"modal-dialog modal-lg\"]")
    private WebElement modal1_Button;

    @FindBy(how = How.XPATH, using = " //*[@id=\"closeLargeModal\"]")
    private WebElement close1_Button;


    public  void HandlingModal () throws InterruptedException {
        AlertFramesAndWindow_frame.click();
        ModalDialog_Span.click();

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,350)");

        System.out.println(modalWrapper_Span.getAttribute("innerText"));
        small_Button.click();


         action.moveToElement(modal_Button).perform();
         action.moveToElement(close_Button).click().perform();

        Thread.sleep(3000);
         large_Button.click();
        js.executeScript("window.scrollBy(0,400)");



        action.moveToElement(modal1_Button).perform();
        action.moveToElement(close1_Button).click().perform();

      //  shutDown();
    }
}
