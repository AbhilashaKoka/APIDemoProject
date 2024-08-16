package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponent{

   static WebDriver driver;
    public HomePage(WebDriver driver)
    {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how= How.XPATH,using="//*[@id='userName']")
    private WebElement UserName;

    @FindBy(how=How.XPATH,using="//*[@id='userEmail']")
    private WebElement Email;

    @FindBy(how=How.XPATH,using="/*[@id='currentAddress']")
    private WebElement CurrentAddr;

    @FindBy(how=How.XPATH,using="//*[@id='permanentAddress']")
    private WebElement PermanentAddr;
    @FindBy(how=How.XPATH,using="//*[@id='submit']")
    private WebElement SubmitButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement Element_frame;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]")
    private WebElement TextBox_Span;

    public void SubmitDetails(){

        Element_frame.click();
        TextBox_Span.click();

        UserName.sendKeys("XYZ");
        Email.sendKeys("xyz@gmail.com");

        CurrentAddr.sendKeys("DownTown, GreenStreet Lane43, London");
        PermanentAddr.sendKeys("London,UK");

        SubmitButton.click();
    }
}
