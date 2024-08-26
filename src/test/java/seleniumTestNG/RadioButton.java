package seleniumTestNG;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class RadioButton extends BaseSetUp {




    public static void HandlingRadioBUtton(){
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Elements_Frames.click();
        WebElement RadioButton_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Radio Button\")]"));
        RadioButton_span.click();
        driver.get("https://demoqa.com/radio-button");
        WebElement elem=driver.findElement(By.xpath("//label[@for=\"yesRadio\"]//preceding::input[@type=\"radio\"]"));
        if(!elem.isSelected()){

            elem.click();
        }

    }
}
