package serenitytest;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;



@RunWith(SerenityRunner.class)
public class LoginTest extends PageObject {

    @Managed(driver="chrome")
    WebDriver driver;
//    static Actions action;
//    static Alert alert;
//    static JavascriptExecutor js;

    @Test
    public void doLogin() throws InterruptedException {
        open();
      //  driver.get("https://demoqa.com");

//       js=(JavascriptExecutor) driver;
//       js.executeScript("window.scrollBy(0,300)");
//
//
//       WebElement ele= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
//       ele.click();
//       WebElement textbox=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
//       textbox.click();
//
//
//       String sText=js.executeScript("return document.title;").toString();
//       WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
//       String sText1=js.executeScript("return document.title;").toString();
//       System.out.println(sText1);
//       String sText2=js.executeScript("return document.domain;").toString();
//       System.out.println(sText2);
//       String sText3=js.executeScript("return document.URL;").toString();
//       System.out.println(sText3);
//
//
//       js.executeScript("arguments[0].scrollIntoView;",element);
//       js.executeScript("location.reload()");
//       js.executeScript("document.getElementById('userName').value='sita';");
//       js.executeScript("document.getElementById('userEmail').value='sita@gmail.com';");
//       js.executeScript("document.getElementById('currentAddress').value='sita@gmail.com';");
//       js.executeScript("document.getElementById('permanentAddress').value='sita@gmail.com';");
//       js.executeScript("document.getElementById('submit').click();");
//       List<WebElement> ele3=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
//
//
//       if(ele3.size()!=0){
//           System.out.println(ele3.size()+"Element found as tag name as input \n");
//           for(WebElement inputele:ele3)
//           {
//               System.out.println(inputele.getText());
//           }
//       }
//
//
//       //  System.out.println(name.toString());
//       Thread.sleep(1000);
    }

}
