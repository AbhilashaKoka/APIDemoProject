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

public class DroppablePage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;

   @FindBy(how= How.XPATH,using="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]")
    private WebElement Interactions_Frames;
    @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Droppable\")]")
    private WebElement Droppable_span;


    public void DroppablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean DroppableLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Interactions_Frames);
        Interactions_Frames.click();
        Droppable_span.click();
        bol=true;
        return bol;
    }



    public static Boolean HandlingDroppable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Droppable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Droppable\")]"));
        Droppable_span.click();
        bol=true;
        return bol;
    }

}
