package selenium.demo.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.demo.testData.TextBoxDetails;


public class HomePage {

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


    public boolean SubmitDetails(TextBoxDetails textBoxDetails) {

       Boolean bol=false;
        WebDriverManager.scrollWindow();
        Element_frame.click();
        TextBox_Span.click();

        UserName.sendKeys(textBoxDetails.getUsername());
        Email.sendKeys(textBoxDetails.getEmail());

        CurrentAddr.sendKeys(textBoxDetails.getCurrentaddress());
        PermanentAddr.sendKeys(textBoxDetails.getPermanentaddress());

        SubmitButton.click();
        bol=true;
        return bol;
    }
}
