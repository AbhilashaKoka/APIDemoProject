package serenitytest.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class ElementPage extends PageComponent{
    @FindBy(xpath="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    WebElementFacade Element_Frames;


    public void ClickOnElementFrames(){
         Element_Frames.click();
    }

}
