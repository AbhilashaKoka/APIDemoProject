package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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


    public void SubmitDetails(){
        UserName.sendKeys("XYZ");
        Email.sendKeys("xyz@gmail.com");
        CurrentAddr.sendKeys("DownTown, GreenStreet Lane43, London");
        PermanentAddr.sendKeys("London,UK");
        SubmitButton.click();
    }
}
