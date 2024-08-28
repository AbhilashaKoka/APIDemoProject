package serenitytest.pagesObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ElementPage extends PageObject {
    @FindBy(xpath="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    WebElementFacade Element_Frames;

    @FindBy(xpath="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]")
    WebElementFacade TextBox_Span;

    @FindBy(xpath= "//*[@id=\"userName\"]")
    WebElementFacade InputBox_UserName;

    @FindBy(xpath="//*[@id=\"userEmail\"]")
    WebElementFacade InputBox_Email;

    @FindBy(xpath="//*[@id=\"currentAddress\"]")
    WebElementFacade InputBox_CurrAddr;

    @FindBy(xpath="//*[@id=\"permanentAddress\"]")
    WebElementFacade InputBox_PremAddr;

    @FindBy(xpath="//*[@id=\"submit\"]")
    WebElementFacade Button_Submit;



    public void ClickOnElementFrames(){
         evaluateJavascript("window.scrollBy(0,300)");
         Element_Frames.click();
         TextBox_Span.click();
    }


    public void EnterDetailsInElementPage(){
        InputBox_UserName.typeAndEnter("sita");
        InputBox_Email.typeAndEnter("sita@gmail.com");
        InputBox_CurrAddr.typeAndEnter("dasds");
        InputBox_PremAddr.typeAndEnter("asdasf");
        Button_Submit.submit();
    }



}
