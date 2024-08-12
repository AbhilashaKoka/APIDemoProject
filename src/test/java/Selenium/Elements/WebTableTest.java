package Selenium.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Optional;

public class WebTableTest {
    public static void main(String args[]){
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/webtables");
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
        }
}
