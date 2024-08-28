package serenitytest.demotests;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import java.time.temporal.ChronoUnit;


@RunWith(SerenityRunner.class)
public class ElementTest extends PageObject{

    @Managed(driver="edge")
    WebDriver driver;


    @Title("Executing a login Test")
    @Test
    public void doLogin(){
        open();
        System.out.println(getTitle());
        evaluateJavascript("window.scrollBy(0,300)");
        setImplicitTimeout(10, ChronoUnit.SECONDS);
        WebElementFacade Element_Frames=$("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]");
        Element_Frames.click();
        WebElementFacade TextBox_Span=$("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]");
        TextBox_Span.click();
       //withTimeoutOf(Duration.ofSeconds(10),TextBox_Span)
       // waitForCondition().until(ExpectedConditions.visibilityOfElementLocated(TextBox_Span));
        WebElementFacade InputBox_UserName=$( "//*[@id=\"userName\"]");
        InputBox_UserName.typeAndEnter("sita");
        WebElementFacade InputBox_Email=$("//*[@id=\"userEmail\"]");
        InputBox_Email.typeAndEnter("sita@gmail.com");
        WebElementFacade InputBox_CurrAddr=$( "//*[@id=\"currentAddress\"]");
        InputBox_CurrAddr.typeAndEnter("dasds");
        WebElementFacade InputBox_PremAddr=$("//*[@id=\"permanentAddress\"]");
        InputBox_PremAddr.typeAndEnter("asdasf");
        WebElementFacade Button_Submit=$("//*[@id=\"submit\"]");
        Button_Submit.submit();
          ListOfWebElementFacades ele3 = findAll(By.xpath("//*[@id=\"output\"]//p"));
           for(WebElementFacade inputele:ele3)
           {
               System.out.println(inputele.getText());

           }
       }
    }


