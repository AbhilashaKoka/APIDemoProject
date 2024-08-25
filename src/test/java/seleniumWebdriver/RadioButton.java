package seleniumWebdriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class RadioButton extends BaseSetUp {


    public RadioButton() {
    }

    public static void HandlingRadioBUtton(){
       setup();
        driver.get("https://demoqa.com/radio-button");
        WebElement elem=driver.findElement(By.xpath("//label[@for=\"yesRadio\"]//preceding::input[@type=\"radio\"]"));
        if(!elem.isSelected()){

            elem.click();
        }
        shutDown();
    }
}
