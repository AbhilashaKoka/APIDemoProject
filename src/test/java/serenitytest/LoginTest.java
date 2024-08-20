package serenitytest;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;


@RunWith(SerenityRunner.class)
public class LoginTest extends PageObject{

    @Managed(driver="chrome")
    WebDriver driver;


    @FindBy(xpath="//*[@id='permanentAddress']")
    WebElement PermanentAddr;


    @Title("Executing a login Test")
    @Test
    public void doLogin() throws InterruptedException {
        open();
        evaluateJavascript("window.scrollBy(0,300)");
        $("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]").click();
        getDriver().findElement((By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"))).click();
        find(By.xpath("//*[@id=\"userName\"]")).sendKeys("sita");
        find(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("sita@gmail.com");
        typeInto($("//*[@id=\"currentAddress\"]"),"sita@gmail.com");
        typeInto($("//*[@id=\"permanentAddress\"]"), "sita@gmail.com");
        find(By.xpath("//*[@id=\"submit\"]")).submit();

//       Set<WebElementFacade> ele3 = find(By.xpath("//*[@id=\"output\"]//p"));
//       if(ele3.size()!=0){
//           System.out.println(ele3.size()+"Element found as tag name as input \n");
//           for(WebElement inputele:ele3)
//           {
//               System.out.println(inputele.getText());
//           }
//       }


    }

}
