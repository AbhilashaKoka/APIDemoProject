package seleniumUITest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

public class AutomCompletePage {
    WebDriver driver;


     @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]")
     private WebElement   Widgets_Frames;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Auto Complete\")]")
    private WebElement Accordian_span;

   @FindBy(how = How.XPATH, using = "//div[@class=\"auto-complete__input\"]//input[@id=\"autoCompleteMultipleInput\" and @type=\"text\"]")
    private WebElement  firstPlaceholder;

   @FindBy(how = How.XPATH, using = "//*[@class=\"css-1g6gooi\"]/div[@class=\"auto-complete__input\"]/input[@id=\"autoCompleteMultipleInput\" and @type =\"text\"]")
    private WebElement  secondPlaceHolder;

    public AutomCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean PracticeFormLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Widgets_Frames);
        Widgets_Frames.click();
        Accordian_span.click();
        bol=true;
        return bol;
    }


    public  Boolean HandlingAutomComplete(){
        Boolean bol=false;

        Widgets_Frames.click();

        Accordian_span.click();

        firstPlaceholder.sendKeys("Green");
        firstPlaceholder.sendKeys(Keys.TAB);
        firstPlaceholder.sendKeys(Keys.TAB);
        secondPlaceHolder.sendKeys("Green");
        // secondPlaceHolder.sendKeys(Keys.TAB);
        bol=true;
        return bol;
    }

}
