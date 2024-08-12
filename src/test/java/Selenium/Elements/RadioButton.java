package Selenium.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {
    public static void main(String args[]){
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/radio-button");
        WebElement elem=driver.findElement(By.xpath("//label[@for=\"yesRadio\"]//preceding::input[@type=\"radio\"]"));
        if(!elem.isSelected()){

            elem.click();
        }
        driver.quit();
    }
}
