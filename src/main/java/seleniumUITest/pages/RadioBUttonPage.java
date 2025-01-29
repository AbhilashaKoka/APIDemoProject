package seleniumUITest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

public class RadioBUttonPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;


     @FindBy(how= How.XPATH,using="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]")
    private WebElement    Elements_Frames;
     @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Radio Button\")]")
    private WebElement   RadioButton_span;

    @FindBy(how= How.XPATH,using="//label[@for=\"yesRadio\"]//preceding::input[@type=\"radio\"]")
    private WebElement   elem;




    public void RadioBUttonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean RadioBUttonLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Elements_Frames);
        Elements_Frames.click();
        RadioButton_span.click();
        bol=true;
        return bol;
    }



    public static Boolean HandlingRadioBUtton(){
        Boolean bol=false;
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Elements_Frames.click();
        WebElement RadioButton_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Radio Button\")]"));
        RadioButton_span.click();
        driver.get("https://demoqa.com/radio-button");
        WebElement elem=driver.findElement(By.xpath("//label[@for=\"yesRadio\"]//preceding::input[@type=\"radio\"]"));
        if(!elem.isSelected()){

            elem.click();
        }
        bol=true;
        return  bol;
    }
}
