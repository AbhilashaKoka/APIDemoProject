package serenitytest.steps;
import net.serenitybdd.annotations.Step;
import serenitytest.pagesObject.ElementPage;


public class ElementPageSteps {

    private ElementPage elementPage;

@Step
public void InitialSetUp()
{
     elementPage.open();
}


    @Step
    public void LandingPage(){
        elementPage.ClickOnElementFrames();
    }

    @Step
    public void LoginToElement(){


    }



}
