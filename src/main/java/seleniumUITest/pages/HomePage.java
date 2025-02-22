package seleniumUITest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;
import seleniumUITest.testDataClass.TextBoxDetails;

import java.util.List;


public class HomePage {
    WebDriver driver;


    @FindBy(how= How.XPATH,using="//*[@id='userName']")
    private WebElement UserName;

    @FindBy(how=How.XPATH,using="//*[@id='userEmail']")
    private WebElement Email;

    @FindBy(how=How.XPATH,using="//*[@id='currentAddress']")
    private WebElement CurrentAddr;

    @FindBy(how=How.XPATH,using="//*[@id='permanentAddress']")
    private WebElement PermanentAddr;
    @FindBy(how=How.XPATH,using="//*[@id='submit']")
    private WebElement SubmitButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement Element_frame;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]")
    private WebElement TextBox_Span;

    @FindBy(how = How.XPATH, using = "//*[@id=\"output\"]/div/p[@id][contains(text(),\"\")]")
    private List<WebElement> Output_Div;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean HomeLandingPage()
    {
        Boolean bol=false;
        DriverManager.scrollWindow();
        Element_frame.click();
        TextBox_Span.click();
        bol=true;
        return bol;
    }


    public void SubmitDetails(TextBoxDetails textBoxDetails) {
        UserName.sendKeys(textBoxDetails.getUsername());
        Email.sendKeys(textBoxDetails.getEmail());
        CurrentAddr.sendKeys(textBoxDetails.getCurrentaddress());
        PermanentAddr.sendKeys(textBoxDetails.getPermanentaddress());
        SubmitButton.click();

    }


    public boolean VerifyOutput() throws InterruptedException {
        boolean bol=false;
        Thread.sleep(1000);
        for(WebElement ele:Output_Div)
        {
            System.out.println( ele.getText());
        }



        bol=true;
        return bol;
    }
}
