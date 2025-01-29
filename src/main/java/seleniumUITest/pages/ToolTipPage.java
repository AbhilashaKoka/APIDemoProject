package seleniumUITest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

public class ToolTipPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;



   @FindBy(how= How.XPATH,using=" //*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement Element_Frames;
    @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]")
    private WebElement  TextBox_Span;





    public void ToolTipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean ToolTipLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Element_Frames);
        Element_Frames.click();
        TextBox_Span.click();
        bol=true;
        return bol;
    }





}
