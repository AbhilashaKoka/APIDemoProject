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

public class SelectablePage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;


     @FindBy(how= How.XPATH,using="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]")
    private WebElement   Interactions_Frames;
    @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Selectable\")]")
    private WebElement   Selectable_span;

    public void SelectablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean SelectableLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Interactions_Frames);
        Interactions_Frames.click();
        Selectable_span.click();
        bol=true;
        return bol;
    }



    public static Boolean HandlingSelectable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Selectable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Selectable\")]"));
        Selectable_span.click();
        bol=true;
        return bol;

    }
}
