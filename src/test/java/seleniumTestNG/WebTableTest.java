package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;


import java.util.List;

public class WebTableTest extends BaseSetUp {

    public static Boolean HandlingWebTableTest(){
        Boolean bol=false;
        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement WebTables_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Web Tables\")]"));
        WebTables_Span.click();

        WebElement searchButton=driver.findElement(By.xpath("//input[@id=\"searchBox\"]"));
        searchButton.sendKeys("Kierra", Keys.ENTER);
//        WebElement AddButton=driver.findElement(By.xpath("//Button[@id=\"addNewRecordButton\"]"));
//        WebElement EditButton=driver.findElement(By.xpath("//span[@id=\"edit-record-1\"]"));
//        WebElement DeleteButton=driver.findElement(By.xpath("//span[@id=\"delete-record-1\"]"));
//        WebElement table=driver.findElement(By.xpath(" //div[@class='rt-table']"));
//        WebElement tableHeader=driver.findElement(By.xpath(" //div[@class='rt-thead -header']"));
//        WebElement tableBody=driver.findElement(By.xpath(" //div[@class='rt-tbody']"));

         List<WebElement> RowGroup=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
         int sizeofRows=RowGroup.size();
        List<WebElement> tablerow=driver.findElements(By.xpath(" //div[@class='rt-td']"));
        int sizeofRows1=tablerow.size();
        for(WebElement row:tablerow)
        {
           row.findElement(By.xpath("//div[@class=\"action-buttons\"]//span[@title=\"Edit\"]")).click();
          //  WebElement  RegistrationWindow=driver.findElement(By.xpath("\"//div[@class=\"modal-content\"]\""));
           // WebElement RegistrationTitle= driver.findElement(By.xpath("registration-form-modal"));
            driver.switchTo().activeElement();
//          Actions action=new Actions(driver);
//          action.moveToElement(RegistrationWindow).release().build();
        //    System.out.println(RegistrationTitle.getAttribute("innerText"));

        }
        bol=true;
return bol;
        }
}