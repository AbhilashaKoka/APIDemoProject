package serenitytest.pagesObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ElementPage extends PageObject {
    @FindBy(xpath="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    WebElementFacade Element_Frames;


    public void ClickOnElementFrames(){
         evaluateJavascript("window.scrollBy(0,300)");
         Element_Frames.click();
    }



}
