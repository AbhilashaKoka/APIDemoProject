package seleniumTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;


import java.util.List;


public class TextBox extends BaseSetUp {


    public static Boolean HandlingTextBox() throws InterruptedException {
       Boolean bol=false;
        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement TextBox_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
        TextBox_Span.click();
        String sText=js.executeScript("return document.title;").toString();
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        String sText1=js.executeScript("return document.title;").toString();
        System.out.println(sText1);
        String sText2=js.executeScript("return document.domain;").toString();
        System.out.println(sText2);
        String sText3=js.executeScript("return document.URL;").toString();
        System.out.println(sText3);
        js.executeScript("arguments[0].scrollIntoView;",element);
        js.executeScript("location.reload()");
        js.executeScript("document.getElementById('userName').value='sita';");
        js.executeScript("document.getElementById('userEmail').value='sita@gmail.com';");
        js.executeScript("document.getElementById('currentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('permanentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('submit').click();");
        List<WebElement> ele3=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
        if(ele3.size()!=0){
           System.out.println(ele3.size()+"Element found as tag name as input \n");
        for(WebElement inputele:ele3)
         {
           System.out.println(inputele.getText());
         }
        }
          //  System.out.println(name.toString());
        Thread.sleep(1000);
bol=true;
return bol;
    }
}
