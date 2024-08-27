package selenium.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.demo.manager.DriverManager;


public class ModalPage {

WebDriver driver;


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


    public ModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean ModalLandingPage()
    {
        boolean bol=false;
        AlertFramesAndWindow_frame.click();
        ModalDialog_Span.click();
        DriverManager.scrollWindow();
        bol=true;
        return bol;

    }
    public  boolean HandlingModal () throws InterruptedException {
boolean bol=false;
        System.out.println(modalWrapper_Span.getAttribute("innerText"));
        small_Button.click();
        DriverManager.MoveToElement(modal_Button);
        DriverManager.MoveToElement(close_Button);
        close_Button.click();
        Thread.sleep(3000);
         large_Button.click();
        DriverManager.scrollWindow();
        DriverManager.MoveToElement(modal1_Button);
        DriverManager.MoveToElement(close1_Button);
        close1_Button.click();
        bol=true;
        return bol;
    }
}
